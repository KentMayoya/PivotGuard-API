package com.pivotguard.pivotguard_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.pivotguard.pivotguard_api.repositories.CompromisedSiteRepository;
import com.pivotguard.pivotguard_api.responses.SafeSiteResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/sites")
public class SiteController {
    private final CompromisedSiteRepository compromisedSiteRepository;

    public SiteController(CompromisedSiteRepository compromisedSiteRepository) {
        this.compromisedSiteRepository = compromisedSiteRepository;
    }

    // test on http://localhost:8080/api/v1/sites/isSafeSite?url=www.google.com
    @GetMapping("/isSafeSite")
    ResponseEntity<SafeSiteResponse> isSafeSite(@RequestParam String url) {
        SafeSiteResponse result = new SafeSiteResponse(compromisedSiteRepository.isCompromised(url));
        return ResponseEntity.ok(result);
    }

}
