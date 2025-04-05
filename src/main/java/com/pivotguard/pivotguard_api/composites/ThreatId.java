/**
 * Represents the composite key for Threat.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.composites;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ThreatId implements Serializable {
    private Integer siteId;
    private Integer threatTypeId;

    public ThreatId(Integer siteId, Integer threatTypeId) {
        this.siteId = siteId;
        this.threatTypeId = threatTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteId, threatTypeId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof ThreatId)) {
            return false;
        }
        ThreatId other = (ThreatId) obj;
        return this.siteId == other.siteId && this.threatTypeId == other.threatTypeId;
    }
}
