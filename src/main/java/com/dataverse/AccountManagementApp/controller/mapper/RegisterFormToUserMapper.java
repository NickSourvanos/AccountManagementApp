package com.dataverse.AccountManagementApp.controller.mapper;

import com.dataverse.AccountManagementApp.form.RegisterForm;
import com.dataverse.AccountManagementApp.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormToUserMapper {

    public UserModel mapToUserModel(RegisterForm registerForm) {
        UserModel userModel = new UserModel();
        userModel.setRole(registerForm.getRole());
        userModel.setEmail(registerForm.getEmail());
        userModel.setCompanyName(registerForm.getCompanyName());
        userModel.setFirstName(registerForm.getFirstName());
        userModel.setLastName(registerForm.getLastName());
        userModel.setPass(registerForm.getPass());
        return userModel;
    }

}
