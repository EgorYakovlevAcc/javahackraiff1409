package com.javahack.demo.controllers;

import com.javahack.demo.externalsystems.qrcodes.QRCodesGenerator;
import com.javahack.demo.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController extends AbstractController{
    @GetMapping({"/index", "/"})
    public String getIndex(Model model, String error, String logout, @AuthenticationPrincipal User user) {
        LOGGER.info("GET INDEX [START]");
        model.addAttribute("title", "JAVA HACK IS CREATING HERE");
        LOGGER.info(model.toString());
        LOGGER.info("GET INDEX [FINISH]");
        return "index";
    }
    @GetMapping("/hello")
    public String getHello() {
        LOGGER.info("GET HELLO [START]");
        LOGGER.info("GET HELLO [FINISH]");return "hello";
    }

    @GetMapping(value = "/admin")
    public String getAdmin(Model model) {
        LOGGER.info("GET ADMIN [START]");
        model.addAttribute("users", userService.findAll());
        LOGGER.info(model.toString());
        LOGGER.info("GET ADMIN [FINISH]");
        return "admin";
    }
    @GetMapping(value = "/getqr")
    public String getQRCodeGeneration(Model model) {
        LOGGER.info("GET QR [START]");
        try {
            String qrCodePath = QRCodesGenerator.generateQRCodeImage("yandex.ru", 100,
                    100, "./egor");
            model.addAttribute("qrCodePath", qrCodePath);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("GET QR [FINISH]");
        return "getqr";
    }
}
