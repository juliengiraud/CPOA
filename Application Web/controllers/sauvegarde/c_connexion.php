<?php

if ($_SESSION['logged']) {
    header('Refresh:0; url=index.php');
}

if (isset($_POST['username']) && (isset($_POST['pass']) {
    $username = htmlspecialchars($_POST['username']);
    $pass = htmlspecialchars($_POST['pass']);
    
    require_once(PATH_MODELS . 'UserDAO.php');
    $u = new UserDAO(DEBUG);
    
	if (!$u -> getUserByUsername($username)) {
        $alert = choixAlert('login_id');
		require_once(PATH_VIEWS . $page . '.php');
        exit();
	}
    
    $user = $u -> connexion($username, sha1($pass));
    
	if (!$user) {
        $alert = choixAlert('login_pass');
		require_once(PATH_VIEWS . $page . '.php');
        exit();
	}
    
    $u -> addLog($user -> getId(), $_SERVER['REMOTE_ADDR']);
    
    $alert = choixAlert('connexion', $user -> getUsername());
    
	$_SESSION['logged'] = true;
    $_SESSION['user'] = $user;
    
    header("Refresh:10; url=index.php");
}

require_once(PATH_VIEWS . $page . '.php');

?>
