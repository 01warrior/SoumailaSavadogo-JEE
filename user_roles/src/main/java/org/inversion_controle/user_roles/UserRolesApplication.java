package org.inversion_controle.user_roles;

import org.inversion_controle.user_roles.entities.Role;
import org.inversion_controle.user_roles.entities.User;
import org.inversion_controle.user_roles.services.UserService;
import org.inversion_controle.user_roles.services.UserServiceImplemente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserRolesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRolesApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserServiceImplemente userService) {
		return args1 -> {
			User user = new User();
			//le pass est genéré automatiquement avec UUID coté metier
			user.setUserName("user1");
			user.setPassword("password1");
			userService.addNewUser(user);

			User user2 = new User();
			user2.setUserName("user2");
			user2.setPassword("password2");
			userService.addNewUser(user2);

			Role role =new Role();
			//pass géré coté bd auto increment
			role.setRoleName("ROLE_ADMIN");
			role.setDesc("L'administrateur");
			userService.addNewRole(role);

			Role role2 =new Role();
			role2.setRoleName("ROLE_STUDENT");
			role2.setDesc("L'etudiant");
			userService.addNewRole(role2);

			//mais la en partant du principe que le nom de l'user est unique dans ma bd
			userService.addRoleToUser(user.getUserName(),role.getRoleName());
			userService.addRoleToUser(user.getUserName(),role2.getRoleName());
			userService.addRoleToUser(user2.getUserName(),role2.getRoleName());


			//Essayer d'autentifier l'utilisateur
			try {

				//------------Important grosse difficulté--------------je profite mentionné une erreur qui ma pris des heure j'ignorait que je devait recharger de la bd luser avec les donné mise a jour comme les role et ca me
				// donnais une liste vide jai du galerer pour resoudre ce probleme

				//donc la je retrouve luser avec les donné a jour
				User user3=userService.findUserByUserName(user.getUserName());

				userService.autentificate(user3.getUserName(),user3.getPassword());
				System.out.println(user3.getUserName());
				System.out.println(user3.getUserId());
				//afficher la liste de role
				user3.getRoles().forEach(r -> {
					System.out.println("Role : " + r.toString());
				});
			}catch (Exception e){
				e.printStackTrace();
			}
		};
	}

}
