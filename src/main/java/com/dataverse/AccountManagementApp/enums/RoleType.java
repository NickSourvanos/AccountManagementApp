package com.dataverse.AccountManagementApp.enums;

public enum RoleType {

    USER("user");

    private String role;

    RoleType(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
