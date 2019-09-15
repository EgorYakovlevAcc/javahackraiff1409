package com.javahack.demo.controllers;

import com.javahack.demo.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SolutionController extends AbstractController {
    @GetMapping("/credit/response/wait/{id}")
    @ResponseBody
    public String getSolutionForCreditRequest(Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id) {
        return "You recieve results";
    }
}
