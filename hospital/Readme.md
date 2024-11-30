Points abordés

Définition des entités JPA

Création des entités principales (Patient, Docteur, Consultation, RendezVous).
Utilisation des annotations pour les relations (@OneToOne, @OneToMany, etc.).
Configuration de la base de données

Paramétrage d'H2 Database dans application.properties.
Création des interfaces Spring Data JPA

Définition des interfaces héritant de JpaRepository pour les opérations CRUD.
Initialisation des données au démarrage

Méthode avec CommandLineRunner.
Méthode alternative avec @Bean pour une injection simplifiée.
Bonnes pratiques pour les requêtes et la gestion des objets

Création d'objets avant sauvegarde avec les set.
Gestion des identifiants avec UUID pour des ID uniques.
Requêtes robustes

Utilisation de findById avec gestion des cas d'erreur.
Architecture en couches

Organisation par packages (dao, service, controller).
Mise en place d’une couche métier avec interface et implémentation.
Injection des dépendances dans les services et contrôleurs.
Centralisation des opérations dans la couche métier

Simplification et meilleure maintenabilité du code.