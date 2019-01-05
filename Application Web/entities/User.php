<?php

class User {
	private $userID;
	private $username;
	private $password;
	
	public function __construct($newUserID, $newUsername, $newPassword) {
		$this -> userID = $newUserID;
		$this -> username = $newUsername;
		$this -> password = $newPassword;
	}
	
	public function getUserID() {
		return $this -> $userID;
	}
	
	public function getUsername() {
		return htmlspecialchars($this -> username);
	}
    
    public function getPassword() {
		return htmlspecialchars($this -> password);
	}
	
}

?>
