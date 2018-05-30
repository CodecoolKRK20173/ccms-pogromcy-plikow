package com.codecool.model;

import java.util.LinkedHashMap;

public class User {
    private String logIn;
    private String password;
    private String name;
    private String surname;
    private String eMail;
    private String role;

    public User(String logIn, String password, String name, String surname, String eMail, String role) {
        this.logIn = logIn;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.role = role;
    }

    public String getLogIn() {
        return logIn;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return eMail;
    }

    public String getRole() {
        return role;
    }

    public LinkedHashMap getContactData() {
        LinkedHashMap<String,String> result = new LinkedHashMap<>();
        result.put("name", this.name);
        result.put("surname", this.surname);
        result.put("email", this.eMail);
        return result;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name
                + " " + surname
                + " " + eMail
                + " " + role);
        return sb.toString();
    }
}
