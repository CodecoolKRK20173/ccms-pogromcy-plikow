package com.codecool.view;

class ManagerInterface extends Menu{

    public ManagerInterface() {
        this.label = "Manager";
        this.options = new String[] {
                "List mentors",
                "List students",
                "Add mentor",
                "Remove mentor",
                "Edit mentor",
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                System.out.println("List mentors");
                break;
            }
            case 2: {
                System.out.println("List students");
                break;
            }
            case 3: {
                System.out.println("Add mentor");
                break;
            }
            case 4: {
                System.out.println("Remove mentor");
                break;
            }
            case 5: {
                System.out.println("Edit mentor");
                break;
            }
            default: {
                System.out.println("Wrong command");
                break;
            }
        }
    }
}
