package PFE.taskmanagementservice.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PFE.taskmanagementservice.Entity.Deliverable;

@Repository
public interface DeliverableRepository extends JpaRepository<Deliverable, Long> {
    List<Deliverable> findByTaskId(Long taskId);
    Optional<Deliverable> findByIdAndTaskId(Long deliverableId, Long taskId);
}