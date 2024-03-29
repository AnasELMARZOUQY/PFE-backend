package PFE.taskmanagementservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import PFE.taskmanagementservice.Entity.Deliverable;
import PFE.taskmanagementservice.Entity.Task;
import PFE.taskmanagementservice.Repository.DeliverableRepository;
import PFE.taskmanagementservice.Repository.TaskRepository;

@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
public class TaskManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner demoData(TaskRepository taskRepository, DeliverableRepository deliverableRepository) {
		return args -> {
			Task task = new Task();
			task.setName("Task 1");
			task.setDescription("Task 1 description");
			taskRepository.save(task);
			
			Deliverable deliverable = new Deliverable();
			deliverable.setName("Deliverable 1");
			deliverable.setDescription("Deliverable 1 description");
			deliverableRepository.save(deliverable);
		};
	}
}
