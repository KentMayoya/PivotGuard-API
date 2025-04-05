/**
 * A junction object between Site and threat type. A site may have many
 * threats, and a single threat may be related to many sites.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.entities;

import com.pivotguard.pivotguard_api.composites.ThreatId;
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
@Table(name = "threat")
public class Threat {
    @EmbeddedId
    private ThreatId id;

    @NonNull
    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "siteid")
    private Site site;

    @NonNull
    @ManyToOne
    @MapsId("threatTypeId")
    @JoinColumn(name = "threatid")
    private ThreatType threatTypeId;
}
