package com.pivotguard.pivotguard_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.entities.Site;

public interface SiteRepository extends JpaRepository<Site, Integer> {
    // TODO: Add logic    
}
