
<?php

require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');


if (!$_SESSION['logged']) {
    header('Refresh:0; url=index.php?page=connexion');
    exit();
}

$VIPDAO = new VIPDAO();
$VIPS = $VIPDAO -> getLesVIP();

if(isset($_POST['recherche']) && (strlen($_POST['recherche']) > 0)){
	$recherche = htmlspecialchars($_POST['recherche']);
	$VIPS = $VIPDAO -> rechercherVIP($recherche);
}

// Gestion des erreurs
if (isset($erreur)) {
	$alert = choixAlert("VIPNonTrouvé");
}

// Appel de la vue
require_once(PATH_VIEWS . $page . '.php');

?>

