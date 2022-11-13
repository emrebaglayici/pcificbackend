package com.pcific.pcificbackend.Web.Dtos.SizesDto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class SizeListDto {
    private Long id;
    private String name;
}
