package com.pivotguard.pivotguard_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.entities.CompromisedSite;

public interface CompromisedSiteRepository extends JpaRepository<CompromisedSite, Integer> {

  @Query (nativeQuery = true, value = """
            SELECT EXISTS (
                SELECT 1 FROM Compromised_Site cs WHERE cs.ULR = :currentSite
            );
      """)
    Boolean isCompromised(String currentSite);
}
