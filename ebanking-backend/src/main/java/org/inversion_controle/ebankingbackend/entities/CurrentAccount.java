package org.inversion_controle.ebankingbackend.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

//table per classe na pas besoin de valeur pour differencier
@DiscriminatorValue("CA")

//herite d'un compte normal
public class CurrentAccount extends BankAccount {
    private double overDraft;
}
