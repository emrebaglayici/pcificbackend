package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.ITagService;
import com.pcific.pcificbackend.Entities.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
    @Autowired
    private ITagService iTagService;

    @PostMapping("tags")
    public void createTag(@RequestBody Tags tags){
        iTagService.saveTag(tags);
    }
}
