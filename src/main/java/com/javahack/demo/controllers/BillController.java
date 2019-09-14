package com.javahack.demo.controllers;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.User;
import com.javahack.demo.models.bankoperation.pojo.FromClassToPojoConvertHelper;
import com.javahack.demo.models.bankoperation.pojo.Transaction;
import com.javahack.demo.services.billservice.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BillController extends AbstractController {
    @Autowired
    private BillService billService;

    @GetMapping("/create_bill")
    public RedirectView getCreateBill(Model model, @AuthenticationPrincipal User user, RedirectAttributes attributes) {
        Bill bill = new Bill();
        bill.setHolder(user);
        bill.setCreateDate(new Date());
        bill.setMoneyValue(0L);
        model.addAttribute("bill", bill);
        billService.save(bill);
        attributes.addAttribute("id", user.getId());
        return new RedirectView("/account/{id}");
    }

    @GetMapping("/add_money/{id}/{value}")
    public RedirectView addMoneyByValue(Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id,
                                        @PathVariable("value") int value, RedirectAttributes attributes) {
        Bill bill = billService.findBillById(id);
        bill.setMoneyValue(bill.getMoneyValue() + value);
        billService.save(bill);
        attributes.addAttribute("id", user.getId());
        return new RedirectView("/account/{id}");
    }

    @GetMapping("/remove_money/{id}/{value}")
    public RedirectView removeMoneyByValue(Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id,
                                           @PathVariable("value") int value, RedirectAttributes attributes) {
        Bill bill = billService.findBillById(id);
        bill.setMoneyValue(bill.getMoneyValue() - value);
        billService.save(bill);
        attributes.addAttribute("id", user.getId());
        return new RedirectView("/account/{id}");
    }
}
