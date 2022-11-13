package com.pcific.pcificbackend.Repositories;
import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

//    List<User> findAllByRoles(Collection<Role> roles);

}
