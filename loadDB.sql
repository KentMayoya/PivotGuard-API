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
  Description varchar(350),
  PRIMARY KEY (ID),
  FOREIGN KEY (ServiceType) REFERENCES ServiceType(Name) DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE ThreatType (
  ID serial NOT NULL,
  Name varchar(40) NOT NULL UNIQUE,
  PRIMARY KEY (ID)
);

CREATE TABLE Threat (
  SiteID int NOT NULL,
  ThreatID int NOT NULL,
  PRIMARY KEY (SiteID, ThreatID),
  FOREIGN KEY (SiteID) REFERENCES Site(ID) DEFERRABLE INITIALLY DEFERRED,
  FOREIGN KEY (ThreatID) REFERENCES ThreatType(ID) DEFERRABLE INITIALLY DEFERRED
);

BEGIN;
INSERT INTO ServiceType(Name)
  VALUES ('AI Assistant'),
  ('Cloud Storage'),
  ('Dating Apps'),
  ('Design Tools'),
  ('Email'),
  ('File Sharing'),
  ('Fitness and Health'),
  ('Forms'),
  ('Home Assistants'),
  ('Image Generation'),
  ('Instant Messaging'),
  ('Location Tracking'),
  ('Maps and Nav'),
  ('Menstrual Cycle Trackers'),
  ('Music Recognition'),
  ('Music Streaming'),
  ('Office'),
  ('Password Managers'),
  ('Podcast'),
  ('TikTok'),
  ('URL Shortener'),
  ('Video Streaming');

INSERT INTO ThreatType(Name)
  VALUES ('Privacy'),
  ('Trackers'),
  ('Bad Encryption'),
  ('Requires Permissions'),
  ('Data Breach'),
  ('Invasive Algorithms'),
  ('Analytics');
  
COMMIT;