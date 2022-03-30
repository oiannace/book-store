package com.oiannace.forumapi.service.implementation;

import com.oiannace.forumapi.payload.AppUser;
import com.oiannace.forumapi.payload.Role;
import com.oiannace.forumapi.repository.AppUserRepository;
import com.oiannace.forumapi.repository.RoleRepository;
import com.oiannace.forumapi.repository.ThreadRepository;
import com.oiannace.forumapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service @Transactional
public class AppUserServiceimpl implements AppUserService {
    private final AppUserRepository AppUserRepo;
    private final RoleRepository RoleRepo;

    @Autowired
    public AppUserServiceimpl(AppUserRepository AppUserRepo, RoleRepository RoleRepo)
    {
        this.AppUserRepo = AppUserRepo;
        this.RoleRepo = RoleRepo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return AppUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return RoleRepo.save(role);
    }

    @Override
    public void assignRole(String username, String rolename) {
        AppUser user = AppUserRepo.findByUsername(username);
        Role role = RoleRepo.findByName(rolename);
        user.getRoles().add(role);
        //@transactional ensures that everythign is saved back to database afterwards
    }

    @Override
    public AppUser getUser(String username) {
        return AppUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return AppUserRepo.findAll();
    }
}
