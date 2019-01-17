package com.dataverse.AccountManagementApp.controller.user.profile;

import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/profile")
    public String profilePage(Model model){
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByEmail(userEmail);
        model.addAttribute("user", user);
        return "profile-page";
    }

}
