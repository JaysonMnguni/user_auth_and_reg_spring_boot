package com.user_auth_v1.controller;


import com.user_auth_v1.helpers.general.GeneralStringHelper;
import com.user_auth_v1.helpers.mailHelpers.MessageHelper;
import com.user_auth_v1.helpers.validations.SignInValidationHelper;
import com.user_auth_v1.models.User;
import com.user_auth_v1.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private ModelAndView page;



    @GetMapping("/sign-in")
    public ModelAndView getSignIn(){
        this.page = new ModelAndView("sign-in");
        this.page.addObject("PageTitle", "Sign In");
        return this.page;
    }// END OF GET SIGN IN PAGE GET METHOD.


    @PostMapping("/sign-in")
    public String authenticateUser(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model, HttpSession session){

        // TODO: VALIDATE FORM DATE / INPUT FIELDS:
        SignInValidationHelper validate = new SignInValidationHelper(email, password);
        if(!validate.getErrors().isEmpty()){
            model.addAttribute(GeneralStringHelper.FORM_ERRORS, validate.getErrors());
            model.addAttribute(GeneralStringHelper.FORM_DATA, validate);
            return "sign-in";
        }// END OF VALIDATE FORM DATA / INPUT FIELDS IF BLOCK.

        // TODO: CHECK IF THE EMAIL EXISTS:
        String doesEmailExist = userService.doesEmailExist(validate.getEmail());

        if(doesEmailExist == null || doesEmailExist.isEmpty()){
            model.addAttribute("msg", "There is no account linked to this email");
            return "error";
        }// END OF CHECK IF EMAIL EXISTS IF BLOCK.

        // TODO: CHECK IF ACCOUNT IS VERIFIED:
        int verified = userService.isAccountVerified(validate.getEmail());

        if(verified == 0){
            model.addAttribute("msg", "Your Account is not yet verified, please check your email and verify account");
            return "error";
        }// END OF CHECK IF ACCOUNT IS VERIFIED.

        // TODO: PROCEED TO AUTHENTICATE USER:
        String dbPassword = userService.getDbPasswordByEmail(validate.getEmail());

        if(!BCrypt.checkpw(validate.getPassword(), dbPassword)){
            model.addAttribute(GeneralStringHelper.ERROR, "Incorrect Username or Password");
            return "sign-in";
        }// VALIDATE / AUTHENTICATE USER IF BLOCK.


        // TODO: INIT USER OBJECT AND SET SESSION:
        User user = userService.getUserDetailsByEmail(validate.getEmail());

        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/app/dashboard";
        }

        return "redirect:/error";
    }// END OF AUTHENTICATE USER METHOD.


    @PostMapping("/sign-out")
    public String signOut(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        System.out.println("Sign-out: Session " + session.getId() +" has been invalidated");
        redirectAttributes.addFlashAttribute(GeneralStringHelper.SUCCESS, "You have successfully signed out");
        return "redirect:/sign-in";
    }// END OF SIGN OUT POST METHOD.


    @GetMapping("/verify-account")
    public ModelAndView verifyAccount(@RequestParam("token") String token, @RequestParam("code") String code){

        // TODO: VERIFY TOKEN AND CODE:
        List<String> tokenAndCode = userService.checkTokenAndCode(token, Integer.parseInt(code));

        if(tokenAndCode == null){
            this.page = new ModelAndView("error");
            this.page.addObject("msg", "Something went wrong, contact Administrator");
            return this.page;

        }// END OF CHECK TOKEN AND CODE IF BLOCK.

        // TODO: VERIFY ACCOUNT:
        int result = userService.verifyAccount(token, Integer.parseInt(code));

        if(result != 1){
            this.page = new ModelAndView("error");
            this.page.addObject("msg", "Something went wrong, contact Administrator");
            return this.page;
        }// END OF CHECK FOR RESULT SET IF BLOCK.

        // TODO: REDIRECT TO SUCCESS PAGE:
        this.page = new ModelAndView("success");
        this.page.addObject("msg", "Verification Successful");
        return  this.page;

    }// END OF VERIFY ACCOUNT GET METHOD.

}// END OF AUTH CONTROLLER CLASS.
