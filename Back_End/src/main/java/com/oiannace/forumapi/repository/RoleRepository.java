package com.oiannace.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oiannace.forumapi.payload.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
