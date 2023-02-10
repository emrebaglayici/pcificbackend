package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Web.Dtos.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<User> findById(Long id);
    Page<User> listCustomers(Pageable pageable);
    void deleteById(Long id);

    void updateCustomerInfo(User user);
}
