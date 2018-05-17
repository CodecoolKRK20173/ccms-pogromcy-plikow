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
        this.setLogin("none");
        this.setSolution("none");
        this.setGrade(0);
    }

    public boolean isDone() {
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(login
                    + " " + description
                    + " " + solution
                    + " " + status
                    + " " + grade);

        return result.toString();
    }

    public Assignment copy() {
        return new Assignment(description);
    }
}

