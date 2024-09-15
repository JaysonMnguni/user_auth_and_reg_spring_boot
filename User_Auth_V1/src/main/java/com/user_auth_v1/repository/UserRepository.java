package com.user_auth_v1.repository;

import com.user_auth_v1.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (first_name, last_name, email, password, token, code) VALUES" +
            "(:first_name, :last_name, :email, :password, :token, :code)" , nativeQuery = true)
    int registerUser(@Param("first_name") String first_name,
                     @Param("last_name") String last_name,
                     @Param("email") String email,
                     @Param("password") String password,
                     @Param("token") String token,
                     @Param("code") int code);


    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET token = null, code= 0, verified = 1, verified_at = NOW() " +
            "WHERE token = :token AND code=:code", nativeQuery = true)
    int verifyAccount(@Param("token") String token, @Param("code") int code);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET token= :token, code= :code, password = :password WHERE email = :email", nativeQuery = true)
    int forgotPassword(@Param("token") String token,
                       @Param("code") String Code,
                       @Param("password") String password,
                       @Param("email")String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET token = null, code = 0, password = :password, updated_at = Now()" +
            "WHERE token= :token AND code = :code", nativeQuery = true)
    int changePassword(@Param("token") String token,
                       @Param("code") String code,
                       @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = :password, updated_at = Now() WHERE email = :email", nativeQuery = true)
    int updatePasswordByEmail(@Param("password") String password, @Param("email") String email);

    @Query(value = "SELECT token, code FROM users WHERE token= :token AND code= :code", nativeQuery = true)
    List<String> checkTokenAndCode(@Param("token") String token, @Param("code") int code);

    @Query(value = "SELECT email FROM users WHERE email= :email", nativeQuery = true)
    String doesEmailExist(@Param("email") String email);

    @Query(value = "SELECT verified FROM users WHERE email = :email", nativeQuery = true)
    int isAccountVerified(@Param("email") String email);

    @Query(value = "SELECT password FROM users WHERE email = :email", nativeQuery = true)
    String getDbPasswordByEmail(@Param("email") String password);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User getUserDetailsByEmail(@Param("email")String email);

    @Query(value = "SELECT password FROM users WHERE token= :token AND code = :code", nativeQuery = true)
    String getHashedPasswordByTokenAndCode(@Param("token")String token, @Param("code") String code);






}// END OF REPOSITORY INTERFACE.
