package org.inversion_controle.user_roles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

//jai renommé le nom de la table avec S parce que USER est reservé par mysql
@Table(name = "USERS")
public class User {
    @Id
    private String userId;
    @Column(unique = true, nullable = false,length = 20)
    private String userName;
    private String password;

    //FetchType.EAGER : charger tout les elements
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
}
