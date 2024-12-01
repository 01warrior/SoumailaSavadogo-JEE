package org.inversion_controle.user_roles.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data  //defini les setter getter ...
@NoArgsConstructor //genere un constructeur avec tout les argument
@AllArgsConstructor // genere un constructeur sans argument

//jai renommé le nom de la table avec S parce que ROLE est reservé par mysql
@Table(name = "ROLES")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 20)
    private String roleName;
    //desc est un mot reservé donc je change le nom de la colonne
    @Column(name = "Description")
    private  String desc;

    //pour pas quil essaie de charger la liste des user encore qui nous entrainera dans une boucle
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users=new ArrayList<>();
}
