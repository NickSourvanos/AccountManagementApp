package com.dataverse.AccountManagementApp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(){
        return "login-page";
    }
}
