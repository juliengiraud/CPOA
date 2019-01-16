<?php

require_once(PATH_MODELS . 'DAO.php');
require_once(PATH_ENTITY . 'VIP.php');

class VIPDAO extends DAO {
	
	// Retourne un tableau de VIP ou null
	public function getLesVIP() {
		require_once(PATH_MODELS . 'PersonneDAO.php');
		require_once(PATH_MODELS . 'PhotoDAO.php');
		$res = $this -> queryAll('SELECT * FROM VIP');
		$i = 0;
        if ($res) {
            foreach ($res as $ligne) {
				$VIPID = $ligne['VIPID'];
				$importanceAcreditation = $ligne['importanceAcreditation'];
				$typeVIP = $ligne['typeVIP'];
				$personneDAO = new PersonneDAO();
				$personne = $personneDAO -> getPersonne($ligne['personneID']);
				$photoDAO = new PhotoDAO();
				$photo = $photoDAO -> getPhoto($ligne['photoID']);
				$compagnon = $personneDAO -> getPersonne($ligne['compagnonID']);
                $tab[$i] = new VIP($VIPID, $importanceAcreditation, $typeVIP, $personne, $photo, $compagnon);
				$i++;
            }
            return $tab;
        }
        return null;
	}

	public function getVIP($id) {
		require_once(PATH_MODELS . 'PersonneDAO.php');
		require_once(PATH_MODELS . 'PhotoDAO.php');
		$res = $this -> queryRow('SELECT * FROM VIP WHERE VIPID = ?', array($id));
        if ($res) {
            $VIPID = $res['VIPID'];
			$importanceAcreditation = $res['importanceAcreditation'];
			$typeVIP = $res['typeVIP'];
			$personneDAO = new PersonneDAO();
			$personne = $personneDAO -> getPersonne($res['personneID']);
			$photoDAO = new PhotoDAO();
			$photo = $photoDAO -> getPhoto($res['photoID']);
			$compagnon = $personneDAO -> getPersonne($res['compagnonID']);
			return new VIP($VIPID, $importanceAcreditation, $typeVIP, $personne, $photo, $compagnon);
        }
        return null;
	}
	
	// Retourne un tableau de VIP ou null
	public function rechercherVIP($recherche) {
		require_once(PATH_MODELS . 'PersonneDAO.php');
		require_once(PATH_MODELS . 'PhotoDAO.php');
		$mots = explode(" ", $recherche);
		$requette = "SELECT * FROM VIP JOIN Personne ON VIP.personneID = Personne.personneID WHERE nom REGEXP'" . $mots[0] . "' OR prenom REGEXP'" . $mots[0] ."'";
		for ($i = 1; $i < count($mots); $i++) {
			$requette = $requette . " OR nom REGEXP'" . $mots[$i] . "' OR prenom REGEXP'" . $mots[$i] . "'";
		}
		$res = $this -> queryAll($requette);
		$i = 0;
        if ($res) {
            foreach ($res as $ligne) {
				$VIPID = $ligne['VIPID'];
				$importanceAcreditation = $ligne['importanceAcreditation'];
				$typeVIP = $ligne['typeVIP'];

				$personneDAO = new PersonneDAO();
				$personne = $personneDAO -> getPersonne($ligne['personneID']);

				$photoDAO = new PhotoDAO();
				$photo = $photoDAO -> getPhoto($ligne['photoID']);

				$compagnon = $personneDAO -> getPersonne($ligne['compagnonID']);
				$tab[$i] = new VIP($VIPID, $importanceAcreditation, $typeVIP, $personne, $photo, $compagnon);
				$i++;
            }
            return $tab;
        }
        return null;
	}
	
	// Ajoute un VIP en base
	public function ajouterVIP($nom, $prenom, $metier, $nationalite, $age, $nomCompagnon, $prenomCompagnon, $nomPhoto) {
		require_once(PATH_MODELS . 'PersonneDAO.php');
		require_once(PATH_MODELS . 'PhotoDAO.php');
		$personneDAO = new PersonneDAO();
		$photoDAO = new PhotoDAO();

		// Test si le VIP ajouté existe dans la table personne, si non, on l'ajoute
		$personneID = $personneDAO -> existe($nom, $prenom);
		if ($personneID == false) {
			$personneID = $personneDAO -> ajouterPersonne($nom, $prenom, $metier, $nationalite, $age);
		}

		// Si le compagnon existe et qu'il n'est pas dans la table personne, on l'ajoute
		$compagnonID = $personneDAO -> existe($nomCompagnon, $prenomCompagnon);
		if ($compagnonID == false) {
			$compagnonID = $personneDAO -> ajouterPersonne($nomCompagnon, $prenomCompagnon);
		}
		
		// Ajout de la photo en base
		$photoID = $photoDAO -> ajouterPhoto($nomPhoto);

		// Récupération d'un identifiant libre
        $res = $this -> queryRow('SELECT MAX(VIPID) FROM VIP');
		$VIPID = $res['MAX(VIPID)'] + 1;
		
		// Ajout du VIP en base
		$this -> queryBdd("INSERT INTO VIP (VIPID, importanceAcreditation, typeVIP, photoID, compagnonID, personneID) VALUES (?, null, null, ?, ?, ?)", array($VIPID, $photoID, $compagnonID, $personneID));
		return $VIPID;
	}

	public function supprimerVIP($id) {
		return $this -> queryBdd("DELETE FROM VIP WHERE VIPID = ?", array($id));
	}
	
}

?>
