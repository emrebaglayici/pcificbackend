package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.IUserService;
import com.pcific.pcificbackend.Controllers.Dtos.RoleCreationDto;
import com.pcific.pcificbackend.Controllers.Dtos.UserCreateDto;
import com.pcific.pcificbackend.Controllers.Dtos.UserDto;
import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.Roles;
import com.pcific.pcificbackend.Entities.Users;
import com.pcific.pcificbackend.Repositories.RoleRepository;
import com.pcific.pcificbackend.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service @RequiredArgsConstructor  @Transactional  @Slf4j
public class UserService implements IUserService , UserDetailsService {
    private final UsersRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    @Override
    public Page<Users> listUsers(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public Users saveUser(UserCreateDto user) {
        log.info("Saving new user {} to the database", user.toUser().getUsername());
        user.setPassword(passwordEncoder.encode(user.toUser().getPassword()));

        return userRepo.save(user.toUser());
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        Users user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public Users getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

//    @Override
//    public List<Users> getUsers() {
//        log.info("Fetching all users");
//        return userRepo.findAll();
//    }
}
