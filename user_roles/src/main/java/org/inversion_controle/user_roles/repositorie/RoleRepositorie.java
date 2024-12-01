package org.inversion_controle.user_roles.repositorie;

import org.inversion_controle.user_roles.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositorie extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);
}
