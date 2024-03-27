package PFE.usermanagementservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import PFE.usermanagementservice.Entity.Permission;
import PFE.usermanagementservice.Entity.Member;
import PFE.usermanagementservice.Repository.PermissionRepository;
import PFE.usermanagementservice.Repository.MemberRepository;


@EnableWebMvc
@SpringBootApplication
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);

	}
	@Bean
    public CommandLineRunner demoData(MemberRepository userRepository, PermissionRepository permissionRepository) {
        return args -> {
            // Create permissions
            Permission Viewer = new Permission( 1L, "READ");
            Permission Admin = new Permission(2L, "WRITE");

            // Save permissions
            permissionRepository.save(Viewer);
            permissionRepository.save(Admin);

            // Create users
            Member user1 = new Member(1L, "user1", "password1", "user1@example.com", "READ");
            Member user2 = new Member(2L, "user2", "password2", "user2@example.com", "READ");
            Member user3 = new Member(3L, "user3", "password3", "user3@example.com", "WRITE");

            // Save users
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };
    }


}
