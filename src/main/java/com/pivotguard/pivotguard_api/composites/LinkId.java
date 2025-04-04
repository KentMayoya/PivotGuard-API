package com.pivotguard.pivotguard_api.composites;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class LinkId implements Serializable {
    private Integer compromisedSiteId;
    private Integer safeSiteId;

    public LinkId(Integer compromisedSiteId, Integer safeSiteId) {
        this.compromisedSiteId = compromisedSiteId;
        this.safeSiteId = safeSiteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compromisedSiteId, safeSiteId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof LinkId)) {
            return false;
        }
        LinkId other = (LinkId) obj;
        return this.compromisedSiteId == other.compromisedSiteId && this.safeSiteId == other.safeSiteId;
    }
}
