package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.ITagService;
import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Repositories.TagsRepository;
import com.pcific.pcificbackend.Web.Dtos.TagDto.TagCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class TagManager implements ITagService {
    @Autowired
    private TagsRepository tagsRepository;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTag(TagCreateDto tags) {
        tagsRepository.save(tags.toTags());
    }

    @Override
    public Optional<Tags> getById(Long id) {
        return tagsRepository.findById(id);
    }

    @Override
    public Page<Tags> listTags(Pageable pageable) {
        return this.tagsRepository.findAll(pageable);
    }

    @Override
    public Tags deleteById(Long id) {
        Optional<Tags> optionalTags=tagsRepository.findById(id);
        Tags tags=optionalTags.orElseThrow(()->new NotFoundException("Tag Not Found"));
        this.tagsRepository.deleteById(tags.getId());
        return tags;
    }

    @Override
    public void update(Long id, Tags tags) {
        this.tagsRepository.save(tags);
    }

    @Override
    public boolean isExists(Long id) {
        return tagsRepository.existsById(id);
    }
}
