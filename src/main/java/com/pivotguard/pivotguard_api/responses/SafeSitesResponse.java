package com.pivotguard.pivotguard_api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.pivotguard.pivotguard_api.dtos.SafeSiteDto;

import java.util.List;

@Data
@AllArgsConstructor
public class SafeSitesResponse {
    private List<SafeSiteDto> safeSites;
}
