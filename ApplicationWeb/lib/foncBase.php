<?php

function choixAlert($message, $arg=null) {
    $alert = array();
    switch($message) {
        //Erreures
		case 'VIPNonTrouvé' :
			$alert['messageAlert'] = ERREUR_RECHERCHE_VIP;
        case 'categorie' :
	        $alert['messageAlert'] = ERREUR_ID_CATEGORIE;
	        break;
	    case 'photo' :
	        $alert['messageAlert'] = ERREUR_ID_PHOTO;
	        break;
        case 'connexion_bdd':
            $alert['messageAlert'] = ERREUR_CONNECT_BDD;
            break;
        case 'query' :
            $alert['messageAlert'] = ERREUR_QUERY;
            break;
        case 'url_non_valide' :
            $alert['messageAlert'] = TEXTE_PAGE_404;
            break;
        case 'captcha' :
            $alert['messageAlert'] = ERREUR_CAPTCHA;
            break;
        case 'cat_empty' :
            $alert['messageAlert'] = ERREUR_FORM_CAT_EMPTY;
            break;
        case 'cat_already_exist' :
            $alert['messageAlert'] = ERREUR_FORM_CAT_ALREADYEXIST;
            break;
        case 'cat_longueur' :
            $alert['messageAlert'] = ERREUR_FORM_CAT_LONGUEUR;
            break;
        case 'photo_file1' :
            $alert['messageAlert'] = ERREUR_FORM_PHOTO_FILE1;
            break;
        case 'photo_file2' :
            $alert['messageAlert'] = ERREUR_FORM_PHOTO_FILE2;
            break;
        case 'photo_size' :
            $alert['messageAlert'] = ERREUR_FORM_PHOTO_SIZE;
            break;
        case 'photo_ext' :
            $alert['messageAlert'] = ERREUR_FORM_PHOTO_EXT;
            break;
        case 'photo_desc' :
            $alert['messageAlert'] = ERREUR_FORM_PHOTO_DESC;
            break;
        case 'photo_already_exist' :
            $alert['messageAlert'] = ERREUR_FORM_PHOTO_ALREADYEXIST;
            break;
        case 'login_id' :
            $alert['messageAlert'] = ERREUR_FORM_CONNEXION_UNKNOWID;
            break;
        case 'login_pass' :
            $alert['messageAlert'] = ERREUR_FORM_CONNEXION_PASSWORD;
            break;
        case 'register_longueur_id' :
            $alert['messageAlert'] = ERREUR_FORM_INSCRIPTION_LONGUEURID;
            break;
        case 'register_longueur_pass' :
            $alert['messageAlert'] = ERREUR_FORM_INSCRIPTION_LONGUEURMDP;
            break;
        case 'register_already_exist' :
            $alert['messageAlert'] = ERREUR_FORM_INSCRIPTION_ALREADYEXIST;
            break;
        case 'photo_badid' :
            $alert['messageAlert'] = ERREUR_PHOTO_BADID;
            break;
        case 'photo_delete' :
            $alert['messageAlert'] = ERREUR_PHOTO_DELETE;
            break;
        case 'photo_modif' :
            $alert['messageAlert'] = ERREUR_PHOTO_MODIF;
            break;
        case 'photo_vandale' :
            $alert['messageAlert'] = ERREUR_PHOTO_VANDALE;
            break;

        //Informations
        case 'selectedPhotos':
            $alert['messageAlert'] = $arg." ".TEXTE_SELECTED_PHOTOS;
            $alert["classAlert"] = "success";
            break;
        case 'add_cat':
            $alert['messageAlert'] =TEXTE_FORM_CAT_SUCCESS;
            $alert["classAlert"] = "success";
            break;
        case 'add_photo':
            $alert['messageAlert'] = TEXTE_FORM_PHOTO_SUCCESS;
            $alert["classAlert"] = "success";
            break;
        case 'connexion':
            $alert['messageAlert'] =TEXTE_FORM_CONNEXION_SUCCESS1.$arg.TEXTE_FORM_CONNEXION_SUCCESS2;
            $alert["classAlert"] = "success";
            break;
        case 'inscription':
            $alert['messageAlert'] =TEXTE_FORM_INSCRIPTION_SUCCESS1.$arg.TEXTE_FORM_INSCRIPTION_SUCCESS2;
            $alert["classAlert"] = "success";
            break;
        case 'photo_delete_success':
            $alert['messageAlert'] = TEXTE_PHOTO_DELETE_SUCCESS;
            $alert["classAlert"] = "success";
            break;
        case 'photo_modif_success':
            $alert['messageAlert'] =TEXTE_PHOTO_MODIF_SUCCESS;
            $alert["classAlert"] = "success";
            break;
        
        default :
            $alert['messageAlert'] = MESSAGE_ERREUR;
    }
    return $alert;
}

?>
