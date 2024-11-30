package org.inversion_controle.gestion_prod_jpa.repository;

import org.inversion_controle.gestion_prod_jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByNameContains(String name);

    //autre facon de faire
    @Query("select p from Product  p where  p.name like :x")
    List<Product> searchString(@Param("x") String name);

    @Query("select p from Product  p where  p.price > :x")
    List<Product> searchPrice(@Param("x") double price);

    List<Product> findProductByPriceGreaterThan(double priceIsGreaterThan);
}
