package com.oiannace.forumapi.service.implementation;

import com.oiannace.forumapi.method.AppUser;
import com.oiannace.forumapi.method.Role;
import com.oiannace.forumapi.repository.AppUserRepository;
import com.oiannace.forumapi.repository.RoleRepository;
import com.oiannace.forumapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @Transactional
public class AppUserServiceimpl implements AppUserService, UserDetailsService {
    private final AppUserRepository AppUserRepo;
    private final RoleRepository RoleRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public AppUserServiceimpl(AppUserRepository AppUserRepo, RoleRepository RoleRepo, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.AppUserRepo = AppUserRepo;
        this.RoleRepo = RoleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        //when account is created by post request, password is stared in encoded form
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
        //@transactional ensures that everything is saved back to database afterwards
    }

    @Override
    public AppUser getUser(String username) {
        return AppUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return AppUserRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = AppUserRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found in database");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
