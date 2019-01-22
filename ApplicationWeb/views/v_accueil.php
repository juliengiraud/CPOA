<?php
require_once(PATH_VIEWS . 'header.php'); 
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS . 'alert.php'); ?>

<!--  Début de la page -->
<div class = "row">
</br>
	<h1 style="color:#a35485;"><?= TITRE_PAGE_ACCUEIL ?></h1>
</div>

<?php if(isset($recherche)){ ?>
	<?='<h6 style="color:#a7ccb8;"> Vous avez recherché : '.$recherche.'</h6>'?>
<?php } ?>

<br>

<?php
if($VIPS!=null){
	echo '<div class = "row"><table class="table"><thead class="thead-dark"><tr><th scope="col">ID</th><th scope="col">Nom</th><th scope="col">Prénom</th></thead><tbody>';
	foreach ($VIPS as $VIP) {
		$personne = $VIP -> getPersonne();
		echo '<tr onclick="location.href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '"><td><a href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '" style="display:block;width:100%;height:100%;">'.$VIP -> getVIPID().'</a></td>';
		echo '<td><a href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '" style="display:block;width:100%;height:100%;">'.$personne -> getNom().'</a></td><td><a href="index.php?page=vip&id=';
		echo $VIP -> getVIPID();
		echo '" style="display:block;width:100%;height:100%;">'.$personne -> getPrenom().'</a></td></tr>';
	}
	echo '</tbody></table></div>';
?>
	<form action="index.php?page=ajouterVIP" method="post">
		<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Ajouter un VIP</button>
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

