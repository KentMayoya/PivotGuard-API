CREATE DATABASE pivotguarddb;

CREATE TABLE ServiceType (
  Name varchar(50) NOT NULL,
  PRIMARY KEY (Name)
);

CREATE TABLE Site (
  ID serial NOT NULL,
  URL varchar(50) UNIQUE,
  Name varchar(80),
  IsCompromised boolean NOT NULL,
  ServiceType varchar(50),
  description varchar(350),
  PRIMARY KEY (ID),
  FOREIGN KEY (ServiceType) REFERENCES ServiceType(Name) DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE ThreatType (
  ID serial NOT NULL,
  Name varchar(40) NOT NULL UNIQUE,
  Description varchar(300),
  PRIMARY KEY (ID)
);

CREATE TABLE Threat (
  SiteID int NOT NULL,
  ThreatID int NOT NULL,
  PRIMARY KEY (SiteID, ThreatID),
  FOREIGN KEY (SiteID) REFERENCES Site(ID) DEFERRABLE INITIALLY DEFERRED,
  FOREIGN KEY (ThreatID) REFERENCES ThreatType(ID) DEFERRABLE INITIALLY DEFERRED
);