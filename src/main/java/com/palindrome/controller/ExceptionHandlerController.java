package com.palindrome.controller;


import com.palindrome.controller.exceptions.UserAlreadyRegisteredException;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
    private static final Logger logger = Logger.getLogger(ExceptionHandlerController.class);
    @ExceptionHandler(Throwable.class)
    public ModelAndView handleAll() {
        ModelAndView m = new ModelAndView();
        logger.error("see the log");
        m.setViewName("error");
        return m;
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<String> alreadyRegistered() {
        logger.error("User already registered");
        return ResponseEntity.status(409).body("User already registered");
    }
}
