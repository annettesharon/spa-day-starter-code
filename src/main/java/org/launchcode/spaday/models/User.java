package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message="Username cannot be blank!")
    @Size(min = 5, max =15, message = "Username must be between 5 and 15 characters")
    private String userName;
    @Email(message = "Invalid email! Please enter a valid email address.")
    private String email;

    @NotBlank(message = "Password cannot be blank!")
    @Size(min=6,message="Password must be at least 6 characters long!")
    private String password;

    private String verifyPassword;
    public String getUserName() {
        return userName;
    }

    public User() {
    }

    public User(String userName, String email, String password, String verifyPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyPassword=verifyPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsername() {
        return userName;
    }
    public String getEmail() {
        return email;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
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
}