<?php

class User {
	private $id;
	private $username;
    private $dateInscription;
	
	public function __construct($id, $username, $password, $dateInscription) {
		$this -> id = $id;
		$this -> username = $username;
		$this -> password = $password;
        $this -> dateInscription = $dateInscription;
	}
	
	public function getId() {
		return $this -> id;
	}
	
	public function getUsername() {
		return htmlspecialchars($this -> username);
	}
    
    public function getPassword() {
		return htmlspecialchars($this -> password);
	}
    
    public function getDateInscription() {
		return htmlspecialchars($this -> dateInscription);
	}
	
}

?>
