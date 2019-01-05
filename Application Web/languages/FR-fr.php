<?php
// Liste des constantes des textes affichés sur le site
define('LOGO', 'Logo de la compagnie'); // Affiché si image non trouvée
define('TOUTES_PHOTOS', 'Toutes les photos');
define('PHOTOS_CATEGORIE', 'Les photos de la catégorie ');
define('MENU_ACCUEIL', 'Accueil');
define('SELECTION_PHOTOS', 'photo(s) sélectionnées');
define('CHOIX_CATEGORIE', 'Quelles photos souhaitez-vous afficher ?');
define('INFOS_PHOTO', 'En voir plus sur cette photo');
define('DESCRIPTION', 'Description');
define('NOM_FICHIER', 'Nom du fichier');
define('CATEGORIE', 'Catégorie');
define('MENU_CONNEXION', 'Connexion');
define('TITRE_PAGE_CONNEXION', 'Connexion pour modifier le catalogue');
define('TITRE_PAGE_INSCRIPTION', 'Inscription');
define('FORM_CONNEXION_IDENTIFIANT', 'Identifiant');
define('FORM_CONNEXION_MDP','Mot de passe');
define('BUTTON_CONNEXION', 'Se connecter');
define('BUTTON_INSCRIPTION', 'S\'inscrire');
define('MENU_INSCRIPTION', 'Inscription');
define('MENU_ADDPHOTO','Ajouter une photo');
define('MENU_ADDCAT','Ajouter une catégorie');
define('ERREUR_FORM_CONNEXION_UNKNOWID','Cet identifiant est inconnu !');
define('ERREUR_FORM_CONNEXION_PASSWORD','Mot de passe incorrect !');
define('TEXTE_FORM_CONNEXION_SUCCESS1',"Bienvenue ");
define('TEXTE_FORM_CONNEXION_SUCCESS2',", redirection vers l'accueil en cours");
define('MENU_DECONNEXION','Deconnexion');

define('TEXTE_PAGE_404', "Oups, la page demandée n'existe pas !");
define('MESSAGE_ERREUR', "Une erreur s'est produite");
define('ERREUR_ID_PHOTO', "Identifiant de photo incorrect dans l'URL");
define('ERREUR_ID_CATEGORIE', "Identifiant de catégorie incorrect dans l'URL");

//define('TITRE', '');
define('TITRE_PAGE_PHOTO', 'Les informations sur cette photo');
define('ERREUR_QUERY', "Problème d'accès à la base de données. Contactez l'administrateur");

// Header

// Menu

// Messages erreures
define('ERREUR_CONNECT_BDD','Impossible de se connecter à la BDD !');
define('ERREUR_QUERY_BDD','Une erreure est survenue lors de la requête SQL !');
define('ERREUR_CAPTCHA','Merci de cocher le captcha');

define('ERREUR_FORM_CAT_EMPTY','Elle doit avoir un nom !');
define('ERREUR_FORM_CAT_ALREADYEXIST','Cette categorie existe déjà !');
define('ERREUR_FORM_CAT_LONGUEUR','Elle doit avoir un nom compris entre 4 et 20 lettres !');

define('ERREUR_FORM_PHOTO_FILE1','Erreur fichier');
define('ERREUR_FORM_PHOTO_FILE2','Vous devez choisir un fichier');
define('ERREUR_FORM_PHOTO_SIZE','Taille maximum 100Ko');
define('ERREUR_FORM_PHOTO_EXT','Extension non supportée');
define('ERREUR_FORM_PHOTO_DESC','La description doit contenir au moins une lettre');
define('ERREUR_FORM_PHOTO_ALREADYEXIST','Ce nom de fichier est déjà pris !');

define('ERREUR_FORM_INSCRIPTION_LONGUEURID','Le nom d\'utilisateur doit être compris entre 4 et 20 caractères !');
define('ERREUR_FORM_INSCRIPTION_LONGUEURMDP','Le mot de passe doit comporter au moins 4 caractères !');
define('ERREUR_FORM_INSCRIPTION_ALREADYEXIST','Cet utilisateur existe déjà !');

define('ERREUR_PHOTO_BADID','Identifiant de photo incorrect dans l\'URL');
define('ERREUR_PHOTO_DELETE','Supression impossible !');
define('ERREUR_PHOTO_MODIF','Modification impossible !');
define('ERREUR_PHOTO_VANDALE','Cette photo ne vous appartient pas, vandale !');


// Messages informations

define('TEXTE_SELECTED_PHOTOS'," photo(s) selectionnée(s)");
define('TEXTE_FORM_CAT_SUCCESS',"Categorie ajoutée !");
define('TEXTE_FORM_PHOTO_SUCCESS',"Photo ajoutée !");

define('TEXTE_FORM_INSCRIPTION_SUCCESS1',"Inscription réussite ");
define('TEXTE_FORM_INSCRIPTION_SUCCESS2',", redirection vers l'accueil en cours");

define('TEXTE_PHOTO_DELETE_SUCCESS',"Photo supprimé");
define('TEXTE_PHOTO_MODIF_SUCCESS',"Modification réussite");



// Titres

define('TITRE_PAGE_ACCUEIL_TOUS','Toutes les photos');
define('TITRE_PAGE_ACCUEIL_CAT','Les photos de la categorie ');
define('TITRE_PAGE_ACCUEIL', 'Page accueil VIP');
define('TITRE_PAGE_ADDCAT','Quelle Categorie ?');
define('TITRE_PAGE_ADDPHOTO','Quelle photo ?');



// Forms

define('FORM_QUESTION_CAT_AFFICHER','Quelles photos souhaitez-vous afficher ?');

define('FORM_QUESTION_CAT_NAME','Nom de la catégorie:');

define('FORM_QUESTION_PHOTO_FICHIER','Choisir le fichier:');
define('FORM_QUESTION_PHOTO_DESC','Décrire la photo en une phrase:');
define('FORM_QUESTION_PHOTO_CAT','Choisir une catégorie:');


// Photo

define('TEXTE_LIKES','Likes');
define('TEXTE_DESCRIPTION','Description');
define('TEXTE_NOM_FICHIER','Nom du fichier');
define('TEXTE_CAT','Catégorie');
define('TEXTE_USER','Utilisateur');


// Profil

define('TEXTE_PROFIL_USERNAME','Nom d\'utilisateur');
define('TEXTE_PROFIL_NBPHOTOS','Nombre de photos');
define('TEXTE_PROFIL_NBLIKES','Nombre de Likes obtenus');
define('TEXTE_PROFIL_DATEINSCRIPTION','Date d\'inscription');
define('TEXTE_PROFIL_DATELASTCONNEXION','Dernière connexion');


// Boutons (pas d'acné)

define('BUTTON_ENVOYER','Envoyer');
define('BUTTON_LIKE','Like');
define('BUTTON_LIKED','Liked');
define('BUTTON_DELETE','Supprimer');
define('BUTTON_MODIF','Modifier');
define('BUTTON_SAVE','Enregistrer');

?>
