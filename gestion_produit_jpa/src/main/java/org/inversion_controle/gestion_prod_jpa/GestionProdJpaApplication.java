package org.inversion_controle.gestion_prod_jpa;

import org.inversion_controle.gestion_prod_jpa.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.inversion_controle.gestion_prod_jpa.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class GestionProdJpaApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionProdJpaApplication.class, args);
    }

    //redefinition de la methode de linterface commandeLine...
    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",40050,4));
        productRepository.save(new Product(null,"Pc",23,4));
        productRepository.save(new Product(null,"Television",58,4));
        productRepository.save(new Product(null,"Vélo",45,4));

        productRepository.findAll().forEach(p->{
            System.out.println(p.getName());
        });

        System.out.println("--------Find by id----------");
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println(product.getName());
        System.out.println("--------Find by id end----------");

        System.out.println("--------Delete 3----------");
        productRepository.deleteById(Long.valueOf(3));

        // Modifier un produit avec id 2
        Long idToUpdate = 2L;
        Product productEdit = productRepository.findById(idToUpdate).orElse(null);
        if (productEdit != null) {
            product.setName("Updated");
            product.setPrice(50);
            productRepository.save(product);
        }

        productRepository.findAll().forEach(p->{
            System.out.println(p.getName());
        });

        // Recherche par nom exact
        System.out.println("--------Rechercher----------");
        String nameToFind = "P";
        List<Product> products = productRepository.findProductByNameContains(nameToFind);
        if (!products.isEmpty()) {
            products.forEach(p -> System.out.println("Produit trouvé : " + p.getName() + " - " + p.getPrice()));
        } else {
            System.out.println("Aucun produit trouvé avec le nom : " + nameToFind);
        }

        // Recherche par nom exact 2em facon de faire
        System.out.println("--------Rechercher Deuxieme methode----------");
        String nameToFind2 = "P";
        List<Product> products2 = productRepository.searchString("%"+nameToFind2+"%");
        if (!products.isEmpty()) {
            products2.forEach(p -> System.out.println("Produit trouvé : " + p.getName() + " - " + p.getPrice()));
        } else {
            System.out.println("Aucun produit trouvé avec le nom : " + nameToFind);
        }

        // Recherche par prix exact 2em facon de faire
        System.out.println("--------Rechercher prix superieur a 45----------");
        double price = 45;
        List<Product> products3 = productRepository.findProductByPriceGreaterThan(price);
        if (!products.isEmpty()) {
            products3.forEach(p -> System.out.println("Produit trouvé : " + p.getName() + " - " + p.getPrice()));
        } else {
            System.out.println("Aucun produit trouvé avec le prix : " + nameToFind);
        }

        // Recherche par prix exact 2em facon de faire
        System.out.println("--------Rechercher Deuxieme methode----------");
        double nameToFind4 = 45;
        List<Product> products4 = productRepository.searchPrice(nameToFind4);
        if (!products.isEmpty()) {
            products4.forEach(p -> System.out.println("Produit trouvé : " + p.getName() + " - " + p.getPrice()));
        } else {
            System.out.println("Aucun produit trouvé avec le prix : " + nameToFind);
        }





    }
}
