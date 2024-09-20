package com.example.email_sender_application.service;


import com.example.email_sender_application.dtos.request.SendEmailRequest;
import com.example.email_sender_application.dtos.response.SendEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender mailSender;


    @Value("$(spring.mail.username)")
    private String fromEmailId;


    public SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmailId);
        message.setTo(sendEmailRequest.getRecipient());
        message.setText(sendEmailRequest.getBody());
        message.setSubject(sendEmailRequest.getSubject());
        mailSender.send(message);
        SendEmailResponse response = new SendEmailResponse();
        response.setMessage("Email sent successfully");
        return response;

    }
}
