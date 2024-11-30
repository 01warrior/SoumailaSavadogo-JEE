package org.inversion_controle.hospital.repositories;

import org.inversion_controle.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepositorie extends JpaRepository <Patient, Long> {
    Patient findByName(String name);
}
