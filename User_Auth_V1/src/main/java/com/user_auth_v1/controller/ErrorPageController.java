package com.user_auth_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController {

    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView page = new ModelAndView("error");
        page.addObject("PageTile", "Error");
        return page;
    }

}// END OF ERROR PAGE CONTROLLER CLASS.
