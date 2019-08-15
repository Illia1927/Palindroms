package com.palindrome.controller;

import com.palindrome.model.Palindromes;
import com.palindrome.model.User;
import com.palindrome.service.PalindromService;
import com.palindrome.service.SecurityService;
import com.palindrome.utill.NumberUtill;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PalindromesController {
    private static final Logger logger = Logger.getLogger(PalindromesController.class);

    @Autowired
    private PalindromService palindromService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/palindromes", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mw) {
        mw.addObject("palindromes", new Palindromes());
        mw.setViewName("palindromes");
        return mw;
    }

    @RequestMapping(value = "/palindromes", method = RequestMethod.POST)
    public ModelAndView saveNumber(@ModelAttribute Palindromes number, ModelAndView mw) {
        Optional<User> currentUser = securityService.getCurrentUser();
        number.setUser(currentUser.get());
        palindromService.add(number);
        if (NumberUtill.checkForPalindrome(number.getNumbers())) {
            mw.setViewName("palindromesTrue");
        } else {
            mw.setViewName("palindromesFalse");
        }
        mw.addObject("palindromes", number);
        return mw;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
        logger.debug("get all numbers");
        List<Palindromes> numbers = palindromService.getAll()
                .orElseGet(Collections::emptyList);
        mw.addObject("numbers", numbers);
        mw.setViewName("history");
        return mw;
    }
}
