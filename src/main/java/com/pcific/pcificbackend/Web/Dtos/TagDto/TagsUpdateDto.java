package com.pcific.pcificbackend.Web.Dtos.TagDto;

import com.pcific.pcificbackend.Entities.Tags;
import lombok.Setter;

@Setter
public class TagsUpdateDto {
    private String name;

    public Tags toTags(){
        return Tags.builder()
                .name(this.name)
                .build();
    }
}
