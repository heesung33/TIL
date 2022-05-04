package com.example.email.service;



import com.example.email.dto.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public String sendMail(EmailRequest request) {
        return simpleSend(request.getEmail(), request.getText(), request.getTitle());
    }

    private String simpleSend(String email, String text, String title) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(title);
        message.setText(text);
        javaMailSender.send(message);
        System.out.println(email);
        return text;
    }
}