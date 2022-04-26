package com.example.email.controller;

import com.example.email.dto.EmailRequest;
import com.example.email.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/{email}/{emailRequest}")
    public String SendMail(@PathVariable String email, EmailRequest emailRequest) {
        return mailService.SendMail(email, emailRequest);
    }
}
