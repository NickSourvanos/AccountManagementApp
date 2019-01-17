package com.dataverse.AccountManagementApp.controller.user.management;

import com.dataverse.AccountManagementApp.controller.mapper.UserToUserModelMapper;
import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.form.RegisterForm;
import com.dataverse.AccountManagementApp.model.UserModel;
import com.dataverse.AccountManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/profile")
public class EditUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserToUserModelMapper userToUserModelMapper;

    @PostMapping(value = "/edit")
    public String editUser(User user){
        User updatedUser = userService.findUserByUserId(user.getUserId());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setCompanyName(user.getCompanyName());
        updatedUser.setEmail(user.getEmail());

        userService.updateUser(updatedUser);

        return "redirect:/profile";
    }

}
