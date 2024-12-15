package org.inversion_controle.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.inversion_controle.ebankingbackend.enums.OperarionType;

import java.util.Date;

@Data @Entity @AllArgsConstructor @NoArgsConstructor

public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;

    @Enumerated(EnumType.STRING)
    private OperarionType type;

    @ManyToOne
    private BankAccount bankAccount;
}
