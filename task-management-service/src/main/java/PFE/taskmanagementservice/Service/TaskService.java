package PFE.taskmanagementservice.Service;

import java.util.List;

import org.apache.commons.io.TaggedIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PFE.taskmanagementservice.Entity.Deliverable;
import PFE.taskmanagementservice.Entity.Task;
import PFE.taskmanagementservice.Repository.DeliverableRepository;
import PFE.taskmanagementservice.Repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final DeliverableRepository deliverableRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, DeliverableRepository deliverableRepository) {
        this.taskRepository = taskRepository;
        this.deliverableRepository = deliverableRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task updatedTask) throws TaggedIOException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaggedIOException(null, "Task not found"));
        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) throws TaggedIOException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaggedIOException(null, "Task not found"));
        taskRepository.delete(task);
    }

    public List<Deliverable> getDeliverables(Long taskId) {
        return deliverableRepository.findByTaskId(taskId);
    }

    public Deliverable createDeliverable(Deliverable deliverable, Long taskId) {
        deliverable.setTaskId(taskId);
        return deliverableRepository.save(deliverable);
    }
        public Deliverable updateDeliverable(Long deliverableId, Long taskId, Deliverable updatedDeliverable) throws TaggedIOException {
            Deliverable deliverable = deliverableRepository.findByIdAndTaskId(deliverableId, taskId)
                    .orElseThrow(() -> new TaggedIOException(null, "Deliverable not found"));
            deliverable.setName(updatedDeliverable.getName());
            deliverable.setDescription(updatedDeliverable.getDescription());
            deliverable.setStatus(updatedDeliverable.getStatus());
            return deliverableRepository.save(deliverable);
        }

        public void deleteDeliverable(Long deliverableId, Long taskId) throws TaggedIOException {
            Deliverable deliverable = deliverableRepository.findByIdAndTaskId(deliverableId, taskId)
                    .orElseThrow(() -> new TaggedIOException(null, "Deliverable not found"));
            deliverableRepository.delete(deliverable);
        }
    }
    
