package com.codecool.view;

public class MentorInterface extends Menu{
    public MentorInterface() {
        this.label = "Mentor";
        this.options = new String[] {
                "List students",
                "Add assignment",
                "Grade assignment",
                "Check attendance",
                "Add student",
                "Remove student",
                "Edit student"
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                System.out.println("List students");
                break;
            }
            case 2: {
                System.out.println("Add assignment");
                break;
            }
            case 3: {
                System.out.println("Grade assignment");
                break;
            }
            case 4: {
                System.out.println("Check attendance");
                break;
            }
            case 5: {
                System.out.println("Add student");
                break;
            }
            case 6: {
                System.out.println("Remove student");
                break;
            }
            case 7: {
                System.out.println("Edit student");
                break;
            }
            default: {
                System.out.println("Wrong command");
                break;
            }
        }
    }

}
