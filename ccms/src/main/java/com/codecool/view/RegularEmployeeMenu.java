package com.codecool.view;

public class RegularEmployeeInterface extends Menu{
    public RegularEmployeeInterface() {
        this.label = "Employee";
        this.options = new String[] {
                "List students",
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                System.out.println("List students");
                break;
            }
            default: {
                System.out.println("Wrong command");
                break;
            }
        }
    }
}
