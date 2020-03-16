package com.springboot.demo.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

import java.util.UUID;


public class User {
    private final UUID userId;

    @NotBlank
    private final String userName;

    @NotBlank
    private String userPassword;

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @NotBlank
    private String email;

    public User(@JsonProperty("userId") UUID userId,
                @JsonProperty("userName") String userName,
                @JsonProperty("userPassword") String userPassword,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("email") String email) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
