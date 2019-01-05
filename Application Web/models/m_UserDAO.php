<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'User.php');

class UserDAO extends DAO {
	
    public function connexion($username, $hash) {
		
		$ligne = $this -> queryRow("SELECT * FROM User WHERE username = ? AND password = ?", array($username, $hash));
		if ($ligne) {
				return new User($ligne['userID'], $ligne['username'], $ligne['password']);
		}
		else {
			return false;
        }
    }
    
    public function getUserByUsername($username) {
		
		$ligne = $this -> queryRow("SELECT * FROM User WHERE username = ? ", array($username));
		if ($ligne) {
            return new User($ligne['userID'], $ligne['username'], $ligne['password']);
		}
		else {
			return false;
        }
    }
    
    public function getUserById($id) {
		
		$ligne = $this -> queryRow("SELECT * FROM User WHERE id = ?", array($id));
		if ($ligne) {
				return new User($ligne['userID'], $ligne['username'], $ligne['password']);
		}
		else {
			return false;
        }
    }

}

?>
