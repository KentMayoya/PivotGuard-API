package com.pivotguard.pivotguard_api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompromisedSiteResponse {
    private boolean isCompromisedSite;
}
