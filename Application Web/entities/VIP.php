<?php

class VIP extends Personne {
	
	private $_VIPID;
	private $_importanceAcreditation;
	private $_type;
	private $_photoID;
	private $_personneID;
	private $_photo;
	private $_conjoint;
	
	public function __construct($VIPID, $importanceAcreditation, $type, $photoID, $personneID, $photo, $conjoint) {
		$this -> _VIPID = $VIPID;
		$this -> _importanceAcreditation = $importanceAcreditation;
		$this -> _type = $type;
		$this -> _photoID = $photoID;
		$this -> _personneID = $personneID;
		$this -> _photo = $photo;
		$this -> _conjoint = $conjoint;
	}
	
	public function getVIPID() {
        return $this -> _VIPID;
    }
    
    public function setVIPID($VIPID) {
        $this -> _VIPID = $VIPID;
    }
	
	public function getImportanceAcreditation() {
        return $this -> _importanceAcreditation;
    }
    
    public function setImportanceAcreditation($importanceAcreditation) {
        $this -> _importanceAcreditation = $importanceAcreditation;
    }
	
	public function getType() {
        return $this -> _type;
    }
    
    public function setType($type) {
        $this -> _type = $type;
    }
	
	public function getPhotoID() {
        return $this -> _photoID;
    }
    
    public function setPhotoID($photoID) {
        $this -> _photoID = $photoID;
    }
	
	public function getPersonneID() {
        return $this -> _personneID;
    }
    
    public function setPersonneID($personneID) {
        $this -> _personneID = $personneID;
    }
	
	public function getPhoto() {
		return $this -> _photo;
	}
	
	public fonction setPhoto($photo) {
		$this -> _photo = $photo;
	}
	
	public function getConjoint() {
		return $this -> _conjoint;
	}
	
	public function setConjoint($conjoint) {
		$this -> _conjoint = $conjoint;
	
}

?>
