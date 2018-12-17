/*==============================================================*/
/* Création des tables                                          */
/*==============================================================*/
create table "Categorie" 
(
   "type"               VARCHAR2(254),
   "categorieID"        INTEGER
);

create table "Film" 
(
   "duree"              INTEGER,
   "titre"              VARCHAR2(254),
   "filmID"             INTEGER,
   "CategorieID",       INTEGER,
   "realisateurID",     INTEGER
);

create table "Jury" 
(
   "nbSeanceMax"        INTEGER,
   "juryID"             INTEGER,
   "categorieID"        INTEGER
);

create table "Personne" 
(
   "nom"                VARCHAR2(254),
   "prenom"             VARCHAR2(254),
   "nationnalite"       VARCHAR2(254),
   "personneID"         INTEGER,
   "compagnonID"        INTEGER,
   "juryID"             INTEGER
);

create table "Photo" 
(
   "nomPhoto"           VARCHAR2(254),
   "photoID"            INTEGER,
   "VIPID"              INTEGER
);

create table "Projection" 
(
   "projectionID"       INTEGER,
   "salleID"            INTEGER,
   "filmID"             INTEGER,
   "dateProjection"     DATE,
   "heureProjection"    INTEGER,
   "officielle"         SMALLINT
);

create table "Salle" 
(
   "salleID"            INTEGER,
   "capacite"           INTEGER
);

create table "VIP" 
(
   "VIPID"              INTEGER,
   CONSTRAINT CHK_Person CHECK (typeVIP = 'acteur'
   OR typeVIP = 'realisateur'
   OR typeVIP = 'journaliste'
   OR typeVIP = 'people')
   "importanceAcreditation" INTEGER,
   "type"               INTEGER,
   "isJournaliste"      SMALLINT,
);

/*==============================================================*/
/* Clés primaires des tables                                    */
/*==============================================================*/
alter table "Categorie" 
	add constraint PK_CATEGORIE
		primary key ("categorieID");

alter table "Film" 
	add constraint PK_FILM
		primary key ("filmID");

alter table "Jury"
	add constraint PK_JURY
		primary key ("juryID");

alter table "Personne"
	add constraint PK_PERSONNE
		primary key ("personneID");

alter table "Photo"
	add constraint PK_PHOTO
		primary key ("photoID");

alter table "ProjectionID"
	add constraint PK_PROJECTION
		primary key ("projectionID");

alter table "Salle"
	add constraint PK_SALLE
		primary key ("salleID");

/*==============================================================*/
/* Clés étrangères des tables                                   */
/*==============================================================*/
alter table "Film"
   add constraint FK_FILM_ASSOCIATI_CATEGORI foreign key ("categorieID")
      references "Categorie" ("categorieID");

alter table "Film"
   add constraint FK_FILM_REALISE_PERSONNE foreign key ("realisateurID")
      references "Personne" ("personneID");

alter table "Jury"
   add constraint FK_JURY_CATEGORIE_CATEGORI foreign key ("categorieID")
      references "Categorie" ("categorieID");

alter table "Personne"
   add constraint FK_PERSONNE_ASSOCIATI_PERSONNE foreign key ("compagnonID")
      references "Personne" ("personneID");

alter table "Personne"
   add constraint FK_PERSONNE_ASSOCIATI_JURY foreign key ("JuryID")
      references "Jury" ("juryID");

alter table "Photo"
   add constraint FK_PHOTO_ASSOCIATI_VIP foreign key ("VIPID")
      references "VIP" ("VIPID");

alter table "Projection"
   add constraint FK_PROJECTI_ASSOCIATI_FILM foreign key ("filmID")
      references "Film" ("filmID");

alter table "Projection"
   add constraint FK_PROJECTI_ASSOCIATI_SALLE foreign key ("salleID")
      references "Salle" ("salleID");

/*==============================================================*/
/* Autre contraintes                                            */
/*==============================================================*/
