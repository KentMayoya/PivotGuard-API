package com.pivotguard.pivotguard_api.entities;

import com.pivotguard.pivotguard_api.composites.LinkId;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Entity
@Data
@Table(name = "link")
public class Link {
    @EmbeddedId
    private LinkId id;

    @NonNull
    @ManyToOne
    @MapsId("compromisedSiteId")
    @JoinColumn(name = "compromisedSiteId")
    private CompromisedSite compromisedSite;

    @NonNull
    @ManyToOne
    @MapsId("safeSiteId")
    @JoinColumn(name = "safeSiteId")
    private SafeSite safeSite;
}
