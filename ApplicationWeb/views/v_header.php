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
	<body style="background-color :#f9f4ed;">
		<!-- En-tête -->
		<header class="header" >
			<section class="container" >
				<div class = "row">
					<?php if ($_SESSION['logged']) { ?>
					
					<!-- Menu -->
						<nav class="navbar navbar-expand-lg navbar-light container-fluid" style="background-color: #ffa62b;">
							<img src="<?= PATH_LOGO ?>" alt="<?= LOGO ?>" height="50"/>
							<div class="container-fluid">
								<ul class="nav nav-pills navbar-nav">
									<li class="nav-item" <?php echo ($page=='accueil' ? 'class="active"':'') ?>>
										<a class="btn btn-outline-success my-2 my-sm-0" href="index.php" style="text-align : center;"><?= MENU_ACCUEIL ?></a>
									</li>
								</ul>
								<ul class="nav nav-pills">
									<li class="nav-item">
										<form class="form-inline" action="index.php?page=accueil" method="post">
											<input class="form-control mr-sm-2" type="search" placeholder="Recherche" name='recherche' style="width=auto;">
											<button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="margin:auto;">Rechercher</button>
										</form>
									</li>
								</ul>
								<ul class="nav nav-pills">
									<li class="nav-item">
										<form class="form-inline my-2 my-lg-0" action="index.php?page=deconnexion" method="post">
											<button class="btn btn-outline-danger my-2 my-sm-0" type="submit"><?= MENU_DECONNEXION ?></button>
										</form>
									</li>
								</ul>
							</div>
						</nav>

					<?php } ?>
				</div>
			</section>
		</header>
		<!-- Vue -->
			<section class="container">
				<div class = "row">
					<?php if ($_SESSION['logged']) { ?>
						<h5 style="color:#a7ccb8;">Vous êtes connecté en temps que : <b><?= $_SESSION["user"] -> getUsername() ?></b></h5>
					<?php } ?>
				</div>
