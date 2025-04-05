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
    private Integer compromisedSiteId;
    private Integer siteId;

    public ThreatId(Integer compromisedSiteId, Integer siteId) {
        this.compromisedSiteId = compromisedSiteId;
        this.siteId = siteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compromisedSiteId, siteId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof ThreatId)) {
            return false;
        }
        ThreatId other = (ThreatId) obj;
        return this.compromisedSiteId == other.compromisedSiteId && this.siteId == other.siteId;
    }
}
