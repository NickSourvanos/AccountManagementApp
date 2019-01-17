package com.dataverse.AccountManagementApp.domain;

import com.dataverse.AccountManagementApp.enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name = "USER", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    private static final int MAX_LENGTH = 40;
    private static final int HASH_PASSWORD_LENGTH = 120;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role;

    @Column(name = "first_name", length = MAX_LENGTH)
    private String firstName;

    @Column(name = "last_name", length = MAX_LENGTH)
    private String lastName;

    @Column(name = "email", length = MAX_LENGTH)
    private String email;

    @Column(name = "companyName", length = MAX_LENGTH)
    private String companyName;

    @Column(name = "pass", length = HASH_PASSWORD_LENGTH)
    private String pass;

    public User(){}

    public User(RoleType role, String firstName, String lastName, String email, String companyName, String pass) {
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
