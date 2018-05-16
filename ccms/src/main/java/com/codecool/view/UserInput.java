package com.codecool.view;
import java.util.Scanner;
import java.util.InputMismatchException;


public class MyInput {

    private static Scanner input = new Scanner(System.in);

    public static int getInt(String message) {
        clear();
        int userInput = -1;

        System.out.println(message);
        
        try {
            userInput = input.nextInt();
        }

        catch (InputMismatchException e) {
            System.out.println("Type right option!");
            getInt(message);
        }

        return userInput;
    }

    public static float getFloat(String message) {
        clear();
        float userInput = -1;

        System.out.println(message + ": ");
        
        try {
            userInput = input.nextFloat();
        }
        
        catch (InputMismatchException e) {
            System.out.println("Type a number!");
            getFloat(message);
        }

        return userInput;
    }

    public static String getString(String message) {
        clear();
        System.out.println(message + ": ");
        return input.nextLine();

    }

    private static void clear() {
        input = new Scanner(System.in);
    }
}