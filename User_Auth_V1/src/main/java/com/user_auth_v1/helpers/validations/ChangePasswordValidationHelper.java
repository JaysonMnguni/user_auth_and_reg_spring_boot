package com.user_auth_v1.helpers.validations;

import java.util.HashMap;

public class ChangePasswordValidationHelper {

    private String current;
    private String newPassword;
    private String confirmPassword;

    private HashMap<String, String> errors;

    public ChangePasswordValidationHelper(String current, String newPassword, String confirmPassword) {
        this.current = current;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;

        this.errors = new HashMap<>();

        checkForEmptyFields();
        checkIfPasswordsMatch();
        checkPasswordLength();

    }// END OF ALL ARGS CONSTRUCTOR.


      /*
    |
    |-----------------------------------------
    | VALIDATION METHODS:
    |-----------------------------------
    */

    public void checkForEmptyFields(){
        if(this.getCurrent().isEmpty() || this.getCurrent() == null){
            errors.put("current", "Email field cannot be empty");
        }

        if(this.getNewPassword().isEmpty() || this.getNewPassword() == null){
            errors.put("new_password", "Password field cannot be empty");
        }

        if(this.getConfirmPassword().isEmpty() || this.getConfirmPassword() == null){
            errors.put("confirm_password", "Password field cannot be empty");
        }
    }// END OF CHECK FOR EMPTY FIELDS METHOD.


    public void checkIfPasswordsMatch(){
        if(!this.getNewPassword().equals(this.getConfirmPassword())){
            errors.put("new_password", "Passwords do not match");
            errors.put("confirm_password", null);
        }

    }// END OF CHECK IF PASSWORDS MATCH.

    public void checkPasswordLength(){
        if(this.getNewPassword().length() < 8){
            errors.put("new_password", "Password must be greater then 8 characters");
        }

        if(this.getConfirmPassword().length() < 8){
            errors.put("confirm_password", "Confirm field must be greater then 8 characters");
        }
    }// END OF CHECK PASSWORD LENGTH.




      /*
    |
    |-----------------------------------------
    | GETTER AND SETTER METHODS:
    |-----------------------------------
    */

    public String getCurrent() {
        return current;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

}// END OF CHANGE PASSWORD VALIDATION HELPER.
