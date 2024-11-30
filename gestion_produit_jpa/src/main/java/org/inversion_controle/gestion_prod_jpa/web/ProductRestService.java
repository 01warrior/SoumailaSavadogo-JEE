package org.inversion_controle.gestion_prod_jpa.web;

import org.inversion_controle.gestion_prod_jpa.entities.Product;
import org.inversion_controle.gestion_prod_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProducts(@PathVariable Long  id) {
        return  productRepository.findById(id).get();
    }

}
