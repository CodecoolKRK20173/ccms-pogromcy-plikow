package com.codecool.model;

public class Assignment {
    private boolean status;
    private String login;
    private String description;
    private String solution;
    private Integer grade;

    public Assignment(String description) {
        this.setDescription(description);
        this.status = false;
        this.setLogin(null);
        this.setSolution(null);
        this.setGrade(null);
    }

    public boolean getStatus() {
        return status;
    }

    public void markDown() {
        this.status = true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}