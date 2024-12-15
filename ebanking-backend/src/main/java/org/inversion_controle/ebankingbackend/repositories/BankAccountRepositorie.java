package org.inversion_controle.ebankingbackend.repositories;

import org.inversion_controle.ebankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepositorie extends JpaRepository<BankAccount,String> {

}
