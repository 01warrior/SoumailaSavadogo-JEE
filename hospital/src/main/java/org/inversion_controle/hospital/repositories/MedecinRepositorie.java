package org.inversion_controle.hospital.repositories;

import org.inversion_controle.hospital.entities.Medecin;
import org.inversion_controle.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepositorie extends JpaRepository <Medecin, Long> {

    Medecin findByNom(String nom);

}
