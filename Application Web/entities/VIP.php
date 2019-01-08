<?php

class VIP extends Personne {
	
	private $_VIPID;
	private $_importanceAcreditation;
	private $_typeVIP;
	private $_personne;
	private $_photo;
	private $_conjoint;
	
	public function __construct($VIPID, $importanceAcreditation, $typeVIP, $personne, $photo, $conjoint) {
		$this -> _VIPID = $VIPID;
		$this -> _importanceAcreditation = $importanceAcreditation;
		$this -> _typeVIP = $typeVIP;
		$this -> _personne = $personne;
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
	
	public function getTypeVIP() {
        return $this -> _typeVIP;
    }
    
    public function setTypeVIP($typeVIP) {
        $this -> _type = $type;
    }
	
	public function getPersonne() {
        return $this -> _personne;
    }
    
    public function setPersonne($personne) {
        $this -> _personne = $personne;
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
