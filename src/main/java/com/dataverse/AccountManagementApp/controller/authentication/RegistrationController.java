package com.dataverse.AccountManagementApp.controller.authentication;

import com.dataverse.AccountManagementApp.controller.mapper.RegisterFormToUserMapper;
import com.dataverse.AccountManagementApp.form.RegisterForm;
import com.dataverse.AccountManagementApp.model.UserModel;
import com.dataverse.AccountManagementApp.service.UserService;
import com.dataverse.AccountManagementApp.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;

@Controller
public class RegistrationController {


    private static final String REGISTER_FORM = "registerForm";

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterFormToUserMapper registerFormToUserMapper;

    @Autowired
    private RegisterValidator registerValidator;


    @InitBinder(REGISTER_FORM)
    protected void initBinder(final WebDataBinder binder) {
        try{
            binder.addValidators(registerValidator);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping(value = "/registration")
    public String registrationPage(Model model){
        model.addAttribute(REGISTER_FORM, new RegisterForm());
        return "registration-page";
    }

    @PostMapping(value = "/registration")
    public String register(Model model,
                           @Valid @ModelAttribute(REGISTER_FORM)
                                   RegisterForm registerForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Reached!");
            model.addAttribute(ERROR_MESSAGE, "an error occurred");
            return "registration-page";
        }

        UserModel userModel = registerFormToUserMapper.mapToUserModel(registerForm);

        userService.saveUser(userModel);

        return "redirect:/login";
    }


}

/*
        try{
            User user = userService.findUserByEmail(registerForm.getEmail());
            if(!user.getEmail().isEmpty()){
                System.out.println("Exists");
                model.addAttribute("mailError", "exists");
                return "registration-page";
            }
        }catch (NullPointerException e){

        }
*/