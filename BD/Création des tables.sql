/*==============================================================*/
/* Création des tables                                          */
/*==============================================================*/
create table Categorie
(
    type                   VARCHAR(254),
    categorieID            INTEGER
);

create table Film 
(
    duree                  VARCHAR(10),
    titre                  VARCHAR(254),
    filmID                 INTEGER,
    categorieID            INTEGER,
    realisateur1ID         INTEGER,
    realisateur2ID         INTEGER,
    realisateur3ID         INTEGER
);

create table Jury 
(
    nbSeanceMax            INTEGER,
    juryID                 INTEGER,
    categorieID            INTEGER,
    presidentID            INTEGER
);

create table Personne 
(
    nom                    VARCHAR(254),
    prenom                 VARCHAR(254),
    nationnalite           VARCHAR(254),
    personneID             INTEGER,
	age                    INTEGER,
	dateNaissance          DATE,
    juryID                 INTEGER,
    metier                 VARCHAR(254)
);

create table Photo 
(
    nomPhoto               VARCHAR(254),
    photoID                INTEGER
);

create table Projection 
(
    projectionID           INTEGER,
    salleID                INTEGER,
    filmID                 INTEGER,
    dateProjection         DATE,
    heureProjection        INTEGER,
    officielle             SMALLINT
);

create table Salle 
(
    salleID                INTEGER,
    capacite               INTEGER
);

create table VIP 
(
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
alter table Categorie 
    add constraint PK_CATEGORIE
        primary key (categorieID);

alter table Film 
    add constraint PK_FILM
        primary key (filmID);

alter table Jury
    add constraint PK_JURY
        primary key (juryID);

alter table Personne
    add constraint PK_PERSONNE
        primary key (personneID);

alter table Photo
    add constraint PK_PHOTO
        primary key (photoID);

alter table Projection
    add constraint PK_PROJECTION
        primary key (projectionID);

alter table Salle
    add constraint PK_SALLE
        primary key (salleID);

alter table VIP
    add constraint PK_VIP
        primary key (VIPID);

/*==============================================================*/
/* Index des tables                                             */
/*==============================================================*/
alter table Film add index(
    categorieID,
    realisateur1ID,
    realisateur2ID,
    realisateur3ID
);

alter table Jury add index(
    categorieID,
    presidentID
);

alter table Personne add index(
    juryID
);

alter table Projection add index(
    salleID,
    filmID
);

alter table VIP add index(
    photoID,
    compagnonID
);

/*==============================================================*/
/* Clés étrangères des tables                                   */
/*==============================================================*/
alter table Film
    add constraint FK_FILM_ASSOCIATI_CATEGORI foreign key (categorieID)
        references Categorie (categorieID);

alter table Film
    add constraint FK_FILM_REALISE1_PERSONNE foreign key (realisateur1ID)
        references Personne (personneID);

alter table Film
    add constraint FK_FILM_REALISE2_PERSONNE foreign key (realisateur2ID)
        references Personne (personneID);

alter table Film
    add constraint FK_FILM_REALISE3_PERSONNE foreign key (realisateur3ID)
        references Personne (personneID);

alter table Jury
    add constraint FK_JURY_CATEGORIE_CATEGORI foreign key (categorieID)
        references Categorie (categorieID);

alter table Jury
    add constraint FK_JURY_PRESIDENT_PERSONNE foreign key (presidentID)
        references Personne (personneID);

alter table Personne
   add constraint FK_PERSONNE_ASSOCIATI_JURY foreign key (juryID)
      references Jury (juryID);

alter table Projection
    add constraint FK_PROJECTI_ASSOCIATI_FILM foreign key (filmID)
        references Film (filmID);

alter table Projection
    add constraint FK_PROJECTI_ASSOCIATI_SALLE foreign key (salleID)
        references Salle (salleID);

alter table VIP
    add constraint FK_VIP_ASSOCIATI_PHOTO foreign key (photoID)
        references Photo (photoID);
      
alter table VIP
    add constraint FK_VIP_ASSOCIATI_PERSONNE foreign key (personneID)
        references Personne (personneID);

/*==============================================================*/
/* Autre contraintes                                            */
/*==============================================================*/
alter table VIP
    add constraint CHK_PERSONNE CHECK
    (
        typeVIP = 'acteur'
        OR typeVIP = 'realisateur'
        OR typeVIP = 'journaliste'
        OR typeVIP = 'people'
    );

/*==============================================================*/
/* Suppression des tables                                       */
/*==============================================================*/
alter table Film
    drop foreign key FK_FILM_ASSOCIATI_CATEGORI;

alter table Film
    drop foreign key FK_FILM_REALISE1_PERSONNE;

alter table Film
    drop foreign key FK_FILM_REALISE2_PERSONNE;

alter table Film
    drop foreign key FK_FILM_REALISE3_PERSONNE;

alter table Jury
    drop foreign key FK_JURY_CATEGORIE_CATEGORI;

alter table Jury
    drop foreign key FK_JURY_PRESIDENT_PERSONNE;

alter table Personne
   drop foreign key FK_PERSONNE_ASSOCIATI_JURY;

alter table Projection
    drop foreign key FK_PROJECTI_ASSOCIATI_FILM;

alter table Projection
    drop foreign key FK_PROJECTI_ASSOCIATI_SALLE;

alter table VIP
    drop foreign key FK_VIP_ASSOCIATI_PHOTO;
      
alter table VIP
    drop foreign key FK_VIP_ASSOCIATI_PERSONNE;

drop table Categorie, Film, Jury, Personne, Photo, Projection, Salle, VIP;
