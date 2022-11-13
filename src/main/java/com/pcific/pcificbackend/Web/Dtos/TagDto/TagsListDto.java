package com.pcific.pcificbackend.Web.Dtos.TagDto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class TagsListDto {
    private Long id;
    private String name;
}
