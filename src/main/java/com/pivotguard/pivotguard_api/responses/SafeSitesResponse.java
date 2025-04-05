package com.pivotguard.pivotguard_api.responses;

import com.pivotguard.pivotguard_api.dtos.SafeSiteDto; 
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SafeSitesResponse {
    private List<SafeSiteDto> safeSites;
}
