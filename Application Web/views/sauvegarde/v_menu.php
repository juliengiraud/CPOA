<!-- Menu du site -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
				<li <?php echo ($page=='accueil' ? 'class="active"':'') ?> >
					<a href="index.php">
						<?= MENU_ACCUEIL ?>
					</a>
				</li>
				
				<?php if ($_SESSION['logged']) { ?>
				<li <?php echo ($page=='addPhoto' ? 'class="active"':'')?> >
					<a href="index.php?page=addPhoto">
						<?= MENU_ADDPHOTO ?>
					</a>
				</li>
                <li <?php echo ($page=='addCat' ? 'class="active"':'')?> >
					<a href="index.php?page=addCat">
						<?= MENU_ADDCAT ?>
					</a>                
                </li>
				<?php } ?>
    </ul>
	<ul class="nav navbar-nav navbar-right">
        <?php if (!$_SESSION['logged']) { ?>
        <li <?php echo ($page=='inscription' ? 'class="active"':'')?> >
            <a href="index.php?page=inscription"><?= MENU_INSCRIPTION ?></a>
        </li>
        <li <?php echo ($page=='connexion' ? 'class="active"':'')?> >
            <a href="index.php?page=connexion"><?= MENU_CONNEXION ?></a>
        </li>
        <?php } else { ?>
        
        <li>
            <a href="index.php?page=profil&id=<?= $_SESSION["user"] -> getId() ?>"><?= $_SESSION["user"] -> getUsername() ?></a>
        </li>
        
        <li>
            <a href="index.php?page=deconnexion"><?= MENU_DECONNEXION ?></a>
        </li>        
        
        <?php } ?>
	</ul>
  </div>
</nav>


