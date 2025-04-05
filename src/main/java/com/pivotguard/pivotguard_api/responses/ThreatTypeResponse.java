package com.pivotguard.pivotguard_api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ThreatTypeResponse {
    private List<String> threatTypes;
}
