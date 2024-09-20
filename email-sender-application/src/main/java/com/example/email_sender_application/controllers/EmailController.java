package com.example.email_sender_application.controllers;


import com.example.email_sender_application.dtos.request.SendEmailRequest;
import com.example.email_sender_application.dtos.response.ApiResponse;
import com.example.email_sender_application.dtos.response.SendEmailResponse;
import com.example.email_sender_application.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService sendEmailService;


//    @GetMapping("sendEmail")
//    public String sendEmail() {
//        sendEmailService.sendEmail("fareedtijani2810@gmail.com", "Freddie", "freddie is a good boi");
//        return "Email sent successfully";
//    }

    @PostMapping("sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody SendEmailRequest sendEmailRequest) {
        try{
            SendEmailResponse sendEmailResponse = sendEmailService.sendEmail(sendEmailRequest);
            return new ResponseEntity<>(new ApiResponse(true,sendEmailResponse), CREATED);
        }
        catch(RuntimeException e){
            SendEmailResponse sendEmailResponse = new SendEmailResponse();
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), BAD_REQUEST);

        }
    }


}
