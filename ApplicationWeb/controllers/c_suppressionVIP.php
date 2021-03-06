<?php

require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');


if (!$_SESSION['logged']) {
    header('Refresh:0; url=index.php?page=connexion');
    exit();
}

if(isset($_GET['id'])){
	$VIPDAO = new VIPDAO();
	$VIP = $VIPDAO -> getVIP(htmlspecialchars($_GET['id']));
	$Personne = $VIP -> getPersonne();
	$Photo = $VIP -> getPhoto();
	$Compagnon = $VIP -> getCompagnon();

	if (isset($_POST['Supp'])) {;
		$PersonneDAO = new PersonneDAO();
		$PhotoDAO = new PhotoDAO();
		$VIPDAO -> supprimerVIP($_GET['id']);
		$PersonneDAO -> supprimerPersonne($Personne -> getPersonneID());
		$PhotoDAO -> supprimerPhoto($Photo -> getPhotoID());
		
		header('Refresh:0; url=index.php');
	}
}

// Appel de la vue
require_once(PATH_VIEWS . $page . '.php');
?>