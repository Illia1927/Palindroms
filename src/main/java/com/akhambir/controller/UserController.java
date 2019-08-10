package com.akhambir.controller;

import com.akhambir.controller.external.model.UserRegistrationPayload;
import com.akhambir.model.User;
import com.akhambir.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute User user, ModelAndView mw) {
        logger.debug("add the user");
        userService.add(user);
        List<User> users = userService.getAll()
                .orElseGet(Collections::emptyList);

        mw.addObject("users", users);
        mw.setViewName("users");
        return mw;
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
        logger.debug("get all user");
        List<User> users = userService.getAll()
                .orElseGet(Collections::emptyList);

        mw.addObject("users", users);
        mw.setViewName("users");
        return mw;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mw) {
        logger.debug("located in registration page");
        mw.addObject("userRegistrationPayload", new UserRegistrationPayload());
        mw.setViewName("register");
        return mw;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute UserRegistrationPayload urp, BindingResult br, ModelAndView mw) {
        if (br.hasErrors()) {
            mw.addAllObjects(br.getModel());
            mw.setViewName("register");
            return mw;
        }
        userService.add(User.of(urp));
        logger.debug("located in registration page");
        mw.addObject("user", new User());
        mw.setViewName("login");
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mw) {
        logger.debug("located in login page");
        mw.addObject("user", new User());
        mw.setViewName("login");
        return mw;
    }
}
