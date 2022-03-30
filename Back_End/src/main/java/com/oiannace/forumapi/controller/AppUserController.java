package com.oiannace.forumapi.controller;

import com.oiannace.forumapi.payload.AppUser;
import com.oiannace.forumapi.payload.Role;
import com.oiannace.forumapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppUserController {
    private final AppUserService userService;
    @Autowired
    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @PostMapping("/user/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping("/user/assignrole")
    public ResponseEntity<?>saveRole(@RequestBody RoleToAppUser roletouser){
        userService.assignRole(roletouser.getUsername(),roletouser.getRoleName());
        return ResponseEntity.ok().build();
    }

}
class RoleToAppUser {
    private String username;
    private String roleName;

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRoleName() {
        return this.roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}