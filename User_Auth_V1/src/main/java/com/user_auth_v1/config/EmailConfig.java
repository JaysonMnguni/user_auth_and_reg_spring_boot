package com.user_auth_v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class EmailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        // Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        // Set Mail Credentials:
        emailConfig.setHost("sandbox.smtp.mailtrap.io");
        emailConfig.setPort(2525);
        emailConfig.setUsername("12ac13b33ae6b0");
        emailConfig.setPassword("fad9e0a61993d7");

        return emailConfig;
    }
    // End Of Email Config Method.

}// END OF EMAIL CONFIG CLASS.
