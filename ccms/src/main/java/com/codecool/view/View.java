package com.codecool.view;

import com.codecool.model.Assignment;
import com.codecool.model.User;

import java.util.List;

public class View {

    public void print() {
        System.out.println();
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void printOptions(String[] options) {
        int index = 1;

        for (String option: options) {
            System.out.println(String.format("(%d) %s", index++, option));
        }
    }

    public void printStringList(List<String> list) {
        for (String s: list) System.out.println(s);
    }

    public void printAssignmentList(List<Assignment> list) {
        int index = 1;
        for (Assignment assignment: list) System.out.println(String.format("(%d) %s", index++, assignment.toString()));
    }

    public void printList(List<User> list) {

        int index = 1;
        for (User u : list) System.out.println(String.format("(%d) %s", index++, u.toString()));    }

    public void printEditMenu() {
        print("1. Name");
        print("2. Surname");
        print("3. E - mail");
    }
}
