package com.user_auth_v1.helpers.mailHelpers;

import com.user_auth_v1.config.EmailConfig;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMessengerHelper {


    public static void htmlEmailMessenger(String from, String toMail, String subject, String body) throws MessagingException, MessagingException {
        // Get Mail Config:
        JavaMailSender sender = EmailConfig.getMailConfig();
        // Set Mime Message:
        MimeMessage message = sender.createMimeMessage();
        // Set Mime Message Helper:
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);

        // Set Mail Attributes / Properties:
        htmlMessage.setTo(toMail);
        htmlMessage.setFrom(from);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body, true);
        // Send Message:
        sender.send(message);
    }
    // End Of HTML EMAIL MESSAGE METHOD.


}
