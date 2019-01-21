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
					<div class = "col-md-2 col-sm-2 col-xs-12">
						<img src="<?= PATH_LOGO ?>" alt="<?= LOGO ?>" height="60"/>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-12">
						<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffa62b;">
							<div class="container-fluid">
								<ul class="nav nav-pills navbar-nav">
								  <li class="nav-item" <?php echo ($page=='accueil' ? 'class="active"':'') ?>>
									<a class="nav-link active" href="index.php" style="text-align : center;"><?= MENU_ACCUEIL ?></a>
								  </li>
								  </ul>
								  <ul class="nav navbar-nav nav-pills navbar-right">
								   <li class="nav-item">
									<form class="form-inline my-2 my-lg-0" action="index.php?page=accueil" method="post">
										<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name='recherche'>
										<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
									</form>
								  </li>
								  <li class="nav-item">
									<form class="form-inline my-2 my-lg-0" action="index.php?page=deconnexion" method="post">
										<button class="btn btn-outline-danger my-2 my-sm-0" type="submit"><?= MENU_DECONNEXION ?></button>
									</form>
								  </li>
								</ul>
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
				</div>
