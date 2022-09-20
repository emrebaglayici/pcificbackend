package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Controllers.Dtos.UserSignUpDto;
import com.pcific.pcificbackend.Entities.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(UserSignUpDto userDto);

    Optional<User> findByUsername(String username);

    //    @Transactional
    void makeAdmin(String username);
}
