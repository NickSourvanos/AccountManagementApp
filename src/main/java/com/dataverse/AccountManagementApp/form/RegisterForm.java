package com.dataverse.AccountManagementApp.form;

import com.dataverse.AccountManagementApp.enums.RoleType;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {

    private static final String PASSWORD_PATTERN = "^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*[^0-9A-Za-z]).+";

    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final int PASSWORD_MINSIZE = 8;

    @Pattern(regexp = PASSWORD_PATTERN, message = "\"Invalid password pattern\"")
    @Size(min = PASSWORD_MINSIZE, message = "\"Invalid password size\"")
    private String pass;

    private RoleType role;

    @Pattern(regexp = MAIL_PATTERN, message = "\"Invalid mail pattern\"")
    private String email;

    private String firstName;

    private String lastName;

    private String companyName;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
