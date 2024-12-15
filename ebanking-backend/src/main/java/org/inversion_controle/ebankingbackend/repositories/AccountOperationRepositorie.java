package org.inversion_controle.ebankingbackend.repositories;

import org.inversion_controle.ebankingbackend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepositorie extends JpaRepository<AccountOperation,Long> {

}
