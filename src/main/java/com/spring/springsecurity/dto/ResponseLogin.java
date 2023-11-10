package com.spring.springsecurity.dto;

import lombok.Getter;

@Getter
public class ResponseLogin {

    String token;
    String username;

    public ResponseLogin() {
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}