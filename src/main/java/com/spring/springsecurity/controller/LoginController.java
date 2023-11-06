package com.spring.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basic/")
public class LoginController {

    @GetMapping("mybasic")
    public String login()
    {
        return "my name is mohamed";
    }
    @GetMapping("allbasic")
    public String all()
    {
        return "all";
    }



}
