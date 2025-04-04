
package com.pivotguard.pivotguard_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "compromisedsite")
public class CompromisedSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String URL;
    
    @NonNull
    private String name;
}