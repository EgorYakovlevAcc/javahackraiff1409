package com.javahack.demo.controllers;

import com.javahack.demo.repos.UserRepository;
import com.javahack.demo.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

public abstract class AbstractController {
    @Autowired
    protected AuthenticationManager authenticationManager;
    @Autowired
    protected UserService userService;
    protected static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

}
