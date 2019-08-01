<?php require_once(PATH_VIEWS . 'header.php'); ?>
<?php require_once(PATH_MODELS . 'VIPDAO.php'); ?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS . 'alert.php'); ?>

<!--  Début de la page -->
<h1><?= TITRE_PAGE_ACCUEIL ?></h1>


<p>BONJOUR</p>
<?php
$VIPDAO = new VIPDAO();
$VIPS = $VIPDAO -> getLesVIP();
foreach ($VIPS as $VIP) {
	$personne = $VIP -> getPersonne();
	$compagnon = $VIP -> getCompagnon();
	$photo = $VIP -> getPhoto();
	echo '<p>VIPID : ' . $VIP -> getVIPID() . '</p>';
    echo '<p>Importance : ' . $VIP -> getImportanceAcreditation() . '</p>';
	echo '<p>Type VIP : ' . $VIP -> getTypeVIP() . '</p>';
	echo '<p>Nom : ' . $personne -> getNom() . '</p>';
	echo '<p>Prenom : ' . $personne -> getPrenom() . '</p>';
	echo '<p>Nationnalite : ' . $personne -> getNationnalite() . '</p>';
	echo '<p>PersonneID : ' . $personne -> getPersonneID() . '</p>';
	echo '<p>Age : ' . $personne -> getAge() . '</p>';
	echo '<p>Date de naissance : ' . $personne -> getDateNaissance() . '</p>';
	echo '<p>Métier : ' . $personne -> getMetier() . '</p>';
	echo '<p>Nom du fichier photo : ' . $photo -> getNomPhoto() . '</p>';
	echo '<p>ID de la photo : ' . $photo -> getPhotoID() . '</p>';
	if ($compagnon == null) {
		echo 'Compagnon null';
	}
	else {
		echo '<p>Nom du compagnon : ' . $compagnon -> getNom() . '</p>';
		echo '<p>Prenom du compagnon : ' . $compagnon -> getPrenom() . '</p>';
		echo '<p>Nationnalite du compagnon : ' . $compagnon -> getNationnalite() . '</p>';
		echo '<p>PersonneID du compagnon : ' . $compagnon -> getPersonneID() . '</p>';
		echo '<p>Age du compagnon : ' . $compagnon -> getAge() . '</p>';
		echo '<p>Date de naissance du compagnon : ' . $compagnon -> getDateNaissance() . '</p>';
		echo '<p>Métier du compagnon : ' . $compagnon -> getMetier() . '</p>';
	}
}
?>


<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS . 'footer.php'); ?>

