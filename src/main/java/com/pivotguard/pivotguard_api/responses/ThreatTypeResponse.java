package com.pivotguard.pivotguard_api.responses;

import com.pivotguard.pivotguard_api.dtos.ThreatDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ThreatTypeResponse {
    private List<ThreatDto> threatTypes;
}
