package com.javahack.demo.controllers;

import com.javahack.demo.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController extends AbstractController {
    @GetMapping("/account")
    public String getAccount(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute(user);
        return "account";
    }
}
