<?php
require_once(PATH_VIEWS . 'header.php');
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<div>
	<h3><?= 'Vous modifiez le VIP : '.$Personne -> getPrenom().' '.$Personne -> getNom()?></h3>
</div>

<div>
	<form action="index.php?page=modifierVIP&id=<?= $VIP -> getVIPID();?>" method="post">
		<h4><?=$VIP -> getVIPID()?></h4>
		<h4>Prénom</h4>
		<input type="text" name="Prenom" value="<?= $Personne -> getPrenom()?>"></br>
		<h4>Nom</h4>
		<input type="text" name="Nom" value="<?=$Personne -> getNom()?>"></br>
		<h4>Métier</h4>
		<input type="text" name="Metier" value="<?=$Personne -> getMetier()?>"></br>
		<h4>Âge</h4>
		<input type="number" name="Age" value="<?=$Personne -> getAge()?>"></br>
		<h4>Date de Naissance</h4>
		<input type="date" name="Date" value="<?=$Personne -> getDateNaissance()?>"></br>
		<h4>Nationalité</h4>
		<input type="text" name="Nationalite" value="<?=$Personne -> getNationalite()?>"></br></br>
		<h4>Compagnon</h4>
		<h5>Prénom</h5>
		<input type="text" name="PrenomC" value="<?php if(isset($Compagnon)) echo $Compagnon -> getPrenom();?>"></br>
		<h5>Nom</h5>
		<input type="text" name="NomC" value="<?php if(isset($Compagnon)) echo $Compagnon -> getNom();?>"></br></br>
		<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Modifier</button>
	</form>
</div>

<? require_once(PATH_VIEWS.'footer.php'); ?>