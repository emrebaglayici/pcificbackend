package com.pcific.pcificbackend.Web.Dtos.SizesDto;

import com.pcific.pcificbackend.Entities.Size;
import lombok.Setter;

@Setter
public class SizeCreateDto {
    private Long id;
    private String name;

    public Size toSize(){
        return Size.builder()
                .id(this.id)
                .name((this.name))
                .build();

    }
}
