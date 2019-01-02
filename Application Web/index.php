<?php
// Initialisation des paramètres du site
require_once('./config/configuration.php');
require_once('./lib/foncBase.php');

require_once(PATH_ENTITY. 'User.php');
session_start();

if (!isset($_SESSION['lang'])) $_SESSION['lang'] = LANG;

if (isset($_POST['lang'])) $_SESSION['lang'] = $_POST['lang'];

require_once(PATH_TEXTES . $_SESSION['lang'] . '.php');

if (!isset($_SESSION['logged'])) $_SESSION['logged'] = false;

// Vérification de la page demandée 

if (isset($_GET['page'])) {
    $page = htmlspecialchars($_GET['page']); // http://.../index.php?page=toto
    if (!is_file(PATH_CONTROLLERS . $_GET['page'] . '.php')) { 
        $page = '404'; //page demandée inexistante
    }
}
else
	$page = 'accueil'; //page d'accueil du site - http://.../index.php

// Appel du controlleur
require_once(PATH_CONTROLLERS . $page . '.php'); 

?>
