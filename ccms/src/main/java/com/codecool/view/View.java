package com.codecool.view;

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

    public void printList(List<User> list) {

        for (User u : list) System.out.println(u.toString());
    }
}
