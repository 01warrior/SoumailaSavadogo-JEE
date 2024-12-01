# Documentation de l'Application Hospitalière

## Introduction
Cette application hospitalière est conçue pour gérer les patients, les médecins, les rendez-vous et les consultations. Cette documentation présente les concepts clés et les fonctionnalités de l'application.

## Architecture de l'application
L'application est construite sur le framework Spring Boot, qui facilite le développement d'applications Java. Elle utilise une architecture basée sur des entités, des dépôts et des services.

## Entités

### Patient
- **Attributs**:
  - `Long id`: Identifiant unique du patient.
  - `String name`: Nom du patient.
  - `Date dateNaissance`: Date de naissance du patient.
  - `boolean malade`: Indique si le patient est malade.
- **Relations**:
  - Un patient peut avoir plusieurs rendez-vous.

### Medecin
- **Attributs**:
  - `Long id`: Identifiant unique du médecin.
  - `String nom`: Nom du médecin.
  - `String email`: Adresse e-mail du médecin.
  - `String specialite`: Spécialité du médecin.

### RendezVous
- **Attributs**:
  - `String id`: Identifiant unique du rendez-vous.
  - `Date date`: Date du rendez-vous.
  - `boolean annule`: Indique si le rendez-vous a été annulé.
  - `StatutRDV statutRDV`: Statut du rendez-vous.
- **Relations**:
  - Un rendez-vous est associé à un patient et un médecin.

### Consultation
- **Attributs**:
  - `Long id`: Identifiant unique de la consultation.
  - `Date dateConsultation`: Date de la consultation.
  - `String rapport`: Rapport de la consultation.
- **Relations**:
  - Une consultation est associée à un rendez-vous.

### StatutRDV
- **Valeurs possibles**:
  - `PENDING`: En attente.
  - `CANCELED`: Annulé.
  - `DONE`: Réalisé.

## Dépôts
Les dépôts permettent d'interagir avec la base de données. Ils héritent de `JpaRepository`, ce qui leur permet d'accéder à des méthodes CRUD.

### ConsultationRepositorie
- Méthodes:
  - `Consultation save(Consultation consultation)`: Enregistre une consultation.

### MedecinRepositorie
- Méthodes:
  - `Medecin findByNom(String nom)`: Recherche un médecin par son nom.

### PatientRepositorie
- Méthodes:
  - `Patient findByName(String name)`: Recherche un patient par son nom.

### RendezVousRepositorie
- Méthodes:
  - `RendezVous save(RendezVous rendezVous)`: Enregistre un rendez-vous.

## Services
Les services contiennent la logique métier et interagissent avec les dépôts.

### HospitalServices
- Méthodes:
  - `Patient savePatient(Patient patient)`: Enregistre un patient.
  - `Medecin saveMedecin(Medecin medecin)`: Enregistre un médecin.
  - `Consultation saveConsultation(Consultation consultation)`: Enregistre une consultation.
  - `RendezVous saveRendezVous(RendezVous rendezVous)`: Enregistre un rendez-vous.

