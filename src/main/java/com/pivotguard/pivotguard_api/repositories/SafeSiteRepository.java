package com.pivotguard.pivotguard_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pivotguard.pivotguard_api.entities.SafeSite;

public interface SafeSiteRepository extends JpaRepository<SafeSite, Integer> {
    // TODO: Add logic    
}
