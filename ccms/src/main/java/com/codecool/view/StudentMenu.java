package com.codecool.view;

public class StudentMenu extends Menu {
    public StudentMenu() {
        this.label = "Student";
        this.options = new String[] {
                "View my grades",
                "Get assignment",
                "Submit assignment"
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                System.out.println("View my grades");
                break;
            }
            case 2: {
                System.out.println("Get assignment");
                break;
            }
            case 3: {
                System.out.println("Submit assignment");
                break;
            }
            default: {
                System.out.println("Wrong command");
                break;
            }
        }
    }
}
