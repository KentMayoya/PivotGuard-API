/**
 * Defines the API endpoints for querying the database.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.pivotguard.pivotguard_api.repositories.SiteRepository;
import com.pivotguard.pivotguard_api.repositories.ThreatTypeRepository;
import com.pivotguard.pivotguard_api.responses.CompromisedSiteResponse;
import com.pivotguard.pivotguard_api.responses.ThreatTypeResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/sites")
public class SiteController {
    private final SiteRepository siteRepository;
    private final ThreatTypeRepository threatTypeRepository;

    public SiteController(SiteRepository siteRepository, ThreatTypeRepository threatTypeRepository) {
        this.siteRepository = siteRepository;
        this.threatTypeRepository = threatTypeRepository;
    }

    // test on http://localhost:8080/api/v1/sites/isSafeSite?url=www.google.com
    @GetMapping("/isSafeSite")
    ResponseEntity<CompromisedSiteResponse> isCompromisedSite(@RequestParam String url) {
        CompromisedSiteResponse result = new CompromisedSiteResponse(siteRepository.isCompromised(url));
        return ResponseEntity.ok(result);
    }

    // test on http://localhost:8080/api/v1/sites/getThreatTypes?url=www.google.com
    @GetMapping("/getThreatTypes")
    ResponseEntity<ThreatTypeResponse> getThreatTypes(@RequestParam String url) {
        ThreatTypeResponse response = new ThreatTypeResponse(threatTypeRepository.getThreatTypes(url));
        return ResponseEntity.ok(response);
    }
}
