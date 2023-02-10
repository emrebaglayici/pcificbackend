package com.pcific.pcificbackend.Repositories;
import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Web.Dtos.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

//    @Query("from User where roleName ='ROLE_USER'")
//    Page<CustomerDto> findUsersByRoleName(Pageable pageable);

    Page<User> findUsersByRoleNameNotNull(Pageable pageable);
}
