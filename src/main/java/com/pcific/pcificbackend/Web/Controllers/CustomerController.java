package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.ICustomerService;
import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Web.Dtos.CustomerDto;
import com.pcific.pcificbackend.Web.Dtos.CustomerUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/listCustomers")
    public Page<CustomerDto> listCustomers(Pageable pageable){
        return iCustomerService.listCustomers(pageable)
                .map(customer->CustomerDto.builder()
                        .id(customer.getId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .roleName(customer.getRoleName())
                        .build());
    }

    @DeleteMapping("deleteCustomer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        this.iCustomerService.deleteById(id);
    }

    @PatchMapping("/updateCustomerInfo/{id}")
    public CustomerDto updateCustomerInfo(@PathVariable Long id,@RequestBody CustomerUpdateDto dto){
        User customer=iCustomerService.findById(id).orElseThrow(()->new NotFoundException("Customer not found"));
        boolean needUpdate=false;

        if(StringUtils.hasLength(dto.toUser().getEmail())){
            customer.setEmail(dto.toUser().getEmail());
            needUpdate=true;
        }
        if ((StringUtils.hasLength(dto.toUser().getFirstName()))){
            customer.setFirstName(dto.toUser().getFirstName());
            needUpdate=true;
        }
        if ((StringUtils.hasLength(dto.toUser().getLastName()))){
            customer.setFirstName(dto.toUser().getLastName());
            needUpdate=true;
        }
        if (needUpdate){
            iCustomerService.updateCustomerInfo(customer);
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
