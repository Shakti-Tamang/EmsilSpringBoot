package com.nextstep.project.service;

import com.nextstep.project.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailServiceImpl implements EmailService {
//    The Logger instance in your EmailServiceImpl class is used to record important messages and errors that occur while your program is running. This helps you understand what happened and troubleshoot issues.
//        Here's a simpler explanation:
//
//Loggers are used to record significant events that occur while the application is running.
//    This could include:
//
//    Successful operations (e.g., "Email sent successfully").
//    Errors and exceptions (e.g., "Email authentication failed").
//    Key actions performed by users or the system.
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMessage(Email email) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email.getTo());
            simpleMailMessage.setText(email.getText());
            simpleMailMessage.setSubject(email.getSubject());
            javaMailSender.send(simpleMailMessage);
        } catch (MailAuthenticationException ex) {
            logger.error("Email authentication failed", ex);
            throw new RuntimeException("Email authentication failed. Please check your credentials.");
        } catch (MailSendException ex) {
            logger.error("Failed to send email", ex);
            throw new RuntimeException("Failed to send email. Please try again later.");
        }
    }
}
