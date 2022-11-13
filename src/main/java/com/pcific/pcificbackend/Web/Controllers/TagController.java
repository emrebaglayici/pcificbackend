package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.ITagService;
import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Web.Dtos.TagDto.TagCreateDto;
import com.pcific.pcificbackend.Web.Dtos.TagDto.TagsListDto;
import com.pcific.pcificbackend.Web.Dtos.TagDto.TagsUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    @Autowired
    private ITagService iTagService;

    @PostMapping("tag")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTag(@RequestBody TagCreateDto dto){
        iTagService.saveTag(dto);
    }

    @GetMapping("tags")
    public Page<TagsListDto> listTags(Pageable pageable){
        return iTagService.listTags(pageable)
                .map(tag->TagsListDto.builder()
                        .id(tag.getId())
                        .name(tag.getName())
                        .build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.iTagService.deleteById(id));
    }

    @PatchMapping("updateTag/{id}")
    public TagsListDto update(@PathVariable Long id,@RequestBody TagsUpdateDto dto){
        Tags tags=iTagService.getById(id).orElseThrow(()->new NotFoundException("Tag not found"));
        boolean needUpdate=false;
        if (StringUtils.hasLength(dto.toTags().getName())){
            tags.setName(dto.toTags().getName());
            needUpdate=true;
        }
        if (needUpdate)
            iTagService.update(id,tags);
        return TagsListDto.builder().
                id(id)
                .name(tags.getName())
                .build();
    }
}
