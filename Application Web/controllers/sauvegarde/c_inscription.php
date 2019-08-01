<?php

if ($_SESSION['logged']) header("Refresh:0; url=index.php");

function testForm($user, $pass) {
    
    require_once(PATH_MODELS . 'UserDAO.php');
    $u = new UserDAO(DEBUG);
    if (strlen($user) < 4 or strlen($user) > 20) return 1;
    if (strlen($pass) < 4) return 2;
    if ($u -> getUserByUsername($user)) return 3;
    
    if ($u -> addUser($user, sha1($pass))) return 0;
    
    return 10;
}

if (isset($_POST['username']) && (isset($_POST['pass']) {
    $username = htmlspecialchars($_POST['username']);
    $pass = htmlspecialchars($_POST['pass']);
    
    switch(testForm($username, $pass)) {
        case 1:
            $alert = choixAlert('register_longueur_id');
            break;
        case 2:
            $alert = choixAlert('register_longueur_pass');
            break;
        case 3:
            $alert = choixAlert('register_already_exist');
            break;
        case 10:
            $alert = choixAlert('query');
            break;
        case 0:
            require_once(PATH_MODELS . 'UserDAO.php');
            $u = new UserDAO(DEBUG);
            
            $user = $u -> getUserByUsername($username);
            $u -> addLog($user -> getId(), $_SERVER['REMOTE_ADDR']);
            
            $_SESSION['logged'] = true;
            $_SESSION['user'] = $user;
            
            $alert = choixAlert('inscription', $user -> getUsername());
            
            //header("Refresh:2; url=index.php");
            break;
    }
}

require_once(PATH_VIEWS.$page.'.php');

?>
