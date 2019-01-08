<?php require_once(PATH_VIEWS . 'header.php'); ?>


<!--  Début de la page -->
<?php if (!$_SESSION['logged']) { ?>

<!--  Zone message d'alerte -->
<h1><?= TITRE_PAGE_CONNEXION ?></h1>

<?php } ?>

<?php require_once(PATH_VIEWS . 'alert.php'); ?>

<?php if (!$_SESSION['logged']) { ?>

	<div class="col-xs-8 col-sm-6 col-md-4">

		<form action="index.php?page=connexion" method="post" class="well">
			<div class="form-group">
				<label><?= FORM_CONNEXION_IDENTIFIANT ?></label>
				<input type="text" name="username">
			</div>

			<div class="form-group">
				<label><?= FORM_CONNEXION_MDP ?></label>
				<input type="password" name="pass">
			</div>
        
			<br>
        
			<input class="btn" type="submit" value="<?= BUTTON_CONNEXION ?>">

		</form>
</div>

<?php } ?>


<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS . 'footer.php'); ?>

