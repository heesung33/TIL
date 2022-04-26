package com.example.email.service;


import com.example.email.dto.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class MailService {


    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String SendMail(String email, EmailRequest emailRequest) {
        System.out.println(email);
        String key = emailRequest.getContents();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);

        message.setSubject("메일왔셔열");
        message.setText(key);
        javaMailSender.send(message);
        return key;
    }


}