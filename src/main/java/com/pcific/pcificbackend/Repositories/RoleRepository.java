package com.pcific.pcificbackend.Repositories;

import com.pcific.pcificbackend.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
