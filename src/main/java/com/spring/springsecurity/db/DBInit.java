package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.RoleRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.Role;
import com.spring.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public DBInit(UserRepository userRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public AuthoritiesRepository getAuthoritiesRepository() {
        return authoritiesRepository;
    }

    public void setAuthoritiesRepository(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user =  new User("ahmed" , "ahmed123" , "20" , "saad zaghlol" , 1);
        user.setRoles(this.roleRepository.findAll());
        user.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(user);
    }
}
