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
	
}

if (isset($_POST['Prenom']) && isset($_POST['Nom']) && isset($_POST['Metier']) && isset($_POST['Age']) && isset($_POST['Date']) && isset($_POST['Nationalite']) && isset($_POST['PrenomC']) && isset($_POST['NomC'])) {
	$VIPDAO -> supprimerVIP($_GET['id']);
	
    $prenom = htmlspecialchars($_POST['Prenom']);
	$nom = htmlspecialchars($_POST['Nom']);
	$metier = htmlspecialchars($_POST['Metier']);
	$age = htmlspecialchars($_POST['Age']);
	$date = htmlspecialchars($_POST['Date']);
	$nationalite = htmlspecialchars($_POST['Nationalite']);
	$prenomCompagnon = htmlspecialchars($_POST['PrenomC']);
	$nomCompagnon = htmlspecialchars($_POST['NomC']);
	$nomPhoto = '';
	
	$VIPDAO = new VIPDAO();
	$VIPID = $VIPDAO -> ajouterVIP($nom, $prenom, $metier, $nationalite, $age, $nomCompagnon, $prenomCompagnon, $nomPhoto);
	header('Refresh:0; url=index.php?page=vip&id='.$VIPID);
}


// Appel de la vue
require_once(PATH_VIEWS . $page . '.php');
?>