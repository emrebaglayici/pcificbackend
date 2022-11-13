package com.pcific.pcificbackend.Web.Dtos.SizesDto;

import com.pcific.pcificbackend.Entities.Size;
import lombok.Setter;

@Setter
public class SizeUpdateDto {
    private String name;

    public Size toSize() {
        return Size.builder()
                .name(this.name)
                .build();
    }
}
