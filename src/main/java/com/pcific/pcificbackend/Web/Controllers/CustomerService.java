package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.IUserService;
import com.pcific.pcificbackend.Web.Dtos.CustomerListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerService {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/getCustomers")
    public Page<CustomerListDto> listCustomers(Pageable pageable){
        return iUserService.listCustomers(pageable)
                .map(customer->CustomerListDto
                        .builder()
                        .id(customer.getId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .build());
    }
}
