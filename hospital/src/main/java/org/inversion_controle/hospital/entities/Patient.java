package org.inversion_controle.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;

    //One-to-Many : un objet Patient est associé à plusieurs objets RendezVous.
    //cette relation est gérée par l’autre entité (RendezVous dans ce cas).
    //.LAZY ne pas charger les donnée lié quand la demande n'est pas explicie
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
