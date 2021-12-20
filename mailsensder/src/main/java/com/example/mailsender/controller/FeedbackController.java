package com.example.mailsender.controller;

import com.example.mailsender.config.EmailCfg;
import com.example.mailsender.emailRequest.EmailSendRequest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/email")
public class FeedbackController {

    private EmailCfg emailCfg;

    public FeedbackController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping
    public void sendFeedback(@RequestBody EmailSendRequest request) throws MessagingException, UnsupportedEncodingException, ParseException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = messageBuilder(message, request);

        mailSender.send(message);
    }

    private MimeMessageHelper messageBuilder (MimeMessage message, EmailSendRequest request) throws MessagingException, UnsupportedEncodingException, ParseException {
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String type = null;
        switch (request.getMessageType()) {
            case SENDEMAIL   : type = "Zapros Otpravlen: "; break;
            case ENDEMAIL  : type = "Zapros zakonchen: "; break;
            case CRATEEMAIL : type = "Zapros otplavlen na Obrabotku " + request.getConversionMultipleList() + ": "; break;
        }
        StringBuilder content = new StringBuilder();
        content.append("<p><b>Valiuta:</b></p>");
        for(String exchangeValue : request.getConversionMultipleList()){
            content.append("<font face=\"Times\"><p>" + exchangeValue +"</p></font>");
        }
        content.append("<p><b>" + type + dateFormatter(request.getDate().toString()) + "</b></p>");

        helper.setFrom("ulan.nurmagambet@gmail.com", "FROM BANK");
        helper.setTo(request.getEmailList().toArray(new String[0]));
        helper.setSubject(type);
        helper.setText(content.toString(), true);

        return helper;
    }

    private String dateFormatter(String oldDate) throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        DateFormat targetFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = originalFormat.parse(oldDate);
        return targetFormat.format(date);
    }
}
