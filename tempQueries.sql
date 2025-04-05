-- @Param URL string
-- @Returns URL if it exists in the DB 
SELECT 
  URL
FROM 
  CompromisedSite cs
WHERE 
  cs.ULR = :currentSite
LIMIT 1;


-- Alan's doing this one
-- @Param URL string
-- @Returns info of safe sites for a given compromised site
SELECT 
  ss.URL,
  ss.name,
  ss.description 
FROM 
  CompromisedSite cs
JOIN 
  Link l ON l.CompromisedID = cs.ID 
JOIN 
  SafeSite ss ON ss.ID = l.SafeID
WHERE
  cs.URL = :currentSite;



SELECT 
  s.URL,
  s.name,
  s.description
FROM 
  Site s 
WHERE 
  ServiceType = (
    SELECT 
      ServiceType
    FROM 
      Site s
    WHERE 
      s.URL = :currentSite
    LIMIT 1
  )
  AND isCompromised = FALSE;

-- @Param URL string
-- @Returns list of threats for a given compromised site
SELECT 
  threat,
  threatDescription
FROM
  CompromisedSite cs
JOIN 
  Threat t ON cs.ID = t.CompromisedID
JOIN 
  ThreatType tt ON tt.ID = t.ThreatID
WHERE
  cs.URL = :currentSite;

