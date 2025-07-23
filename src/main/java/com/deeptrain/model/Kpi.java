package com.deeptrain.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kpis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kpi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String learnerId; // Optional: to track by learner
    private Double cpi;
    private Double spi;
    private Double accuracyRate;

    private String recordedAt; // e.g. "2025-07-16"
}

