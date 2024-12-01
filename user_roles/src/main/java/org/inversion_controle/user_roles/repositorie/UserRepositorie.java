package org.inversion_controle.user_roles.repositorie;

import org.inversion_controle.user_roles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<User, String> {

    User findByUserName(String userName);

}
