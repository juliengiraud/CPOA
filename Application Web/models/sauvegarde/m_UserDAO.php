<?php

require_once PATH_MODELS . 'DAO.php';
require_once PATH_MODELS . 'User.php';

class UserDAO extends DAO {
	
    public function connexion($username, $hash) {
		
		$user = $this -> queryRow("SELECT * FROM user WHERE username = ? AND password = ?", array($username, $hash));
		if ($user) {
				return new User($user[0], $user[1], $user[2], $user[3]);
		}
		else {
			return false;
        }
    }
    
    public function isLiked($userid, $photoid) {
        $res = $this -> queryRow("SELECT * FROM likes WHERE userid = ? AND photoid = ?", array($userid, $photoid));
        if($res) return true;
        else return false;
    }
    
    public function like($userid, $photoid) {
        if(!$this -> isLiked($userid, $photoid))
        return $this -> queryBdd("INSERT INTO likes (userid, photoid) VALUES (?, ?)", array($userid, $photoid));
        return false;
    }
    
    public function unLike($userid, $photoid) {
        if($this -> isLiked($userid, $photoid))
        return $this -> queryBdd("DELETE FROM likes WHERE userid = ? AND photoid = ?", array($userid, $photoid));
        return false;
    }
    
    public function getTotalNbLike($userid) {
		$result = 0;
		$req = $this -> queryAll("SELECT photoid FROM photo WHERE user = ?", array($userid));
		if ($req) {
            require_once PATH_MODELS . "PhotoDAO.php";
            $p = new PhotoDAO(DEBUG);
			foreach ($req as $photo) {
				$result += $p -> getNbLikes($photo[0]);
			}
        }
        return $result;
    }
    
    public function getUserByUsername($username) {
		
		$user = $this -> queryRow("SELECT * FROM user WHERE username = ? ", array($username));
		if ($user) {
            return new User($user[0], $user[1], $user[2], $user[3]);
		}
		else {
			return false;
        }
    }
    
    public function getUserById($id) {
		
		$user = $this -> queryRow("SELECT * FROM user WHERE id = ?", array($id));
		if ($user) {
				return new User($user[0], $user[1], $user[2], $user[3]);
		}
		else {
			return false;
        }
    }
    
    public function getNbPhotoByUserId($id) {
		
		$nbPhoto = $this -> queryRow("SELECT COUNT(user) FROM photo WHERE user = ? GROUP BY user", array($id));
		if ($nbPhoto) {
				return $nbPhoto[0];
		}
		else {
			return 0;
        }
    }
    
    public function getLastLogin($userid) {
		
		$lastLogin = $this -> queryRow("SELECT date FROM logconnexion WHERE id = ? ORDER BY date DESC LIMIT 1", array($userid));
		if ($lastLogin){
				return $lastLogin[0];
		}
		else {
			return "0000-00-00 00:00:00";
        }
    }
    
    public function addUser($username, $hash) {
		return $this -> queryBdd("INSERT INTO user (username, password) VALUES (?, ?)", array($username, $hash));
    }
    
    public function addLog($id, $ip) {
		return $this -> queryBdd("INSERT INTO logconnexion (id, ip) VALUES (?, ?)", array($id, $ip));
    }
    
}

?>
