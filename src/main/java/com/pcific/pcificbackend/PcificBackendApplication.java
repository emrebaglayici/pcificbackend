package com.pcific.pcificbackend;

import com.pcific.pcificbackend.Business.Abstracts.IUserService;
import com.pcific.pcificbackend.Controllers.Dtos.RoleCreationDto;
import com.pcific.pcificbackend.Controllers.Dtos.UserCreateDto;
import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.Roles;
import com.pcific.pcificbackend.Entities.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PcificBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcificBackendApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(IUserService userService) {
        return args -> {
            userService.saveRole(new Role(null, Roles.USER.name()));
            userService.saveRole(new Role(null, Roles.ADMIN.name()));
            userService.saveRole(new Role(null, Roles.SUPER_ADMIN.name()));

            UserCreateDto userCreateDto=new UserCreateDto();
            userCreateDto.setId(null);
            userCreateDto.setName("Emre Bağlayici");
            userCreateDto.setUsername("emrebaglayici");
            userCreateDto.setPassword("1234");
            userCreateDto.setRoles(new ArrayList<>());
            userService.saveUser(userCreateDto);
//            userService.saveUser(new UserCreateDto(null, "Emre Bağlayici", "emrebaglayici", "1234", new ArrayList<>()));
//            userService.saveUser(new Users(null, "Will Smith", "will", "1234", new ArrayList<>()));
//            userService.saveUser(new Users(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
//            userService.saveUser(new Users(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

            userService.addRoleToUser("emrebaglayici", Roles.SUPER_ADMIN.name());
//            userService.addRoleToUser("jim", Roles.ADMIN.name());
//            userService.addRoleToUser("arnold", Roles.SUPER_ADMIN.name());
//            userService.addRoleToUser("arnold", Roles.ADMIN.name());
//            userService.addRoleToUser("arnold", Roles.USER.name());
        };
    }
}

