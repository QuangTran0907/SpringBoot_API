package com.SpringBootMaven.Quang.controllers;

import com.SpringBootMaven.Quang.models.Response.JsonEmail;
import com.SpringBootMaven.Quang.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class MailController {

    @Autowired
    private EmailService emailService;



    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody JsonEmail jsonEmail) {
        emailService.sendEmail(jsonEmail);
        return "Email sent successfully";
    }
}
