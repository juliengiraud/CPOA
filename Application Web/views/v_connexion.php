<?php require_once(PATH_VIEWS . 'header.php'); ?>


<!--  Début de la page -->






<?php if (!$_SESSION['logged']) { ?>
	<div class="container text-center">
		<form action="index.php?page=connexion" class="form-signin" method="post">
			<img class="mb-4" src="<?= PATH_LOGO ?>" alt="<?= LOGO ?>" height="150">
			<h1 class="h3 mb-3 font-weight-normal"><?= TITRE_PAGE_CONNEXION ?></h1>
			<br>
			<div class="container text-center col-md-4">
			<!--  Zone message d'alerte -->
			<?php require_once(PATH_VIEWS . 'alert.php'); ?>
				<input type="text" class="form-control" placeholder="Identifiant" name="username">
				<input type="password" class="form-control" placeholder="Mot de passe" name="pass">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</div>
		</form>
	</div>
<?php } ?>


<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS . 'footer.php'); ?>

