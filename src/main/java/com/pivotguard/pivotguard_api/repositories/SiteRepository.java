package com.pivotguard.pivotguard_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.dtos.SafeSiteDto;
import com.pivotguard.pivotguard_api.entities.Site;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Integer> {

  @Query(nativeQuery = true, value = """
      SELECT EXISTS (
        SELECT 1 FROM Site s WHERE (s.URL LIKE CONCAT('%' ,:currentSite, '%') OR :currentSite LIKE CONCAT('%', s.URL, '%')) AND s.iscompromised = TRUE
      );
      """)
  Boolean isCompromised(String currentSite);

  @Query(nativeQuery = true, value = """
      SELECT
        s.url as URL,
        s.name as name,
        s.description as description
      FROM
        Site s
      WHERE
        ServiceType = (
          SELECT
            ServiceType
          FROM
            site s
          WHERE
            (s.URL LIKE CONCAT('%' ,:url, '%') OR :url LIKE CONCAT('%', s.URL, '%'))
          LIMIT 1
        )
        AND iscompromised = FALSE;
      """)
  List<SafeSiteDto> getSafeSites(String url);
}
