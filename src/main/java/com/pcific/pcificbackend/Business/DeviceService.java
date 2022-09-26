package com.pcific.pcificbackend.Business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ua_parser.Parser;
@Component
public class DeviceService {


    @Value("${support.email}")
    private String from;



    private Parser parser;
    private JavaMailSender mailSender;
    private MessageSource messages;

    public DeviceService(
            Parser parser,
            JavaMailSender mailSender,
            MessageSource messages) {
        this.parser = parser;
        this.mailSender = mailSender;
        this.messages = messages;
    }
}
