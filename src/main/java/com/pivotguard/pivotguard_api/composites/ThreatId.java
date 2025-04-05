/**
 * Represents the junction object between site and threat type. A site may have many
 * threats, and a single threat may be related to many sites.
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

    public ThreatId(Integer compromisedSiteId, Integer safeSiteId) {
        this.compromisedSiteId = compromisedSiteId;
        this.siteId = safeSiteId;
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
