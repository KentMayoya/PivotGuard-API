/**
 * Represents the site's service type e.g. cloud storage or email service.
 * 
 * @author Kent Mayoya
 */
package com.pivotguard.pivotguard_api.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Table(name = "servicetype")
public class ServiceType {
    @Id
    private String name;
}