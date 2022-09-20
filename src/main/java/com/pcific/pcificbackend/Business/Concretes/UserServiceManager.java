package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.IUserService;
import com.pcific.pcificbackend.Controllers.Dtos.UserSignUpDto;
import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class UserServiceManager implements IUserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(UserSignUpDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.toUser().getPassword()));
        return userRepository.save(userDto.toUser());
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void makeAdmin(String username){
        userRepository.updateUserRole(username, Role.ADMIN);
    }
}