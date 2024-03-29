package PFE.usermanagementservice.Service;

import java.nio.file.ProviderNotFoundException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PFE.usermanagementservice.Entity.Permission;
import PFE.usermanagementservice.Entity.Member;
import PFE.usermanagementservice.Repository.PermissionRepository;
import PFE.usermanagementservice.Repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository userRepository;
    private final PermissionRepository permissionRepository;

    @Autowired
    public MemberService(MemberRepository userRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
    }

    public Member createMember(Member user, String permissionName) {
        Permission permission = permissionRepository.findByName(permissionName)
                .orElseThrow(() -> new ProviderNotFoundException("Permission not found"));
        user.setRole(permission.getName());
        return userRepository.save(user);
    }


    public Member updateMember(Long userId, Member updatedMember) throws UserPrincipalNotFoundException {
        Member user = userRepository.findById(userId)
                .orElseThrow(() -> new UserPrincipalNotFoundException("Member not found"));
        user.setName(updatedMember.getName());
        user.setEmail(updatedMember.getEmail());
        // Update other fields as needed
        return userRepository.save(user);
    }

    public void deleteMember(Long userId) throws UserPrincipalNotFoundException {
        Member user = userRepository.findById(userId)
                .orElseThrow(() -> new UserPrincipalNotFoundException("Member not found"));
        userRepository.delete(user);
    }

    public Member changePassword(Long userId, String newPassword) throws UserPrincipalNotFoundException {
        Member user = userRepository.findById(userId)
                .orElseThrow(() -> new UserPrincipalNotFoundException("Member not found"));
        user.setPassword(newPassword);
        return userRepository.save(user);
    }
    public Member changePermission(Long userId, String newPermissionName) throws UserPrincipalNotFoundException {
        Member user = userRepository.findById(userId)
                .orElseThrow(() -> new UserPrincipalNotFoundException("Member not found"));
        Permission permission = permissionRepository.findByName(newPermissionName)
                .orElseThrow(() -> new ProviderNotFoundException("Permission not found"));
        user.setRole(permission.getName());
        return userRepository.save(user);
    }

    public Member getMember(Long userId) {
        try {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new UserPrincipalNotFoundException("Member not found"));
        } catch (UserPrincipalNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

