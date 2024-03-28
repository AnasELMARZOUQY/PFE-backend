package PFE.projectmanagementservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PFE.projectmanagementservice.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Custom query methods if needed
}