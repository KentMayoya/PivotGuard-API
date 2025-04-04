/**
 * Repository layer for ThreatTypes.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.entities.ThreatType;

import java.util.List;

public interface ThreatTypeRepository extends JpaRepository<ThreatType, Integer> {

  @Query (nativeQuery = true, value = """
        SELECT ThreatType.Name
        FROM ThreatType
            JOIN Threat ON (ThreatType.ID = Threat.ThreatID)
            JOIN Site ON (Threat.SiteID = Site.ID)
        WHERE site.URL LIKE CONCAT('%' ,:url, '%') OR :url LIKE CONCAT('%', site.URL, '%')
            """)
    List<String> getThreatTypes(String url);
}
