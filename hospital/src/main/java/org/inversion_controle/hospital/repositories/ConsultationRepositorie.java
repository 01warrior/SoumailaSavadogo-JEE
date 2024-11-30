package org.inversion_controle.hospital.repositories;

import org.inversion_controle.hospital.entities.Consultation;
import org.inversion_controle.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepositorie extends JpaRepository <Consultation, Long> {

}
