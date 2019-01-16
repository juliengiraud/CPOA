<?php
require_once(PATH_VIEWS . 'header.php'); 
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS . 'alert.php'); ?>

<!--  Début de la page -->
<h1><?= TITRE_PAGE_ACCUEIL ?></h1>

<?php if(isset($recherche)){ ?>
	<?='Vous avez recherché : '.$recherche?>
<?php } ?>

<br>

<?php
if($VIPS!=null){
	echo '<div id = "tableau"><table class="table"><th>Nom</th><th>Prénom</th>';
	foreach ($VIPS as $VIP) {
		$personne = $VIP -> getPersonne();
		echo '<tr onclick="location.href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '"><td><a href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '" style="display:block;width:100%;height:100%;">'.$personne -> getNom().'</a></td><td><a href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '" style="display:block;width:100%;height:100%;">'.$personne -> getPrenom().'</a></td></tr>';
	}
	echo '</table></div>';
	?>
	<form action="index.php?page=ajouterVIP" method="post">
		<input class='btn' type='submit' value='Ajouter un VIP'></input>
	</form>
<?php }
else{ ?>
	<script>alert("<?php echo htmlspecialchars('Aucun VIP ne correspond à cette recherche', ENT_QUOTES); ?>")</script>
	<?php
	header('Refresh:0; url=index.php');
 } ?>



<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS . 'footer.php'); ?>

