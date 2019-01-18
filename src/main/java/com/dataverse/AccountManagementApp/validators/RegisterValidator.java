package com.dataverse.AccountManagementApp.validators;

import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.form.RegisterForm;
import com.dataverse.AccountManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;


@Component
public class RegisterValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm registerForm = (RegisterForm) target;

        try{
            User user = userService.findUserByEmail(registerForm.getEmail());
            if(user.getEmail() != null){

                System.out.println("RegisterValidator: Mail Exists!");
                errors.rejectValue("email", "registerForm.email.exists");
            }

        }catch (NullPointerException e){}




    }
}
