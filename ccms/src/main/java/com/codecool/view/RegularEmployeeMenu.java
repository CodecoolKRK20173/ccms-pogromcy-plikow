package com.codecool.view;

import com.codecool.controller.RegularEmployeeController;

public class RegularEmployeeMenu extends Menu{

    private RegularEmployeeController controller;
    private View view;

    public RegularEmployeeMenu() {
        this.view = new View();
        this.controller = new RegularEmployeeController();
        this.label = "Employee";
        this.options = new String[] {
                "List students",
        };
    }

    protected void executeOption(int option) {

        switch (option) {
            case 1: {
                view.print("List students");
                view.printList(controller.getStudents());
                break;
            }
            default: {
                view.print("Wrong command");
                break;
            }
        }
    }
}
