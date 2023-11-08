package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public DBInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
