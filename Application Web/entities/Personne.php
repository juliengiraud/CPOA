<?php

class Personne {
	
	private $_nom;
	private $_prenom;
	private $_nationnalite;
	private $_personneID;
	private $_age;
	private $_dateNaissance;
	private $_metier;
	
	public function __construct($nom, $prenom, $nationnalite, $personneID, $age, $dateNaissance, $metier) {
		$this -> _nom = $nom;
		$this -> _prenom = $prenom;
		$this -> _nationnalite = $nationnalite;
		$this -> _personneID = $personneID;
		$this -> _age = $age;
		$this -> _dateNaissance = $dateNaissance;
		$this -> _metier = $metier;
	}
	
	public function getNom() {
        return $this -> _nom;
    }
    
    public function setNom($nom) {
        $this -> _nom = $nom;
    }
	
	public function getPrenom() {
        return $this -> _prenom;
    }
    
    public function setPrenom($prenom) {
        $this -> _prenom = $prenom;
    }
	
	public function getNationnalite() {
        return $this -> _nationnalite;
    }
    
    public function setNationnalite($nationnalite) {
        $this -> _nationnalite = $nationnalite;
    }
	
	public function getPersonneID() {
        return $this -> _personneID;
    }
    
    public function setPersonneID($personneID) {
        $this -> _personneID = $personneID;
    }
	
	public function getAge() {
        return $this -> _age;
    }
    
    public function setAge($age) {
        $this -> _age = $age;
    }
	
	public function getDateNaissance() {
        return $this -> _dateNaissance;
    }
    
    public function setDateNaissance($dateNaissance) {
        $this -> _dateNaissance = $dateNaissance;
    }
	
	public function getMetier() {
        return $this -> _metier;
    }
    
    public function setMetier($metier) {
        $this -> _metier = $metier;
    }
	
}

?>
