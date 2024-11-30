package org.inversion_controle.hospital.services;

import org.inversion_controle.hospital.entities.Consultation;
import org.inversion_controle.hospital.entities.Medecin;
import org.inversion_controle.hospital.entities.Patient;
import org.inversion_controle.hospital.entities.RendezVous;


public interface HospitalServices {
    Patient savePatient(Patient patient);
    Patient findPatientById(double id);
    Patient findPatientByName(String name);

    Medecin saveMedecin(Medecin medecin);
    Medecin findMedecinById(double id);
    Medecin findMedecinByName(String name);

    Consultation saveConsultation(Consultation consultation);
    Consultation findConsultationById(double id);


    RendezVous saveRendezVous(RendezVous rendezVous);
    RendezVous findRendezVous();
}
