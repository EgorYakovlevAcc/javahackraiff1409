package com.javahack.demo.controllers;

import com.javahack.demo.models.Role;
import com.javahack.demo.models.User;
import com.javahack.demo.services.user.CustomSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController extends AbstractController {
    @Autowired
    private CustomSecurityService securityService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("user") User user, Model model, HttpServletRequest request) throws Exception {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        String username = user.getUsername();
        user.setRole(Role.USER.toString());
        userService.save(user);
        securityService.autologin(request, username, password);
        return "redirect:/index";
    }


    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("loginError", "Your username and password is invalid.");
        }
        if (logout != null)
            model.addAttribute("loginError", "You have been logged out successfully.");
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model,
                        @ModelAttribute("user") User user) {
        System.out.println("UYUYUYUYUYUYUYUYUY");
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null);

        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);

        return "redirect:/user_page";
    }
}
