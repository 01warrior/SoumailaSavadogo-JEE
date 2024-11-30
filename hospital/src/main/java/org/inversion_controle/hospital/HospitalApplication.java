package org.inversion_controle.hospital;

import org.inversion_controle.hospital.entities.*;
import org.inversion_controle.hospital.services.HospitalServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    //@bean la methode sexecute au demarrage et retourne un objet qui devient un composant Spring
    //avantage : ici on peut instancier les objet directement dans les param Spring soccupe de linjection
    @Bean
    CommandLineRunner start(HospitalServices HospitalServicesImplemente)
    {
        return args -> {

            // Créer un nouvel objet Patient pour chaque itération :
            Stream.of("Moussa" ,"Ben","Aicha").forEach(
                    name->{
                        Patient patient=new Patient();
                        patient.setName(name);
                        patient.setMalade(false);
                        patient.setDateNaissance(new Date());
                        HospitalServicesImplemente.savePatient(patient);
                    }
            );

            // Créer un nouvel objet Medecin pour chaque itération :
            Stream.of("Achraf" ,"Amin","Kouya").forEach(
                    name->{
                        Medecin medecin=new Medecin();
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        HospitalServicesImplemente.saveMedecin(medecin);
                    }
            );

            Patient patient=HospitalServicesImplemente.findPatientById(1L);
            Patient patient1=HospitalServicesImplemente.findPatientByName("Moussa");


            Medecin medecin1=HospitalServicesImplemente.findMedecinById(1L);
            Medecin medecin=HospitalServicesImplemente.findMedecinByName("Amin");


            //ajouter un rendezVous avez le patient et le medecin
            RendezVous rendezVous=new RendezVous();
            rendezVous.setId(UUID.randomUUID().toString());
            rendezVous.setDate(new Date());
            rendezVous.setStatutRDV(StatutRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            RendezVous savedRDV=HospitalServicesImplemente.saveRendezVous(rendezVous);
            System.out.println("Rendez vous ajouté avec id:"+savedRDV.getId());

            // rechercher par id le rendezVous créé
            RendezVous rendezvouscree=HospitalServicesImplemente.findRendezVous();

            //ajouter une consultation du rendez créé
            Consultation consultation=new Consultation();
            consultation.setRendezVous(rendezvouscree);
            consultation.setRapport("Rapport de consultation");
            consultation.setDateConsultation(new Date());
            HospitalServicesImplemente.saveConsultation(consultation);


        };
    }

}
