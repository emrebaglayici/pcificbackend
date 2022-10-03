package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.ISizeService;
import com.pcific.pcificbackend.Entities.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SizeController {
    @Autowired
    private ISizeService iSizeService;

    @PostMapping("sizes")
    public void createSize(@RequestBody Size size){
        iSizeService.createSize(size);
    }
}
