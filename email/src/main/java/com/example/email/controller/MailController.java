package com.example.email.controller;

import com.example.email.dto.EmailRequest;
import com.example.email.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailRequest request) {
        return mailService.sendMail(request);
    }
}
