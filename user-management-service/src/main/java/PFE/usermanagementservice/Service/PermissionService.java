package PFE.usermanagementservice.Service;

import java.nio.file.ProviderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PFE.usermanagementservice.Entity.Permission;
import PFE.usermanagementservice.Repository.PermissionRepository;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;
    
    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }
    
    public Permission updatePermission(Long permissionId, String newName) {
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new ProviderNotFoundException("Permission not found"));
        permission.setName(newName);
        return permissionRepository.save(permission);
    }
    
    public void deletePermission(Long permissionId) {
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new ProviderNotFoundException("Permission not found"));
        permissionRepository.delete(permission);
    }
}