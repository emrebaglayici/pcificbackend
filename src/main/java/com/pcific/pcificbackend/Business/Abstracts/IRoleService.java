package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoleService {
    Page<Role> listRoles(Pageable pageable);

}
