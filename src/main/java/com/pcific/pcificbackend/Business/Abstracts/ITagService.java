package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Web.Dtos.TagDto.TagCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITagService {

    void saveTag(TagCreateDto tags);
    Optional<Tags> getById(Long id);
    Page<Tags> listTags(Pageable pageable);

    Tags deleteById(Long id);
    void update(Long id,Tags tags);
    boolean isExists(Long id);
}
