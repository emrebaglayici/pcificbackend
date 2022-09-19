package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.IRoleService;
import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class RoleService implements IRoleService{
    private final RoleRepository roleRepository;

    @Override
    public Page<Role> listRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }
}
