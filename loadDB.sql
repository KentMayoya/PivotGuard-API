CREATE DATABASE pivotguarddb;
BEGIN;

CREATE TABLE CompromisedSite (
  "ID" Serial,
  "URL" varchar(50),
  "name" varchar(80),
  PRIMARY KEY ("ID")
);

CREATE TABLE ThreatType (
  "ID" Serial,
  "threat" varchar(40),
  "threatDescription" varchar(300)
);

CREATE TABLE Threat (
  "CompromisedID" Serial,
  "ThreatID" Serial,
  CONSTRAINT "FK_Threat.CompromisedID"
    FOREIGN KEY ("CompromisedID")
      REFERENCES "CompromisedSite"("ID"),
  CONSTRAINT "FK_Threat.ThreatID"
    FOREIGN KEY ("ThreatID")
      REFERENCES "ThreatType"("ID")
);

CREATE TABLE SafeSite (
  "ID" serial,
  "URL" varchar(50),
  "name" varchar(80),
  "Description" varchar(300),
  PRIMARY KEY ("ID")
);

CREATE TABLE Link (
  "CompromisedID" integer,
  "SafeID" integer,
  CONSTRAINT "FK_Link.SafeID"
    FOREIGN KEY ("SafeID")
      REFERENCES "SafeSite"("ID"),
  CONSTRAINT "FK_Link.CompromisedID"
    FOREIGN KEY ("CompromisedID")
      REFERENCES "CompromisedSite"("ID")
);

CREATE INDEX "PK/FK" ON  "Link" ("CompromisedID", "SafeID");

COMMIT;