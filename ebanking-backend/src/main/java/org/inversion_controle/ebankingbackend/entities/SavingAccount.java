package org.inversion_controle.ebankingbackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//la valeur du type
//table per classe na pas besoin de valeur pour differencier
@DiscriminatorValue("SA")

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
//herite d'un compte normal
public class SavingAccount extends BankAccount{
    private double interestRate;
}
