package com.spring.springsecurity.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authoritie_name")
    private String authoritieName;



    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authorities(String authoritieName) {
        this.authoritieName = authoritieName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthoritieName() {
        return authoritieName;
    }

    public void setAuthoritieName(String authoritieName) {
        this.authoritieName = authoritieName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
