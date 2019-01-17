package com.dataverse.AccountManagementApp.model;


import com.dataverse.AccountManagementApp.enums.RoleType;

public class UserModel {

    private Long userId;
    private RoleType role;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String pass;

    public UserModel(){}

    public UserModel(RoleType role, String firstName, String lastName, String email, String companyName, String pass) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
        this.pass = pass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
