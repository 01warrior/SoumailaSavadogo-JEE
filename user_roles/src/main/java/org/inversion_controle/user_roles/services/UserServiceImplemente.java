package org.inversion_controle.user_roles.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.inversion_controle.user_roles.entities.Role;
import org.inversion_controle.user_roles.entities.User;
import org.inversion_controle.user_roles.repositorie.RoleRepositorie;
import org.inversion_controle.user_roles.repositorie.UserRepositorie;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@AllArgsConstructor vas créer le constructeur avec les parametres
@Service @Transactional @AllArgsConstructor
public class UserServiceImplemente implements UserService {

    UserRepositorie userRepositorie;
    RoleRepositorie roleRepositorie;

    @Override
    public User addNewUser(User user) {
        //Generer le id et save
        user.setUserId(UUID.randomUUID().toString());
        return userRepositorie.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        //la lid est géré par la bd (autoincrement)
        return roleRepositorie.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        //definir la methode dans le repository
        return userRepositorie.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepositorie.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        User user=findUserByUserName(username);
        Role role=findRoleByRoleName(roleName);

        if(user.getRoles()!=null){

            //ajouter le role dans la colletion de role de l'user
            //Attention cela est Possible parce qu'on a innitialiser role dans user avec arrayList si non null par defaut
            user.getRoles().add(role);
            System.out.println("Role "+role.getRoleName()+" ajouté au role de l'utilisateur "+user.getUserName());

            //ajouter le user dans la colletion de user du role
            //Attention cela est Possible parce qu'on a innitialiser user dans role avec arrayList si non null par defaut
            role.getUsers().add(user);
            System.out.println("Utilisateur"+user.getUserName()+" ajouté Au Utilisateur du role :"+role.getRoleName());

            //des deux sens parce que cest une relation bidirectionnelle
        }
        //pas besoin de faire user.save vue que la methode est transactionnel. @Transactionnal il fera le commit a la fin

        // Sauvegarder les deux pour synchroniser avec la base de données
        userRepositorie.save(user);
        roleRepositorie.save(role);
    }

    @Override
    public User autentificate(String username, String password) {
        User user=userRepositorie.findByUserName(username);
        if(user==null){
            throw new RuntimeException("Bad credentials");
        }
        if(user.getPassword().equals(password)){
            System.out.println("autentificate done");
            return user;
        }throw new RuntimeException("Bad credentials");
    }
}
