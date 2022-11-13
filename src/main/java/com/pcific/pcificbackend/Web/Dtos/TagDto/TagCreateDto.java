package com.pcific.pcificbackend.Web.Dtos.TagDto;

import com.pcific.pcificbackend.Entities.Tags;
import lombok.Setter;

@Setter
public class TagCreateDto {
    private Long id;
    private String name;

    public Tags toTags(){
        return Tags.builder()
                .id(this.id)
                .name((this.name))
                .build();

    }
}
