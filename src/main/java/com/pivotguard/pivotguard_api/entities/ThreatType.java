/**
 * Represents a site's threat type e.g. privacy concerns.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.entities;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Table(name = "threattype")
public class ThreatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;
}