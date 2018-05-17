package com.codecool.model;

public class User {
    private String logIn;
    private String password;
    private String name;
    private String surname;
    private String eMail;
    private String type;

    public User(String logIn, String password, String name, String surname, String eMail, String type) {
        this.logIn = logIn;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.type = type;
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

    public String getType() {
        return type;
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
                + " " + type);
        return sb.toString();
    }
}
