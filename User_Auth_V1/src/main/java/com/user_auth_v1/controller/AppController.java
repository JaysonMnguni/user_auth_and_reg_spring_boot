package com.user_auth_v1.controller;

import com.user_auth_v1.helpers.general.GeneralStringHelper;
import com.user_auth_v1.helpers.validations.ChangePasswordValidationHelper;
import com.user_auth_v1.models.User;
import com.user_auth_v1.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;
    private ModelAndView page;
    private HttpSession session;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(){
        this.page = new ModelAndView("dashboard");
        page.addObject(GeneralStringHelper.PAGE_TITLE, "Dashboard");
        return page;
    }// END OF GET DASHBOARD PAGE.

    @GetMapping("/update-password")
    public ModelAndView getUpdatePassword(){
        this.page = new ModelAndView("update-password");
        this.page.addObject(GeneralStringHelper.PAGE_TITLE, "Update Password");
        return this.page;
    }// END OF GET UPDATE PASSWORD VIEW METHOD.

    @PostMapping("/update-password")
    public ModelAndView updatePassword(@RequestParam("current") String current,
                                       @RequestParam("new_password") String newPassword,
                                       @RequestParam("confirm_password") String confirmPassword,
                                       HttpServletRequest request){

        // TODO: VALIDATE FORM DATA:
        ChangePasswordValidationHelper validate = new ChangePasswordValidationHelper(current, newPassword, confirmPassword);

        if(!validate.getErrors().isEmpty()){
            this.page = new ModelAndView("update-password");
            this.page.addObject(GeneralStringHelper.FORM_ERRORS, validate.getErrors());
            return this.page;
        }// END OF CHECK FOR FORM ERRORS.

        // TODO: GET SESSION OBJECT:
        this.session = request.getSession();
        User user = (User) this.session.getAttribute("user");

        // TODO: GET HASHED DB PASSWORD:
        String hashedDBPassword = userService.getDbPasswordByEmail(user.getEmail());

        // TODO: CHECK IF PASSWORDS MATCH:
        if(!BCrypt.checkpw(validate.getCurrent(), hashedDBPassword)){
            this.page = new ModelAndView("update-password");
            this.page.addObject(GeneralStringHelper.ERROR, "Current password incorrect");
            return this.page;
        }// END OF CHECK IF PASSWORDS MATCH (IF) BLOCK.

        // TODO: PROCEED TO UPDATE PASSWORD:
        String hashNewPassword = BCrypt.hashpw(validate.getNewPassword(), BCrypt.gensalt());
        int result = userService.updatePasswordByEmail(hashNewPassword, user.getEmail());

        if(result != 1){
            this.page = new ModelAndView("error");
            this.page.addObject("msg", "Something went wrong, contact Administrator");
            return this.page;
        }// END OF CHECK FOR RESULT SET IF BLOCK.

        this.page = new ModelAndView("update-password");
        this.page.addObject(GeneralStringHelper.SUCCESS, "Password updated Successfully");
        return this.page;

    }// END OF UPDATE PASSWORD POST METHOD.

}// END OF APP CONTROLLER CLASS.
