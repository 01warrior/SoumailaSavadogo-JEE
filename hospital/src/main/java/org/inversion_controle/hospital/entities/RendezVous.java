package org.inversion_controle.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id
    private String id;
    //pas besoin des heure et minute
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean annule;

    //permet de stocker l'entité enumerate en format string
    @Enumerated(EnumType.STRING)
    private  StatutRDV statutRDV;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    //indique que l’entité RendezVous ne gère pas la relation c'est
    //l’entité Consultation qui gère la clé étrangère via l’attribut rendezVous.
    @OneToOne(mappedBy = "rendezVous")
    private  Consultation consultation;
}
