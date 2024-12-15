package org.inversion_controle.ebankingbackend.repositories;

import org.inversion_controle.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositorie extends JpaRepository<Customer,Long> {

}
