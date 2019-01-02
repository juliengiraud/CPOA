<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'Photo.php');

class PhotoDAO extends DAO {
	// Retourne un tableau d'images ou null
    public function getPhotos() {
        $res = $this -> queryAll('SELECT * FROM photo');
        $i = 0;
        if ($res) {
            foreach ($res as $ligne) {
                $tab[$i] = new Photo($ligne['photoid'], $ligne['nomfich'], $ligne['description'], $ligne['catid']);
                $i++;
            }
            return $tab;
        }
        return null;
    }
	
	// Retourne un tableau d'images correspondant à une catégorie ou null
	public function getPhotosCat($catid) {
        $res = $this -> queryAll('SELECT * FROM photo WHERE catid = ' . $catid);
        $i = 0;
        if ($res) {
            foreach ($res as $ligne) {
                $tab[$i] = new Photo($ligne['photoid'], $ligne['nomfich'], $ligne['description'], $ligne['catid']);
                $i++;
            }
            return $tab;
        }
        return null;
    }
	
	// Retourne une image correspondant à son ID ou null
	public function getPhotoById($id) {
        $res = $this -> queryRow('SELECT * FROM photo WHERE photoid = ' . $id);
        $i = 0;
        if ($res) {
            return new Photo($res['photoid'], $res['nomfich'], $res['description'], $res['catid']);
        }
        return null;
    }
	
	public function addPhoto($photoid, $nomFichier, $description, $catid) {
        return $this -> queryBdd("INSERT INTO photo (photoid, nomfich, description, catid) VALUES (?, ?, ?, ?);", array($photoid, $nomFichier, $description, $catid));
    }

    public function getLastId() {
        return $this -> insertId();
    }
}

?>
