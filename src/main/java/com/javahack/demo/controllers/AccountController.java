package com.javahack.demo.controllers;

import com.javahack.demo.models.BuisnessArea;
import com.javahack.demo.models.User;
import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;
import com.javahack.demo.services.billservice.BillService;
import com.javahack.demo.services.credit.request.CreditRequestService;
import com.javahack.demo.services.credit.response.CreditResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;

@Controller
public class AccountController extends AbstractController {
    @Autowired
    private BillService billService;
    @Autowired
    private CreditRequestService creditRequestService;
    @Autowired
    private CreditResponseService creditResponseService;
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

    @GetMapping("/credit/request")
    public String getCredit(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("creditRequest", new CreditRequest());
        model.addAttribute("area", user.getBuisnessArea() != null ? user.getBuisnessArea() : BuisnessArea.FOOD);
        return "credit";
    }
    @PostMapping("/credit/request")
    public RedirectView postCredit(Model model, @AuthenticationPrincipal User user, RedirectAttributes attributes,@ModelAttribute("creditRequest") CreditRequest creditRequest) {
       creditRequest.setUser_req(user);
        CreditResponse creditResponse = new CreditResponse();
       creditRequest.setCreditResponse(creditResponse);
       creditResponse.setCreditRequest(creditRequest);
       creditResponse.setUser_resp(user);
        creditRequestService.save(creditRequest);
        creditResponseService.save(creditResponse);
       attributes.addAttribute("id", creditResponse.getId());
        return new RedirectView("/credit/response/wait/{id}");
    }
}
