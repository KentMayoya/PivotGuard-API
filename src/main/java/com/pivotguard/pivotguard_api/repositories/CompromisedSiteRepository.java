package com.pivotguard.pivotguard_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pivotguard.pivotguard_api.entities.CompromisedSite;

public interface CompromisedSiteRepository extends JpaRepository<CompromisedSite, Integer> {

    
}
