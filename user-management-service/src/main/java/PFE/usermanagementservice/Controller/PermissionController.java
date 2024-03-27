package PFE.usermanagementservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import PFE.usermanagementservice.Entity.Permission;
import PFE.usermanagementservice.Service.PermissionService;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    private final PermissionService permissionService;
    
    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        Permission createdPermission = permissionService.createPermission(permission);
        return ResponseEntity.ok(createdPermission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable("id") Long id, @RequestBody String newName) {
        Permission updatedPermission = permissionService.updatePermission(id, newName);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable("id") Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
