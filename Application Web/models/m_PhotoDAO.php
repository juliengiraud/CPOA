<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'Photo.php');

class PhotoDAO extends DAO {
	
	// Retourne une image correspondant à son ID ou null
	public function getPhoto($id) {
        $res = $this -> queryRow("SELECT * FROM Photo WHERE photoID = ?", $id);
        $i = 0;
        if ($res) {
            return new Photo($res['nomPhoto'], $res['photoID']);
        }
        return null;
    }
	
	public function addPhoto($nomPhoto, $photoID) {
        return $this -> queryBdd("INSERT INTO Photo (nomPhoto, photoID) VALUES (?, ?);", array($nomPhoto, $photoID));
    }

    public function getLastId() {
        return $this -> insertId();
    }
	
}

?>
