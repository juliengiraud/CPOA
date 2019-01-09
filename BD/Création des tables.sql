/*==============================================================*/
/* Création des tables                                          */
/*==============================================================*/
CREATE TABLE Categorie (
    Type                   VARCHAR(254),
    categorieID            INTEGER
);

CREATE TABLE Film (
    duree                  VARCHAR(10),
    titre                  VARCHAR(254),
    filmID                 INTEGER,
    categorieID            INTEGER
);

CREATE TABLE Jure (
    juryID                 INTEGER,
    personneID             INTEGER
);

CREATE TABLE Jury (
    nbSeanceMax            INTEGER,
    juryID                 INTEGER,
    categorieID            INTEGER,
    presidentID            INTEGER
);

CREATE TABLE Personne (
    nom                    VARCHAR(254),
    prenom                 VARCHAR(254),
    nationnalite           VARCHAR(254),
    personneID             INTEGER,
	age                    INTEGER,
	dateNaissance          DATE,
    metier                 VARCHAR(254)
);

CREATE TABLE Photo (
    nomPhoto               VARCHAR(254),
    photoID                INTEGER
);

CREATE TABLE Projection (
    projectionID           INTEGER,
    salleID                INTEGER,
    filmID                 INTEGER,
    dateProjection         DATE,
    heureProjection        INTEGER,
    officielle             SMALLINT
);

CREATE TABLE Realise (
    personneID             INTEGER,
    filmID                 INTEGER
);

CREATE TABLE Salle (
    salleID                INTEGER,
    capacite               INTEGER,
    nomSalle               VARCHAR(254)
);

CREATE TABLE User (
    userID                 INTEGER,
    username               VARCHAR(254),
    password               VARCHAR(254)
);

CREATE TABLE VIP (
    VIPID                  INTEGER,
    importanceAcreditation INTEGER,
    typeVIP                INTEGER,
    photoID                INTEGER,
    compagnonID            INTEGER,
    personneID             INTEGER
);

/*==============================================================*/
/* Clés primaires des tables                                    */
/*==============================================================*/
ALTER TABLE Categorie 
    ADD CONSTRAINT PK_CATEGORIE
        PRIMARY KEY (categorieID);

ALTER TABLE Film 
    ADD CONSTRAINT PK_FILM
        PRIMARY KEY (filmID);

ALTER TABLE Jury
    ADD CONSTRAINT PK_JURY
        PRIMARY KEY (juryID);

ALTER TABLE Personne
    ADD CONSTRAINT PK_PERSONNE
        PRIMARY KEY (personneID);

ALTER TABLE Photo
    ADD CONSTRAINT PK_PHOTO
        PRIMARY KEY (photoID);

ALTER TABLE Projection
    ADD CONSTRAINT PK_PROJECTION
        PRIMARY KEY (projectionID);

ALTER TABLE Salle
    ADD CONSTRAINT PK_SALLE
        PRIMARY KEY (salleID);

ALTER TABLE User
    ADD CONSTRAINT PK_USER
        PRIMARY KEY (userID);

ALTER TABLE VIP
    ADD CONSTRAINT PK_VIP
        PRIMARY KEY (VIPID);

/*==============================================================*/
/* Index des tables                                             */
/*==============================================================*/
ALTER TABLE Film ADD INDEX(
    categorieID
);

ALTER TABLE Jure ADD INDEX(
    juryID,
    personneID
);

ALTER TABLE Jury ADD INDEX(
    categorieID,
    presidentID
);

ALTER TABLE Personne ADD INDEX(
    juryID
);

ALTER TABLE Projection ADD INDEX(
    salleID,
    filmID
);

ALTER TABLE Realise ADD INDEX(
    personneID,
    filmID
);

ALTER TABLE User ADD INDEX(
    userID
);

ALTER TABLE VIP ADD INDEX(
    photoID,
    compagnonID
);

