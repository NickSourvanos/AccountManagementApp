package com.dataverse.AccountManagementApp.controller.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login-page";
    }




}
