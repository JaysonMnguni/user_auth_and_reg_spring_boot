package com.user_auth_v1.controller;

import com.user_auth_v1.helpers.general.GeneralStringHelper;
import com.user_auth_v1.helpers.mailHelpers.MailMessengerHelper;
import com.user_auth_v1.helpers.mailHelpers.MessageHelper;
import com.user_auth_v1.services.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    private ModelAndView page;
    @GetMapping("/forgot-password")
    public ModelAndView getForgotPassword(){
        this.page = new ModelAndView("forgot-password");
        page.addObject(GeneralStringHelper.PAGE_TITLE, "Forgot Password");
        return page;
    }// END OF GET PAGE TITLE VIEW METHOD.

    @PostMapping("/forgot-password")
    public ModelAndView processForgotPassword(@RequestParam("email")String email) throws MessagingException {

        // GET USER EMAIL:
        String userEmail = userService.doesEmailExist(email);

        if(!userEmail.isEmpty()){
            // TODO: PROCESS PASSWORD RESET IF EMAIL EXISTS:
            String random_password      = GeneralStringHelper.generateRandomTokenString();
            String token                = GeneralStringHelper.generateRandomTokenString();
            Random randCode             = new Random();
            int code                    = randCode.nextInt(123) * 100;

            // HASH PASSWORD:
            String hashedPassword       = BCrypt.hashpw(random_password, BCrypt.gensalt());

            // UPDATE USER PASSWORD:
            int result                  = userService.forgotPassword(token, String.valueOf(code), hashedPassword, userEmail);


            if(result != 1){
                this.page = new ModelAndView("error");
                this.page.addObject(GeneralStringHelper.ERROR, "Something went wrong, contact administrator");
                return page;
            }// END OF CHECK FOR RESULT SET IF BLOCK.

            // TODO: SEND EMAIL NOTIFICATION:
            String changePasswordEmailBody = MessageHelper.forgotPasswordMailMessage(token, String.valueOf(code), random_password);
            MailMessengerHelper.htmlEmailMessenger("support@example.com", userEmail, "Change Password", changePasswordEmailBody);

        }// END OF PROCESS CHANGE PASSWORD IF BLOCK.

        this.page = new ModelAndView("success");
        this.page.addObject("msg", MessageHelper.forgotPasswordRedirectMsg() );
        return this.page;
    }
}// END OF FORGOT PASSWORD CONTROLLER CLASS.
