package com.user_auth_v1.controller;

import com.user_auth_v1.helpers.general.GeneralStringHelper;
import com.user_auth_v1.helpers.validations.ChangePasswordValidationHelper;
import com.user_auth_v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChangePasswordController {

    @Autowired
    private UserService userService;
    private ModelAndView page;


    @GetMapping("/change-password")
    public ModelAndView getChangePassword(@RequestParam("token")String token,
                                          @RequestParam("code") String code){
        // TODO: VERIFY TOKEN AND CODE:
        List<String> tokenAndCode = userService.checkTokenAndCode(token, Integer.parseInt(code));

        if(tokenAndCode == null){
            this.page = new ModelAndView("error");
            this.page.addObject("msg", "Something went wrong, contact Administrator");
            return this.page;

        }// END OF CHECK TOKEN AND CODE IF BLOCK.

        this.page = new ModelAndView("change-password");
        this.page.addObject(GeneralStringHelper.PAGE_TITLE, "change-password");
        return this.page;
    }// END  OF GET CHANGE PASSWORD VIEW METHOD.


    @PostMapping("/change-password")
    public ModelAndView changePassword(@RequestParam("token") String token,
                                       @RequestParam("code") String code,
                                       @RequestParam("current") String current,
                                       @RequestParam("new_password") String newPassword,
                                       @RequestParam("confirm_password") String confirmPassword){


        // TODO: VALIDATE FORM DATE:
        ChangePasswordValidationHelper validate = new ChangePasswordValidationHelper(current, newPassword, confirmPassword);

        if(!validate.getErrors().isEmpty()){
            this.page = new ModelAndView("change-password");
            this.page.addObject(GeneralStringHelper.FORM_ERRORS, validate.getErrors());
            this.page.addObject("current_pass", current);
            return this.page;
        }

        // TODO: GET HASHED PASSWORD IN DATABASE:
        String hashedDbPassword = userService.getHashedPasswordByTokenAndCode(token, code);

        // TODO: CHECK IF PASSWORDS MATCH:
        if(!BCrypt.checkpw(validate.getCurrent(), hashedDbPassword)){
            this.page = new ModelAndView("change-password");
            this.page.addObject(GeneralStringHelper.ERROR, "Current password incorrect");
            return this.page;
        }// END OF CHECK IF PASSWORDS MATCH (IF) BLOCK.

        // TODO: PROCEED TO CHANGE USERS PASSWORD:
        String hashNewPassword = BCrypt.hashpw(validate.getNewPassword(), BCrypt.gensalt());

        int result = userService.changePassword(token, code, hashNewPassword);

        if(result != 1){
            this.page = new ModelAndView("error");
            this.page.addObject("msg", "Something went wrong, contact Administrator");
            return this.page;
        }// END OF CHECK FOR RESULT SET IF BLOCK.


        this.page = new ModelAndView("success");
        this.page.addObject(GeneralStringHelper.MSG, "Password changed successfully!");
        return this.page;

    }// END OF CHANGE PASSWORD POST METHOD.

}// END OF CHANGE PASSWORD CONTROLLER CLASS.
