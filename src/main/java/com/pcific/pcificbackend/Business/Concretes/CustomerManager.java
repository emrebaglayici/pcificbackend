package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.ICustomerService;
import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Entities.VerificationToken;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Repositories.UserRepository;
import com.pcific.pcificbackend.Repositories.VerificationTokenRepository;
import com.pcific.pcificbackend.Web.Dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager implements ICustomerService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Page<User> listCustomers(Pageable pageable) {
        return this.userRepository.findUsersByRoleNameNotNull(pageable);
    }

    @Override @Transactional
    public void deleteById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new NotFoundException("Customer Not Found!"));
        this.verificationTokenRepository.deleteByUserId(user.getId());
        this.userRepository.deleteById(user.getId());
    }

    @Override
    public void updateCustomerInfo(User user) {
       this.userRepository.save(user);
    }
}
