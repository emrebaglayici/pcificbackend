package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.ISizeService;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Web.Dtos.SizesDto.SizeCreateDto;
import com.pcific.pcificbackend.Web.Dtos.SizesDto.SizeListDto;
import com.pcific.pcificbackend.Web.Dtos.SizesDto.SizeUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class SizeController {
    @Autowired
    private ISizeService iSizeService;

    @PostMapping("size")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSize(@RequestBody SizeCreateDto dto){
        iSizeService.createSize(dto);
    }

    @GetMapping("sizes")
    public Page<SizeListDto> listSizes(Pageable pageable){
        return iSizeService.listSizes(pageable)
                .map(size-> SizeListDto.builder()
                        .id(size.getId())
                        .name(size.getName())
                        .build());
    }

    @DeleteMapping("deleteSize/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.iSizeService.deleteById(id));
    }

    @PatchMapping("updateSize/{id}")
    public SizeListDto update(@PathVariable Long id, @RequestBody SizeUpdateDto dto){
        Size size=iSizeService.getById(id).orElseThrow(()->new NotFoundException("Size Not Found"));
        boolean needUpdate=false;
        if (StringUtils.hasLength(dto.toSize().getName())){
            size.setName(dto.toSize().getName());
            needUpdate=true;
        }
        if (needUpdate)
            iSizeService.update(id,size);
        return SizeListDto.builder()
                .id(id)
                .name(size.getName())
                .build();
    }
}
