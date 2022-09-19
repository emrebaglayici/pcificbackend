package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<Users> listUsers(Pageable pageable);
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Users getUser(String username);
}
