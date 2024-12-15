package org.inversion_controle.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Entity @AllArgsConstructor @NoArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private  String name;
    private  String email;

    //un client peut avoir plusieur compte mappé par la clé etrangère sur BankAccount
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}