/*==============================================================*/
/* Clés étrangères des tables                                   */
/*==============================================================*/
ALTER TABLE Film
    ADD CONSTRAINT FK_FILM_ASSOCIATI_CATEGORI FOREIGN KEY (categorieID)
        REFERENCES Categorie (categorieID);

ALTER TABLE Jure
    ADD CONSTRAINT FK_JURE_PERSONNE FOREIGN KEY (personneID)
        REFERENCES Personne (personneID);

ALTER TABLE Jure
    ADD CONSTRAINT FK_JURE_JURY FOREIGN KEY (juryID)
        REFERENCES Jury (juryID);

ALTER TABLE Jury
    ADD CONSTRAINT FK_JURY_CATEGORIE_CATEGORI FOREIGN KEY (categorieID)
        REFERENCES Categorie (categorieID);

ALTER TABLE Jury
    ADD CONSTRAINT FK_JURY_PRESIDENT_PERSONNE FOREIGN KEY (presidentID)
        REFERENCES Personne (personneID);

ALTER TABLE Projection
    ADD CONSTRAINT FK_PROJECTI_ASSOCIATI_FILM FOREIGN KEY (filmID)
        REFERENCES Film (filmID);

ALTER TABLE Projection
    ADD CONSTRAINT FK_PROJECTI_ASSOCIATI_SALLE FOREIGN KEY (salleID)
        REFERENCES Salle (salleID);

ALTER TABLE Realise
    ADD CONSTRAINT FK_REALISE_PERSONNE FOREIGN KEY (personneID)
        REFERENCES Personne (personneID);

ALTER TABLE Realise
    ADD CONSTRAINT FK_REALISE_FILM FOREIGN KEY (filmID)
        REFERENCES Film (filmID);

ALTER TABLE VIP
    ADD CONSTRAINT FK_VIP_ASSOCIATI_PHOTO FOREIGN KEY (photoID)
        REFERENCES Photo (photoID);
      
ALTER TABLE VIP
    ADD CONSTRAINT FK_VIP_ASSOCIATI_PERSONNE FOREIGN KEY (personneID)
        REFERENCES Personne (personneID);

/*==============================================================*/
/* Autre contraintes                                            */
/*==============================================================*/
ALTER TABLE VIP
    ADD CONSTRAINT CHK_PERSONNE CHECK
    (
        typeVIP = 'acteur'
        OR typeVIP = 'realisateur'
        OR typeVIP = 'journaliste'
        OR typeVIP = 'people'
    );

/*==============================================================*/
/* Suppression des tables                                       */
/*==============================================================*/
ALTER TABLE Film
    DROP FOREIGN KEY FK_FILM_ASSOCIATI_CATEGORI;

ALTER TABLE Film
    DROP FOREIGN KEY FK_FILM_REALISE1_PERSONNE;

ALTER TABLE Film
    DROP FOREIGN KEY FK_FILM_REALISE2_PERSONNE;

ALTER TABLE Film
    DROP FOREIGN KEY FK_FILM_REALISE3_PERSONNE;

ALTER TABLE Jury
    DROP FOREIGN KEY FK_JURY_CATEGORIE_CATEGORI;

ALTER TABLE Jury
    DROP FOREIGN KEY FK_JURY_PRESIDENT_PERSONNE;

ALTER TABLE Personne
   DROP FOREIGN KEY FK_PERSONNE_ASSOCIATI_JURY;

ALTER TABLE Projection
    DROP FOREIGN KEY FK_PROJECTI_ASSOCIATI_FILM;

ALTER TABLE Projection
    DROP FOREIGN KEY FK_PROJECTI_ASSOCIATI_SALLE;

ALTER TABLE VIP
    DROP FOREIGN KEY FK_VIP_ASSOCIATI_PHOTO;
      
ALTER TABLE VIP
    DROP FOREIGN KEY FK_VIP_ASSOCIATI_PERSONNE;

DROP TABLE Categorie, Film, Jury, Personne, Photo, Projection, Salle, User, VIP;
