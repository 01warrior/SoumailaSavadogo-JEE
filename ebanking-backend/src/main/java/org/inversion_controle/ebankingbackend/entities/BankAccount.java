package org.inversion_controle.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.inversion_controle.ebankingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;

//----------------------nouveau---------------------pour utiliser l'heritage avec la startegie utilisé dans la classe mere

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "TYPE",length = 4,discriminatorType = DiscriminatorType.STRING)

//Du coup la classe mere ici devient une class abstraite soit on a un currentAcount ou un SavingAccount
//parce quon a pas besoin de table pour cette classe
@Data  @Entity @AllArgsConstructor @NoArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    //un compte appartient a un client donc clé client ici pour les identifer de facon unique
    @ManyToOne
    private Customer customer;

    //le compte peut avoir une liste d'operations plusieur
    //par defaut FetchType.LAZY
    @OneToMany(mappedBy = "bankAccount" ,fetch = FetchType.EAGER)
    private List<AccountOperation> operations;
}

