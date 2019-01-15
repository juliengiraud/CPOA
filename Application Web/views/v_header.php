<!DOCTYPE html>
<html>
	<head>
		<title><?= "Festival de Cannes - Gestion des VIP" ?></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="Language" content="<?= LANG ?>"/>
		<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=0"/> 

		<link href="<?= PATH_CSS ?>bootstrap.css" rel="stylesheet"> 
		<link href="<?= PATH_CSS ?>css.css" rel="stylesheet">
		
	</head> 
	<body>
		<!-- En-tête -->
		<header class="header" >
			<section class="container" >
				<div class = "row">
					<div class = "col-md-2 col-sm-2 col-xs-12">
						<img src="<?= PATH_LOGO ?>" alt="<?= LOGO ?>" height="60"/>
					</div>
					<?php if ($_SESSION['logged']) { ?>
					<div class="col-md-9 col-sm-9 col-xs-12">
							
						<nav class="navbar navbar-default">
							<div class="container-fluid">
    
								<?php if ($_SESSION['logged']) { ?>
									<ul class="nav navbar-nav">
										<li <?php echo ($page=='accueil' ? 'class="active"':'') ?> >
											<a href="index.php">
												<?= MENU_ACCUEIL ?>
											</a>
										</li>
										<li>
											<form action="index.php?page=accueil" method="post">
												<input type="text" name="recherche">
												<input class="btn" type="submit" value="Rechercher">
											</form>
										</li>
									</ul>
									<ul class="nav navbar-nav navbar-right">
										<li>
											<a href="index.php?page=deconnexion"><?= MENU_DECONNEXION ?></a>
										</li>
									</ul>
								<?php } ?>
							</div>
						</nav>
						
					</div>
					<?php } ?>
				</div>
			</section>
		</header>
		<!-- Menu -->
		<?php include(PATH_VIEWS . 'menu.php'); ?>
		<!-- Vue -->
			<section class="container">
				<div class = "row">
					<?php if ($_SESSION['logged']) { ?>
						<h3>Vous êtes connecté en temps que : <b><?= $_SESSION["user"] -> getUsername() ?></b></h3>
					<?php } ?>
