package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.Users;

import java.util.List;

public interface IUserService {
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Users getUser(String username);
    List<Users> getUsers();
}
