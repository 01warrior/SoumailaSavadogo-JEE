package org.inversion_controle.hospital.services;

import jakarta.transaction.Transactional;
import org.inversion_controle.hospital.entities.Consultation;
import org.inversion_controle.hospital.entities.Medecin;
import org.inversion_controle.hospital.entities.Patient;
import org.inversion_controle.hospital.entities.RendezVous;
import org.inversion_controle.hospital.repositories.ConsultationRepositorie;
import org.inversion_controle.hospital.repositories.MedecinRepositorie;
import org.inversion_controle.hospital.repositories.PatientRepositorie;
import org.inversion_controle.hospital.repositories.RendezVousRepositorie;
import org.springframework.stereotype.Service;

//@Service Marque une classe comme étant un service.
// Elle est utilisée pour des classes qui contiennent la logique métier principale.
@Transactional @Service
public class HospitalServicesImplemente implements HospitalServices {

    private MedecinRepositorie medecinRepositorie;
    private ConsultationRepositorie consultationRepositorie;
    private PatientRepositorie patientRepositorie;
    private RendezVousRepositorie rendezVousRepositorie;

    //injection par le constructeur C'est une méthode privilégiée
    public HospitalServicesImplemente(MedecinRepositorie medecinRepositorie, ConsultationRepositorie consultationRepositorie, PatientRepositorie patientRepositorie, RendezVousRepositorie rendezVousRepositorie) {
        this.medecinRepositorie = medecinRepositorie;
        this.consultationRepositorie = consultationRepositorie;
        this.patientRepositorie = patientRepositorie;
        this.rendezVousRepositorie = rendezVousRepositorie;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepositorie.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepositorie.save(medecin);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepositorie.save(consultation);
    }

    @Override
    public Consultation findConsultationById(double id) {
        return consultationRepositorie.findById((long) id).get();
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepositorie.save(rendezVous);
    }

    @Override
    public RendezVous findRendezVous() {
        return rendezVousRepositorie.findAll().get(0);
    }

    @Override
    public Patient findPatientById(double id) {
        return patientRepositorie.findById((long) id).get();
    }

    @Override
    public Patient findPatientByName(String name) {
        return patientRepositorie.findByName(name);
    }

    @Override
    public Medecin findMedecinById(double id) {
        return medecinRepositorie.findById((long) id).get();
    }

    @Override
    public Medecin findMedecinByName(String name) {
        return medecinRepositorie.findByNom(name);
    }


}
