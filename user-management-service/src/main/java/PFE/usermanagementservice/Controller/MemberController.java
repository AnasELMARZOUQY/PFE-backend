package PFE.usermanagementservice.Controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PFE.usermanagementservice.Entity.Member;
import PFE.usermanagementservice.Service.MemberService;

@RestController
@RequestMapping("/api/users")
public class MemberController {
    private final MemberService userService;
    
    @Autowired
    public MemberController(MemberService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member user, @RequestParam String permissionName) {
        Member createdMember = userService.createMember(user, permissionName);
        return ResponseEntity.ok(createdMember);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long userId, @RequestBody Member updatedMember) throws UserPrincipalNotFoundException {
        Member updatedMemberResponse = userService.updateMember(userId, updatedMember);
        return ResponseEntity.ok(updatedMemberResponse);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long userId) throws UserPrincipalNotFoundException {
        userService.deleteMember(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<Member> changePassword(@PathVariable Long userId, @RequestParam String newPassword) throws UserPrincipalNotFoundException {
        Member updatedMember = userService.changePassword(userId, newPassword);
        return ResponseEntity.ok(updatedMember);
    }

    @PutMapping("/{userId}/permission")
    public ResponseEntity<Member> changePermission(@PathVariable Long userId, @RequestParam String newPermission) throws UserPrincipalNotFoundException {
        Member updatedMember = userService.changePermission(userId, newPermission);
        return ResponseEntity.ok(updatedMember);
    }
}