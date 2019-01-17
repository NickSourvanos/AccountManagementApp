package com.dataverse.AccountManagementApp.service;

import com.dataverse.AccountManagementApp.controller.mapper.UserToUserModelMapper;
import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.model.UserModel;
import com.dataverse.AccountManagementApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToUserModelMapper userToUserModelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        User user = createUser(userModel);
        User storedUser = userRepository.save(user);
        return userToUserModelMapper.mapToUserModel(storedUser);
    }

    @Override
    public User updateUser(User user) {

        User storedUser = userRepository.save(user);
        return storedUser;
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.findUserByUserId(userId);
    }


    private User createUser(UserModel userModel){
        User user = new User(userModel.getRole(), userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getCompanyName(),
                bCryptPasswordEncoder.encode(userModel.getPass()));
        return user;
    }

}
