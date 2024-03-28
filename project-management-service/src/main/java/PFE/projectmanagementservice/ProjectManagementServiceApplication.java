package PFE.projectmanagementservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import PFE.projectmanagementservice.Entity.Project;
import PFE.projectmanagementservice.Repository.ProjectRepository;

@SpringBootApplication
@EnableWebMvc
public class ProjectManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProjectRepository projectRepository) {
		return args -> {
			// Create and initialize project objects
			Project project1 = new Project(null, "Project 1", "first", null, null, null);
			Project project2 = new Project(null, "Project 2", "second", null, null, null);
			Project project3 = new Project(null, "Project 3", "third", null, null, null);
			projectRepository.save(project1);
			projectRepository.save(project2);
			projectRepository.save(project3);

		
		};
	}

}
