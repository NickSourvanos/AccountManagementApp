package com.dataverse.AccountManagementApp.controller.mapper;

import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserToUserModelMapper {

    public UserModel mapToUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setRole(user.getRole());
        userModel.setEmail(user.getEmail());
        userModel.setCompanyName(user.getCompanyName());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setPass(user.getPass());
        return userModel;
    }

}
