<?php

if (!$_SESSION['logged']) {
    header('Refresh:0; url=index.php?page=connexion');
    exit();
}

// Gestion des erreurs
if (isset($erreur)) {
    $alert = choixAlert($erreur);
}

// Appel de la vue
require_once(PATH_VIEWS . $page . '.php');

?>

