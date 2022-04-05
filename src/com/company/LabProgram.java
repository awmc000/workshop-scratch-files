package com.company;

import java.util.Scanner;

public class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userString;
        // add more variables
        int i;
        boolean result = true;

        userString = scnr.next();
        // Check if each character in the string entered is a digit.
        for (i = 0; i < userString.length(); ++i) {
            char currentChar = userString.charAt(i);
            // if statement is executed if currentChar is NOT a digit.
            if (!(Character.isDigit(currentChar))) {
                result = false;
            }
        }
        // Boolean can be checked just on its own, since it will evaluate to false if false, etc.
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
