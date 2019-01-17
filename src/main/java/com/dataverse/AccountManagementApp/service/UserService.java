package com.dataverse.AccountManagementApp.service;

import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.model.UserModel;

public interface UserService {

    User findUserByEmail(String email);

    UserModel saveUser(UserModel user);

    User updateUser(User user);

    User findUserByUserId(Long userId);
}
