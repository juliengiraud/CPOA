<?php

if (!$_SESSION['logged']) {
    header("Refresh:0; url=index.php");
    exit();
}

require_once(PATH_MODELS . 'CategorieDAO.php');
require_once(PATH_MODELS . 'PhotoDAO.php');

$c = new CategorieDAO(DEBUG);
$catList = $c -> getCategories();


function testForm() {
    
    if (!isset($_FILES['fichier'])) return(-1);
    
    if ($_FILES['fichier']['size'] == 0) return(1);
    
    if ($_FILES['fichier']['size'] > 100000) return(2);
    
    if (!in_array($_FILES['fichier']['type'], array("image/jpeg", "image/jpg", "image/png", "image/gif"))) return(3);
    
    if (htmlspecialchars($_POST['desc']) == '') return(4);
    
    if (file_exists('./' . PATH_GALERIE . 'DSC' . $_FILES['fichier']['name'])) return(5);
    
    $p = new PhotoDAO(DEBUG);
    $i = $p -> getLastId();
    if ($p -> addPhoto($i, 'DSC' . $_FILES['fichier']['name'], htmlspecialchars($_POST['desc']), $_POST['catSelected'])) {
        move_uploaded_file($_FILES['fichier']['tmp_name'], './assets/images/' . 'DSC' . $_FILES['fichier']['name']);
        return 0;
    }
    
    return(6);
    
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    
    switch(testForm()) {
        case -1:
            $alert = choixAlert('photo_file1');
            break;
        case 1:
            $alert = choixAlert('photo_file2');
            break;
        case 2:
            $alert = choixAlert('photo_size');
            break;
        case 3:
            $alert = choixAlert('photo_ext');
            break;
        case 4:
            $alert = choixAlert('photo_desc');
            break;
        case 5:
            $alert = choixAlert('photo_already_exist');
            break;
        case 0:
            $alert = choixAlert('add_photo');
            $p = new PhotoDAO(DEBUG);
            header('Refresh:1; url=index.php?page=photo&id=' . $p -> getLastId());
            break;
        default:
            $alert = choixAlert('query');
            
    }
}

require_once(PATH_VIEWS . $page . '.php');

?>
