package com.javahack.demo.controllers;

import com.javahack.demo.models.User;
import com.javahack.demo.services.billservice.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AccountController extends AbstractController {
    @Autowired
    private BillService billService;
    @GetMapping("/account")
    public RedirectView getAccount(Model model, @AuthenticationPrincipal User user, RedirectAttributes attributes) {
        attributes.addAttribute("id", userService.findByLogin(user.getLogin()).getId());
        return new RedirectView("/account/{id}");
    }
    @GetMapping("/account/{id}")
    public String getAccountWithId(Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id) {
        model.addAttribute("user", user);
        model.addAttribute("bills", billService.findBillsByHolder(user));
        return "account";
    }
}
