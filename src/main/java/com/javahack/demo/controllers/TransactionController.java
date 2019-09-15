package com.javahack.demo.controllers;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.User;
import com.javahack.demo.models.bankoperation.Operation;
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

    @GetMapping("/emit/transaction/{fromBill}/{toBill}/{value}/{operation}")
    @ResponseBody
    public String transferMoney(@AuthenticationPrincipal User user, @PathVariable("fromBill") int fromBillId,
                                @PathVariable("toBill") int toBillId, @PathVariable("value") Long value, @PathVariable("operation") String operation) {
        try {
            Transaction transaction = new Transaction();
            transaction.setOperation(Operation.getOperationByName(operation));
            Bill fromBill = billService.findBillById(fromBillId);
            Bill toBill = billService.findBillById(toBillId);
            fromBill.setMoneyValue(fromBill.getMoneyValue() - value);
            toBill.setMoneyValue(toBill.getMoneyValue() + value);
            transaction.setFromBill(fromBill);
            transaction.setToBill(toBill);
            billService.save(fromBill);
            billService.save(toBill);
            transaction.setValue(value);
            transactionService.save(transaction);
            return "Transaction is success";
        } catch (Exception e) {
            return "Transaction is failed";
        }
    }
}
