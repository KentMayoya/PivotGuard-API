package com.pivotguard.pivotguard_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.entities.Site;

public interface SiteRepository extends JpaRepository<Site, Integer> {

  @Query (nativeQuery = true, value = """
      SELECT EXISTS (
        SELECT 1 FROM Site cs WHERE cs.URL = :currentSite
      );
      """)
    Boolean isCompromised(String currentSite);
}
