/**
 * Repository layer for ThreatTypes.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.entities.ThreatType;
import com.pivotguard.pivotguard_api.dtos.ThreatDto;

import java.util.List;

public interface ThreatTypeRepository extends JpaRepository<ThreatType, Integer> {

  @Query (nativeQuery = true, value = """
            SELECT tt.Name, tt.Description
            FROM ThreatType tt
                JOIN Threat ON (tt.ID = Threat.ThreatID)
                JOIN Site ON (Threat.SiteID = Site.ID)
            WHERE Site.URL = :url
            """)
    List<ThreatDto> getThreatTypes(String url);
}
