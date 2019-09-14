package com.javahack.demo.controllers;

import com.javahack.demo.models.Bill;
import com.javahack.demo.models.User;
import com.javahack.demo.models.bankoperation.pojo.FromClassToPojoConvertHelper;
import com.javahack.demo.services.billservice.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataController extends AbstractController {
    @Autowired
    private BillService billService;
    @GetMapping("getdata/json/{id}")
    public String getJsonData(Model model, @AuthenticationPrincipal User user,
                              @PathVariable("id") int id, RedirectAttributes attributes) {
        model.addAttribute("id", id);
        Map<String, Long> map = new HashMap<>();
        Bill bill = billService.findBillById(id);
        bill.getToTransactions().stream()
                .map(FromClassToPojoConvertHelper::convert)
                .forEach(transaction -> {
                    List<String> tran = new ArrayList<>();
                    map.put(transaction.getDate().toString(), transaction.getValue().longValue());
                });
        model.addAttribute("map2", map);
        return "plot";
    }
}
