<?php
 
const DEBUG = true; // production : false; dev : true

// Accès base de données
const BD_HOST = 'iutdoua-web.univ-lyon1.fr';
const BD_DBNAME = 'p1704709';
const BD_USER = 'p1704709';
const BD_PWD = 'cpe7ay5u';

// Langue du site
const LANG ='FR-fr';

// Paramètres du site : nom de l'auteur ou des auteurs
const AUTEUR = 'Julien GIRAUD - Mélodie GUÉRIN'; 

// Dossiers racines du site
define('PATH_CONTROLLERS', './controllers/c_');
define('PATH_ENTITY', './entities/');
define('PATH_ASSETS', './assets/');
define('PATH_LIB', './lib/');
define('PATH_MODELS', './models/m_');
define('PATH_VIEWS', './views/v_');
define('PATH_TEXTES', './languages/');

// Sous-dossiers
define('PATH_CSS', PATH_ASSETS . 'css/');
define('PATH_IMAGES', PATH_ASSETS . 'images/');
define('PATH_SCRIPTS', PATH_ASSETS . 'scripts/');
define('PATH_GALERIE', 'galerie/');
//define('PATH_LOG','log/');

// Fichiers
//define('LOG_BDD', 'logbdd.txt');
define('PATH_LOGO1', PATH_IMAGES . 'logo1.png');
define('PATH_LOGO', PATH_IMAGES . 'logo.png');
define('PATH_MENU', PATH_VIEWS . 'menu.php');

?>
