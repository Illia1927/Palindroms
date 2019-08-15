package com.palindrome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;


@Controller
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        logger.debug("user located in home page");
        return "home";
    }

}
