package com.example.email.service;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {


    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String SendMail(String email) {
        System.out.println(email);
        Random rnd = new Random();
        StringBuilder key = new StringBuilder();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        for (int i = 0; i < 3; i++) {
            int index = rnd.nextInt(25) + 65;
            key.append((char) index);
        }
        int numIndex = rnd.nextInt(9999) + 1000;
        key.append(numIndex);
        message.setSubject("인증번호 입력을 위한 메일 전송");
        message.setText("인증 번호 :" + key);
        javaMailSender.send(message);
        return key.toString();
    }
}