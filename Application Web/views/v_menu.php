<!-- Menu du site -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
        <?php if ($_SESSION['logged']) { ?>
				<li <?php echo ($page=='accueil' ? 'class="active"':'') ?> >
					<a href="index.php">
						<?= MENU_ACCUEIL ?>
					</a>
				</li>
		<?php } ?>
				
    </ul>
	<ul class="nav navbar-nav navbar-right">
        <?php if ($_SESSION['logged']) {
            ?>
            
            <li>
                <a href="index.php?page=deconnexion"><?= MENU_DECONNEXION ?></a>
            </li>        
            
            <?php
        }
        ?>
	</ul>
  </div>
</nav>


