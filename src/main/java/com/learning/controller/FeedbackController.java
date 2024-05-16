package com.learning.controller;

import com.learning.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;


    @PostMapping("/feedback")
    public String createOrder(
            @RequestParam("productId") Integer id,
            @RequestParam("detail") String detail,
            @RequestParam("rate") int rate,
            Principal principal) {
        try {
            feedbackService.createFeedback(id, detail, rate, principal);
            return ""; // tạo một html báo feedback thành công,
        } catch (Exception e) {
            return "error/404";
        }
    }
}
