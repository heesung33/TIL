package com.example.email.controller;

import com.example.email.service.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/{email}")
    public String SendMail(@PathVariable String email){
        return mailService.SendMail(email);
    }
}
