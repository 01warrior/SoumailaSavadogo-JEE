package org.inversion_controle.ebankingbackend;

import org.inversion_controle.ebankingbackend.entities.*;
import org.inversion_controle.ebankingbackend.enums.AccountStatus;
import org.inversion_controle.ebankingbackend.enums.OperarionType;
import org.inversion_controle.ebankingbackend.repositories.AccountOperationRepositorie;
import org.inversion_controle.ebankingbackend.repositories.BankAccountRepositorie;
import org.inversion_controle.ebankingbackend.repositories.CustomerRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    //@Bean
    CommandLineRunner start( CustomerRepositorie customerRepositorie ,
                             BankAccountRepositorie bankAccountRepositorie,
                             AccountOperationRepositorie accountOperationRepositorie)
    {
        return args -> {

            Stream.of("Hassan","Ali","Adja").forEach(
                    name->{
                        Customer client=new Customer();
                        client.setName(name);
                        client.setEmail(name+"@gmail.com");
                        customerRepositorie.save(client);
                    }
            );



            //pour chaque client créer un compte
            customerRepositorie.findAll().forEach(client-> {
                //créer un compte courant a ajouter dans les compte
                CurrentAccount compteC=new CurrentAccount();
                compteC.setCustomer(client);
                compteC.setBalance(Math.random()*90000);
                compteC.setCreatedAt(new Date());
                compteC.setStatus(AccountStatus.CREATED);
                compteC.setOverDraft(9000);

                //vue quil herite d'un compte et que lid du compte est de type string
                compteC.setId(UUID.randomUUID().toString());

                //sauvegarder un compte bancaire
                bankAccountRepositorie.save(compteC);


                //créer un compte d'eparge egalement
                //créer un compte courant a ajouter dans les compte
                SavingAccount compteE=new SavingAccount();
                compteE.setCustomer(client);
                compteE.setBalance(Math.random()*90000);
                compteE.setCreatedAt(new Date());
                compteE.setStatus(AccountStatus.CREATED);
                //pour le compte epargne cest taux d'interet
                compteE.setInterestRate(5.5);

                compteE.setId(UUID.randomUUID().toString());

                //sauvegarder un compte bancaire
                bankAccountRepositorie.save(compteE);

            });

            //pour chaque compte on crée des opération
            bankAccountRepositorie.findAll().forEach(
                    account->{

                        for(int i=0;i<10;i++)
                        {
                            AccountOperation accountOperation=new AccountOperation();
                            accountOperation.setOperationDate(new Date());
                            accountOperation.setAmount(Math.random()*12000);
                            accountOperation.setType(Math.random()>0.5 ? OperarionType.CREDIT:OperarionType.DEBIT);
                            accountOperation.setBankAccount(account);
                            accountOperationRepositorie.save(accountOperation);
                        }

                    }
            );




        };
    }

    @Bean
    CommandLineRunner start(BankAccountRepositorie bankAccountRepositorie)
    {
        return args -> {
            //aficher un compte
            BankAccount bankAccount=bankAccountRepositorie.findById("8d03a7c5-7804-4af8-8c11-263b4754e805").orElse(null);

            if(bankAccount!=null)
            {
                System.out.println("***************  Info  ***********************");
                System.out.println(bankAccount.getId());
                System.out.println(bankAccount.getBalance());
                System.out.println(bankAccount.getCreatedAt());
                System.out.println(bankAccount.getStatus());
                System.out.println(bankAccount.getCustomer().getName());

                //le nom de la class du compte
                System.out.println(bankAccount.getClass().getSimpleName());

                if(bankAccount instanceof CurrentAccount)
                {
                    System.out.println("Over Draft :::"+((CurrentAccount) bankAccount).getOverDraft());
                }else if(bankAccount instanceof SavingAccount)
                {
                    System.out.println("Rate ::"+((SavingAccount) bankAccount).getInterestRate());
                }

                bankAccount.getOperations().forEach(
                        accountOperation -> {
                            System.out.println("--------------Operation-----------------");
                            System.out.println(accountOperation.getType());
                            System.out.println(accountOperation.getAmount());
                            System.out.println(accountOperation.getOperationDate());

                        }
                );
            }
        };
    }

}
