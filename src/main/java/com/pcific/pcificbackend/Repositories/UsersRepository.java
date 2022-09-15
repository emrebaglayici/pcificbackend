package com.pcific.pcificbackend.Repositories;

import com.pcific.pcificbackend.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
