<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'Photo.php');

class PhotoDAO extends DAO {
	
	// Retourne une image correspondant à son ID ou null
	public function getPhoto($id) {
        $res = $this -> queryRow("SELECT * FROM Photo WHERE photoID = ?", array($id));
        $i = 0;
        if ($res) {
            return new Photo($res['nomPhoto'], $res['photoID']);
        }
        return null;
    }
    
    // Ajoute la photo en base et retourne son ID
	public function ajouterPhoto($nomPhoto) {
        // Récupération d'un identifiant libre
        $res = $this -> queryRow('SELECT MAX(photoID) FROM Photo');
        $photoID = $res['MAX(photoID)'] + 1;

        // Ajoute la photo
        $this -> queryBdd("INSERT INTO Photo (nomPhoto, photoID) VALUES (?, ?);", array($nomPhoto, $photoID));
        return $photoID;
    }
	
}

?>
