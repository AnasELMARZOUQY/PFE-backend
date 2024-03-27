package PFE.taskmanagementservice.Controller;

import java.util.List;

import org.apache.commons.io.TaggedIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PFE.taskmanagementservice.Entity.Deliverable;
import PFE.taskmanagementservice.Entity.Task;
import PFE.taskmanagementservice.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) throws TaggedIOException {
        Task updatedTaskResponse = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.ok(updatedTaskResponse);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) throws TaggedIOException {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{taskId}/deliverables")
    public ResponseEntity<List<Deliverable>> getDeliverables(@PathVariable Long taskId) {
        List<Deliverable> deliverables = taskService.getDeliverables(taskId);
        return ResponseEntity.ok(deliverables);
    }

    @PostMapping("/{taskId}/deliverables")
    public ResponseEntity<Deliverable> createDeliverable(@PathVariable Long taskId, @RequestBody Deliverable deliverable) {
        Deliverable createdDeliverable = taskService.createDeliverable(deliverable, taskId);
        return ResponseEntity.ok(createdDeliverable);
    }
        @PutMapping("/{taskId}/deliverables/{deliverableId}")
        public ResponseEntity<Deliverable> updateDeliverable(@PathVariable Long taskId, @PathVariable Long deliverableId, @RequestBody Deliverable updatedDeliverable) throws TaggedIOException {
            Deliverable updatedDeliverableResponse = taskService.updateDeliverable(taskId, deliverableId, updatedDeliverable);
            return ResponseEntity.ok(updatedDeliverableResponse);
        }

        @DeleteMapping("/{taskId}/deliverables/{deliverableId}")
        public ResponseEntity<Void> deleteDeliverable(@PathVariable Long taskId, @PathVariable Long deliverableId) throws TaggedIOException {
            taskService.deleteDeliverable(taskId, deliverableId);
            return ResponseEntity.noContent().build();
        }
    }
 