package com.A5AlexMcColm;

import java.util.Scanner;

public class PasswordValidationTestDriver {
    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator("C:\\Users\\AMC\\IdeaProjects\\workshop-scratch-files\\src\\com\\A5AlexMcColm\\dictionary.txt");
        passwordValidator.printInfo();

        // Taking input
        Scanner scnr = new Scanner(System.in);
        boolean passwordValid = false;
        String input = "";
        while (!passwordValid) {
            System.out.println("Please enter a password: ");
            input = scnr.next();
            if (input.equals("-1")) { break; }
            passwordValid = passwordValidator.isValid(input);
            if (!passwordValid) {
                System.out.println("Not valid, please enter another.");
            }
        }
        if (passwordValid) { System.out.println("Password " + input + " is valid.");}
        scnr.close();
    }
}