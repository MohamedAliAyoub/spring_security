package com.spring.springsecurity.model;

public class JwtLogin {
    private String userName ;
    private String password ;

    public JwtLogin() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
