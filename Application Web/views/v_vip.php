<?php
require_once(PATH_VIEWS . 'header.php');
require_once(PATH_ENTITY.'VIP.php'); 
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'PersonneDAO.php');
?>

<p><?= $VIP -> getVIPID() ?></p>

<? require_once(PATH_VIEWS.'footer.php'); ?>