<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'VIP.php');

class VIPDAO extends DAO {
	
	// Retourne un tableau de VIP ou null
	public function getLesVIP() {
		require_once(PATH_ENTITY . 'PersonneDAO.php');
		require_once(PATH_ENTITY . 'PhotoDAO.php');
		$res = $this -> queryAll('SELECT * FROM VIP');
        if ($res) {
            foreach ($res as $ligne) {
				$VIPID = $ligne['VIPID'];
				$importanceAcreditation = $ligne['importanceAcreditation'];
				$typeVIP = $ligne['typeVIP'];
				$personneDAO = new PersonneDAO();
				$personne = $personneDAO -> getPersonne($ligne['personneID']);
				$photoDAO = new PhotoDAO();
				$photo = $photoDAO -> getPhoto($ligne['photoID']);
				$conjoint = $personneDAO -> getPersonne($ligne['conjointID']);
                $tab[$i] = new VIP($VIPID, $importanceAcreditation, $typeVIP, $personne, $photo, $conjoint);
            }
            return $tab;
        }
        return null;
	}
	
	// Retourne un tableau de VIP ou null
	public function rechercherVIP($recherche) {
		require_once(PATH_ENTITY . 'PersonneDAO.php');
		require_once(PATH_ENTITY . 'PhotoDAO.php');
		$res = $this -> queryAll('SELECT * FROM VIP WHERE nom = ? OR prenom = ?', $recherche, $recherche); // Ça serait cool de faire en sorte de rechercher les VIP dont les nom/prénoms commencent par le terme de recherche
        if ($res) {
            foreach ($res as $ligne) {
				$VIPID = $ligne['VIPID'];
				$importanceAcreditation = $ligne['importanceAcreditation'];
				$typeVIP = $ligne['typeVIP'];

				$personneDAO = new PersonneDAO();
				$personne = $personneDAO -> getPersonne($ligne['personneID']);

				$photoDAO = new PhotoDAO();
				$photo = $photoDAO -> getPhoto($ligne['photoID']);

				$conjoint = $personneDAO -> getPersonne($ligne['conjointID']);
                $tab[$i] = new VIP($VIPID, $importanceAcreditation, $typeVIP, $personne, $photo, $conjoint);
            }
            return $tab;
        }
        return null;
	}
	
	// Ajoute un VIP en base
	public function ajouterVIP($nom, $prenom, $metier, $nationnalite, $age, $nomConjoint, $prenomConjoint, $nomPhoto) {
		require_once(PATH_ENTITY . 'PersonneDAO.php');
		require_once(PATH_ENTITY . 'PersonneDAO.php');
		$personneDAO = new PersonneDAO();
		$photoDAO = new PhotoDAO();

		// Test si le VIP ajouté existe dans la table personne, si non, on l'ajoute
		$personneID = $personneDAO -> existe($nom, $prenom);
		if ($personneID == false) {
			$personneID = $personneDAO -> ajouterPersonne($nom, $prenom, $metier, $nationnalite, $age);
		}

		// Si le compagnon existe et qu'il n'est pas dans la table personne, on l'ajoute
		$compagnonID = $personneDAO -> existe($nomConjoint, $prenomConjoint);
		if ($compagnonID == false) {
			$compagnonID = $personneDAO -> ajouterPersonne($nomConjoint, $prenomConjoint);
		}
		
		// Ajout de la photo en base
		$photoID = $photoDAO -> ajouterPhoto($nomPhoto);

		// Récupération d'un identifiant libre
        $res = $this -> queryRow('SELECT MAX(VIPID) FROM VIP');
		$VIPID = $res['MAX(VIPID)'] + 1;
		
		// Ajout du VIP en base
		return $this -> queryBdd("INSERT INTO VIP (VIPID, importanceAcreditation, typeVIP, photoID, compagnonID, personneID) VALUES (?, null, null, ?, ?, ?)", array($VIPID, $photoID, $compagnonID, $personneID));
	}
	
}

?>
