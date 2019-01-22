<?php
require_once(PATH_VIEWS . 'header.php');
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<div>
	<h3><?= 'Vous supprimez le VIP : '.$Personne -> getPrenom().' '.$Personne -> getNom()?></h3>
</div>

<div>
	<form action="index.php?page=suppressionVIP&id=<?= $VIP -> getVIPID();?>" method="post">
	Vous allez supprimer ce VIP, êtes vous sûrs de vouloir faire cela ?
		<input type='hidden' name='Supp'>
		<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Supprimer</button>
	</form>
</div>

<? require_once(PATH_VIEWS.'footer.php'); ?>