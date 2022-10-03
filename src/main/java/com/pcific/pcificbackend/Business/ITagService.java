package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Tags;

import java.util.Optional;

public interface ITagService {

    Tags saveTag(Tags tags);
    Optional<Tags> getById(Long id);
}
