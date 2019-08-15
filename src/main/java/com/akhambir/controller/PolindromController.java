package com.akhambir.controller;

import com.akhambir.model.Palindromes;
import com.akhambir.service.PalindromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PolindromController {

    @Autowired
    private PalindromService palindromService;

    @RequestMapping(value = "/palindromes", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mw) {
        mw.addObject("palindromes", new Palindromes());
        mw.setViewName("palindrom");
        return mw;
    }

    @RequestMapping(value = "/palindromes", method = RequestMethod.POST)
    public ModelAndView saveNumber(@ModelAttribute Palindromes palindromes, ModelAndView mw) {
        palindromService.add(palindromes);
        mw.addObject("user", new Palindromes());
        mw.setViewName("home");
        return mw;
    }
}
