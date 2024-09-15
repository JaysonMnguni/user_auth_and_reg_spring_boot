package com.user_auth_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        return getIndexPage;
    }// END OF GET INDEX PAGE.

}// END OF INDEX CONTROLLER CLASS.
