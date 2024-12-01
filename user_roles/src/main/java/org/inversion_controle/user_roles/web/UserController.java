package org.inversion_controle.user_roles.web;

import lombok.AllArgsConstructor;
import org.inversion_controle.user_roles.entities.User;
import org.inversion_controle.user_roles.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//créer une couche web
@RestController @AllArgsConstructor
public class UserController {

    //Injection par constructeur
    UserService userService;

    @GetMapping("/users/{username}")
    public User users(@PathVariable String username)
    {
        return userService.findUserByUserName(username);
    }


}
