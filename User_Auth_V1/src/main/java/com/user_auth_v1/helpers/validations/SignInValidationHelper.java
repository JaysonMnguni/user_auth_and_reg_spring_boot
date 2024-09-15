package com.user_auth_v1.helpers.validations;

import com.user_auth_v1.helpers.general.GeneralStringHelper;

import java.util.HashMap;

public class SignInValidationHelper {

    private String email;
    private String password;
    private HashMap<String, String> errors;

    public SignInValidationHelper(String email, String password) {
        this.email = email;
        this.password = password;
        this.errors = new HashMap<>();

        checkForEmptyFields();
        checkIfEmailIsValid();
    }// END OF ALL ARGS CONSTRUCTOR.


    /*
    |
    |-----------------------------------------
    | VALIDATION METHODS:
    |-----------------------------------
    */

    public void checkForEmptyFields(){

        if(this.getEmail().isEmpty() || this.getEmail() == null){
            errors.put("email", "Email field cannot be empty");
        }

        if(this.getPassword().isEmpty() || this.getPassword() == null){
            errors.put("password", "Password field cannot be empty");
        }


    }// END OF CHECK FOR EMPTY FIELDS.

    public void checkIfEmailIsValid(){
        if(!GeneralStringHelper.regexEmailValidationPattern(this.getEmail())){
            errors.put("email", "Please enter a valid email address");
        }

    }// END OP CHECK IF EMAIL IS VALID.


    /*
    |
    |-----------------------------------------
    | GETTERS AND SETTER METHODS:
    |-----------------------------------
    */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }
}// END OF SIGN IN VALIDATION CLASS.
