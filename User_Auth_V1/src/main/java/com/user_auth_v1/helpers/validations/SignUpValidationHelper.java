package com.user_auth_v1.helpers.validations;

import com.user_auth_v1.helpers.general.GeneralStringHelper;

import java.util.HashMap;

public class SignUpValidationHelper {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirm;

    private final HashMap<String, String> errors;

    public SignUpValidationHelper(String firstName, String lastName, String email, String password, String confirm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;


        // VALIDATIONS:
        errors = new HashMap<>();

        checkForEmptyFields();
        checkIfPasswordsMatch();
        checkIfEmailIsValid();
        checkPasswordLength();

    }// END OF ALL ARGS CONSTRUCTOR.

    /*
    |
    |-----------------------------------------
    | VALIDATION METHODS:
    |-----------------------------------
    */

    public void checkForEmptyFields(){

        if(this.getFirstName().isEmpty() || this.getFirstName() == null){
            errors.put("firstName", "First name field cannot be empty");

        }

        if(this.getLastName().isEmpty() || this.getLastName() == null){
            errors.put("lastName", "Last name field cannot be empty");
        }

        if(this.getEmail().isEmpty() || this.getEmail() == null){
            errors.put("email", "Email field cannot be empty");
        }

        if(this.getPassword().isEmpty() || this.getPassword() == null){
            errors.put("password", "Password field cannot be empty");
        }

        if(this.getConfirm().isEmpty() || this.getConfirm() == null){
            errors.put("confirm", "Confirm field cannot be empty");
        }

    }// END OF CHECK FOR EMPTY FIELDS.


    public void checkIfPasswordsMatch(){
        if(!this.getPassword().equals(this.getConfirm())){
            errors.put("password", "Passwords do not match");
            errors.put("confirm", null);
        }

    }// END OF CHECK IF PASSWORDS MATCH.


    public void checkIfEmailIsValid(){
        if(!GeneralStringHelper.regexEmailValidationPattern(this.getEmail())){
            errors.put("email", "Please enter a valid email address");
        }

    }// END OP CHECK IF EMAIL IS VALID.

    public void checkPasswordLength(){
        if(this.getPassword().length() < 8){
            errors.put("password", "Password must be greater then 8 characters");
        }

        if(this.getConfirm().length() < 8){
            errors.put("confirm", "Confirm field must be greater then 8 characters");
        }
    }// END OF CHECK PASSWORD LENGTH.


    /*
    |
    |-----------------------------------------
    | GETTERS AND SETTER METHODS:
    |-----------------------------------
    */

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}// END OF SIGN UP VALIDATION HELPER.
