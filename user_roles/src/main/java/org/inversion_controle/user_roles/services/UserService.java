package org.inversion_controle.user_roles.services;

import org.inversion_controle.user_roles.entities.Role;
import org.inversion_controle.user_roles.entities.User;


public interface UserService {
     User addNewUser(User user);
     Role addNewRole(Role role);
     User findUserByUserName(String userName);
     Role findRoleByRoleName(String roleName);

    //ajouter un role a un user

     void addRoleToUser(String username,String roleName);

     User autentificate(String username,String password);
}
