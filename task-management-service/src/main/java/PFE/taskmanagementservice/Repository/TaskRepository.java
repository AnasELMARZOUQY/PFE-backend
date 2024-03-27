package PFE.taskmanagementservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PFE.taskmanagementservice.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByName(String name);
}