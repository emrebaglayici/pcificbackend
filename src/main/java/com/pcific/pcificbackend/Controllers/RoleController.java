package com.pcific.pcificbackend.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.IRoleService;
import com.pcific.pcificbackend.Business.Abstracts.IUserService;
import com.pcific.pcificbackend.Controllers.Dtos.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class RoleController {
    private final IRoleService iRoleService;

    @GetMapping("/roles")
    public Page<RoleDto> listRoles(Pageable pageable){
        return iRoleService.listRoles(pageable)
                .map(role->RoleDto.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .build());
    }
}
