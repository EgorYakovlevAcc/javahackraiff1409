package com.javahack.demo.controllers;

import com.javahack.demo.models.User;
import com.javahack.demo.models.bankoperation.Transaction;
import com.javahack.demo.services.billservice.BillService;
import com.javahack.demo.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TransactionController extends AbstractController {
    @Autowired
    private BillService billService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/emit/transaction/{fromBill}/{toBill}/{value}")
    @ResponseBody
    public String transferMoney(@AuthenticationPrincipal User user, @PathVariable("fromBill") int fromBill,
                                @PathVariable("toBill") int toBill, @PathVariable("value") Long value) {
        try {
            Transaction transaction = new Transaction();
            transaction.setFromBill(billService.findBillById(fromBill));
            transaction.setToBill(billService.findBillById(toBill));
            transaction.setValue(value);

            return "Transaction is success";
        }
        catch (Exception e) {
            return "Transaction is failed";
        }
    }
}
