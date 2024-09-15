package com.user_auth_v1.controller;

import com.user_auth_v1.helpers.general.GeneralStringHelper;
import com.user_auth_v1.helpers.mailHelpers.MailMessengerHelper;
import com.user_auth_v1.helpers.mailHelpers.MessageHelper;
import com.user_auth_v1.helpers.validations.SignUpValidationHelper;
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
public class SignUpController {

    @Autowired
    private UserService userService;

    private ModelAndView page;


    @GetMapping("/sign-up")
    public ModelAndView getSignUpPage(){
        this.page = new ModelAndView("sign-up");
        this.page.addObject("PageTitle", "Welcome to sign up page");

        return page;
    }// END OF GET SIGN UP PAGE GET METHOD.

    @PostMapping("/sign-up")
    public ModelAndView signUp(@RequestParam("first_name") String first_name,
                               @RequestParam("last_name") String last_name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("confirm") String confirm) throws MessagingException {

        //TODO: VALIDATE FORM DATA:
        SignUpValidationHelper validate = new SignUpValidationHelper(first_name, last_name, email, password, confirm);

        if(!validate.getErrors().isEmpty()){
                this.page = new ModelAndView("sign-up");
                this.page.addObject(GeneralStringHelper.FORM_ERRORS, validate.getErrors());
                this.page.addObject(GeneralStringHelper.FORM_DATA, validate);
                return this.page;

        }// END OF VALIDATE FORM DATA IF BLOCK.


        // TODO: PROCESS FORM REGISTRATION:
        String token = GeneralStringHelper.generateRandomTokenString();
        Random random = new Random();
        int code = random.nextInt(123) * 100;

        // HASH PASSWORD:
        String hashedPassword = BCrypt.hashpw(validate.getPassword(), BCrypt.gensalt());

        // INSERT DATA / REGISTER USER:
        int result =
                userService.registerUser(validate.getFirstName(), validate.getLastName(), validate.getEmail(), hashedPassword, token, code);

        if(result != 1){
            this.page = new ModelAndView("sign-up");
            this.page.addObject(GeneralStringHelper.ERROR, "Error Registering user");
            return this.page;
        }

        // TODO: SEND EMAIL NOTIFICATION:
        String emailBody = MessageHelper.verifyAccountEmailBody(token, String.valueOf(code));
        MailMessengerHelper.htmlEmailMessenger("no-reply-verify@example.com", validate.getEmail(), "verify-Account", emailBody);

        // TODO: RE-ROUTE TO SUCCESS PAGE.
        this.page = new ModelAndView("sign-up");
        this.page.addObject(GeneralStringHelper.SUCCESS, "Registration Successful, please check email to verify your account");
        return this.page;
    }// END OF SIGN UP POST METHOD.


}// END OF SIGN UP CONTROLLER CLASS.
