CREATE TABLE promo(
	idPromo		integer 	primary key autoincrement,
	codePromo	text,
	Etudiant	int
);

CREATE TABLE crenau(
	idPromo		integer		primary key autoincrement,
	date		text,
	heureDebut	text,
	heureFin	text
);

CREATE TABLE session(
    	idSession	integer		primary key autoincrement,
	codePromo	text,
	nbEtudiant	int
);

CREATE TABLE uniteEns(
	idUE		integer		primary key autoincrement,
	intitule	text,
	nomEnseigment	varchar(20),
	nbHeuresCours	int,
	nbHeuresTP	int,
	nbHeuresTD	int
);


