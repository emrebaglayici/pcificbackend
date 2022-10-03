package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagManager implements ITagService{
    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public Tags saveTag(Tags tags) {
        return tagsRepository.save(tags);
    }

    @Override
    public Optional<Tags> getById(Long id) {
        return tagsRepository.findById(id);
    }
}
