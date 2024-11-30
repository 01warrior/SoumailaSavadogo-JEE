package org.inversion_controle.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //pas besoin des heure et minute
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;

    private String rapport;
    //Relation rendez_vous a consultation
    @OneToOne
    private RendezVous rendezVous;
}
