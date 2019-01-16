<?php
require_once(PATH_VIEWS . 'header.php');
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<div>
	<h3>Ajouter un nouveau VIP</h3>
</div>

<div>
	<form action="index.php?page=ajouterVIP" method="post">
		<h4>Prénom</h4>
		<input type="text" name="Prenom"></br>
		<h4>Nom</h4>
		<input type="text" name="Nom"></br>
		<h4>Métier</h4>
		<input type="text" name="Metier"></br>
		<h4>Âge</h4>
		<input type="number" name="Age"></br>
		<h4>Date de Naissance</h4>
		<input type="date" name="Date"></br>
		<h4>Nationalité</h4>
		<input type="text" name="Nationalite"></br></br>
		<h4>Compagnon</h4>
		<h5>Prénom</h5>
		<input type="text" name="PrenomC"></br>
		<h5>Nom</h5>
		<input type="text" name="NomC"></br></br>
		<input class="btn" type="submit" value="Ajouter">
	</form>
</div>

<? require_once(PATH_VIEWS.'footer.php'); ?>