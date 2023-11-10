package com.spring.springsecurity.model;

import lombok.Getter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {



    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "user_name")
    private String userName;

    @Getter
    @Column(name = "password")
    private String password;

    @Getter
    @Column(name = "age")
    private String age;

    @Getter
    @Column(name = "address")
    private String address;

    @Getter
    @Column(name = "active")
    private int active;



    @Getter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authorities", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "authorities_id")})
    private List<Authorities> authorities = new ArrayList<>();

    public User() {
    }

    public User(String userName, String password, String age, String address, int active) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.address = address;
        this.active = active;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
