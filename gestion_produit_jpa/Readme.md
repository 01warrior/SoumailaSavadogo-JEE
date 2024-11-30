# Étapes principales réalisées

## Installation d’IntelliJ IDEA Ultimate
- Configuration de l’environnement de développement.

## Création du projet Spring Boot
- Utilisation de **Spring Initializer** avec les dépendances suivantes :
  - **Spring Data JPA**
  - **H2 Database**
  - **Spring Web**
  - **Lombok**

## Définition de l’entité JPA `Product`
- **Attributs :**
  - `id` : Long (clé primaire, annotée avec `@Id`).
  - `name` : String  
  - `price` : double  
  - `quantity` : int  
- Annotation **`@Entity`** pour rendre la classe persistante.
- Utilisation de **Lombok (`@Data`)** pour générer automatiquement les getters et setters.

## Configuration de la base de données dans `application.properties`
- Paramétrage pour utiliser **H2 Database**, avec activation de l’interface web (`h2-console`).

## Création du Repository Spring Data JPA
- Interface `ProductRepository` héritant de `JpaRepository<Product, Long>`.

## Test des opérations CRUD avec H2 Database
- **Ajout de produits** : Enregistrement dans la base de données.
- **Consultation de tous les produits** : Lecture de la table `product`.
- **Consultation d’un produit** : Recherche par ID.
- **Recherche par nom** : Utilisation d'une méthode personnalisée dans `ProductRepository`.
- **Mise à jour d’un produit.**
- **Suppression d’un produit.**

## Migration vers MySQL
- Installation et configuration de **WAMP** (serveur local).
- Ajout de la dépendance **MySQL driver** dans le projet Maven.
- Modification des paramètres dans `application.properties` pour se connecter à MySQL.

## Création d’un Web Service REST
- Création d’une classe avec l'annotation **`@RestController`** pour exposer des endpoints.
- **Méthodes exposées** via annotations :
  - **`@GetMapping("/products")`** : Récupération de la liste des produits.
- **Injection de dépendance** du repository `ProductRepository` avec **`@Autowired`**.
