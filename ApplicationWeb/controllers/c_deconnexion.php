<?php

$_SESSION['logged'] = false;
$page = 'accueil';
header("Refresh:0; url=index.php");

require_once(PATH_CONTROLLERS . 'accueil.php');

?>
