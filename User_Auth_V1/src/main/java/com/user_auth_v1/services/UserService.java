package com.user_auth_v1.services;

import com.user_auth_v1.models.User;
import com.user_auth_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public int registerUser(String first_name, String last_name, String email, String password, String token, int code){
        return userRepository.registerUser(first_name, last_name, email, password, token, code);
    }// END OF REGISTER USER SERVICE METHOD.


    public int verifyAccount(String token, int code){
        return userRepository.verifyAccount(token, code);
    }// END OF VERIFY ACCOUNT SERVICE METHOD.


    public List<String> checkTokenAndCode(String token, int code){
        return userRepository.checkTokenAndCode(token, code);
    }// END OF CHECK TOKEN AND CODE SERVICE METHOD.

    public String doesEmailExist(String email){
        return userRepository.doesEmailExist(email);
    }// END OF DOES EMAIL EXIST SERVICE METHOD.

    public int isAccountVerified(String email){
        return userRepository.isAccountVerified(email);
    }// END OF CHECK IF ACCOUNT IS VERIFIED.

    public String getDbPasswordByEmail(String email){
        return userRepository.getDbPasswordByEmail(email);
    }// END OF GET DB PASSWORD BY EMAIL SERVICE METHOD.


    public User getUserDetailsByEmail(String email){
        return userRepository.getUserDetailsByEmail(email);
    }// END OF GET USER DETAILS BY EMAIL SERVICE METHOD.

    public int forgotPassword(String token, String code, String password, String Email){
        return userRepository.forgotPassword(token, code, password, Email);
    }// END OF FORGOT PASSWORD SERVICE METHOD.

    public int changePassword(String token, String code, String password){
        return userRepository.changePassword(token, code, password);
    }// END OF CHANGE PASSWORD SERVICE METHOD.

    public String getHashedPasswordByTokenAndCode(String token, String code){
        return userRepository.getHashedPasswordByTokenAndCode(token, code);
    }// END OF GET HASHED PASSWORD BY TOKEN AND CODE SERVICE METHOD.

    public int updatePasswordByEmail(String password, String email){
        return userRepository.updatePasswordByEmail(password, email);
    }// END OF UPDATE PASSWORD BY EMAIL.

}// END OF USER SERVICE CLASS.
