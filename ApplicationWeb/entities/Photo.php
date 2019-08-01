<?php

class Photo {
	
    private $_nomPhoto;
    private $_photoID;
    
    public function __construct($nomPhoto, $photoID) {
        $this -> _nomPhoto = $nomPhoto;
        $this -> _photoID = $photoID;
    }
    
    public function getNomPhoto() {
        return $this -> _nomPhoto;
    }
    
    public function setNomPhoto($nomPhoto) {
        $this -> _nomPhoto = $nomPhoto;
    }
	
	public function getPhotoID() {
        return $this -> _photoID;
    }
    
    public function setPhotoID($photoID) {
        $this -> _photoid = $photoid;
	}
	
}

?>
