<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'Personne.php');

class PersonneDAO extends DAO {
	
	// Retourne une personne correspondant à son ID ou null
	public function getPersonne($id) {
        $res = $this -> queryRow("SELECT * FROM Personne WHERE personneID = ?", array($id));
        $i = 0;
        if ($res) {
            return new Personne($res['nom'], $res['prenom'], $res['nationnalite'], $res['personneID'], $res['age'], $res['dateNaissance'], $res['metier']);
        }
        return null;
    }

    // Ajoute la personne en base et retourne son identifiant, on part du principe qu'elle n'y existe pas
    public function ajouterPersonne($nom, $prenom, $metier = null, $nationnalite = null, $age = null, $dateNaissance = null) {
        // Récupération d'un identifiant libre
        $res = $this -> queryRow('SELECT MAX(personneID) FROM Personne');
        $personneID = $res['MAX(personneID)'] + 1;

        // Ajout de la personne
        $this -> queryBdd("INSERT INTO Personne (nom, prenom, metier, nationnalite, personneID, age, dateNaissance, juryID) VALUES (?, ?, ?, ?, ?, ?, ?, null)", array($nom, $prenom, $metier, $nationnalite, $personneID, $age, $dateNaissance));
        return $this['personneID'];
    }

    // Retourne l'identifiant de la personne si elle se trouve en base
    public function existe($nom, $prenom) {
        $res = $this -> queryRow('SELECT * FROM Personne WHERE nom = ? AND prenom = ?', array($nom, $prenom));
        if ($res) {
            return $res['personneID'];
        }
        return false;
    }
	
}

?>
