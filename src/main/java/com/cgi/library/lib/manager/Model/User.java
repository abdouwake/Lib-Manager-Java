package com.cgi.library.lib.manager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String secondName;
    @Email
    private String email;
    private String HashPass;
    @OneToMany
    private List<Role> roles;

    public User(){}

    public User(int id, String firstName, String secondName, String email, String hashPass,List<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.HashPass = hashPass;
        this.roles =roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPass() {
        return HashPass;
    }

    public void setHashPass(String hashPass) {
        HashPass = hashPass;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
