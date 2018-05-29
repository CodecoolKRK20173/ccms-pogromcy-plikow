package com.codecool.view;

import com.codecool.model.Assignment;
import com.codecool.model.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public void printEditMenu(String[] informations) {
        System.out.println(String.format("%s, %s, %s\n", informations[0], informations[1], informations[2]));
        print("0. Finish");
        print("1. Name");
        print("2. Surname");
        print("3. E - mail");
    }

    public void printEditMenu(Map<String, String> data) {
        int i = 1;
        printMapInLine(data);

        print("0. Finish");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.format("%d: %s", i++, entry.getKey());
        }
    }

    private String printMapInLine(Map<String, String> map) {
        String result = "";

        for (Map.Entry<String, String> entry : map.entrySet()) {
            result += String.format("%s: %s     ", entry.getKey(), entry.getValue());
        }
        return result;
    }
}
