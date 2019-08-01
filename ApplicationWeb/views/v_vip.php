<?php
require_once(PATH_VIEWS . 'header.php');
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<div>
	<h3><?= $Personne -> getPrenom().' '.$Personne -> getNom()?></h3>
	</br>
	<p>
	<?php
		echo '<div class="row"><div class="col-md-4 order-md-1 mb-4"><img alt="Photo" src="'.PATH_IMAGES.$Photo -> getNomPhoto().'" style=width:60%;></div>';
		echo '<div class="col-md-8 order-md-2">ID : '.$VIP -> getVIPID().'</br>';
		echo 'Métier : '.$Personne -> getMetier().'</br>';
		echo 'Âge : '.$Personne -> getAge().'</br>';
		echo 'Date de naissance : '.$Personne -> getDateNaissance().'</br>';
		echo 'Nationalité : '.$Personne -> getNationalite().'</br>';
		if(isset($Compagnon)){
			echo 'Compagnon : '.$Compagnon -> getPrenom().' '.$Compagnon -> getNom().'</br>';
		}
	?>
	</div>
	</div>
	
	</p>
</div>

<div>
	<form action="index.php?page=modifierVIP&id=<?= $VIP -> getVIPID();?>" method="post">
		<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Modifier</button>
	</form>
	<form action="index.php?page=suppressionVIP&id=<?= $VIP -> getVIPID();?>" method="post">
		<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Supprimer</button>
	</form>
</div>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS . 'footer.php'); ?>