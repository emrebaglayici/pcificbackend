package com.pcific.pcificbackend.Web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleHierarchyController {

    @GetMapping("/roleHierarchy")
    public ModelAndView roleHierarcy() {
        ModelAndView model = new ModelAndView();
        model.addObject("adminMessage","Admin content available");
        model.addObject("staffMessage","Staff content available");
        model.addObject("userMessage","User content available");
        model.setViewName("roleHierarchy");
        return model;
    }

}
