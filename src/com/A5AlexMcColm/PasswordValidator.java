package com.A5AlexMcColm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordValidator {
    private ChainingHashTable dictionary;

    public PasswordValidator(String fileName) {
        dictionary = new ChainingHashTable(100);
        File dictionaryFile = new File(fileName);
        Scanner fileScanner;// = new Scanner()
        try {
            fileScanner = new Scanner(dictionaryFile);
            while (fileScanner.hasNext()) {
                String nextStr = fileScanner.next().replaceAll(" ", "");
                dictionary.insert(nextStr.toLowerCase(), nextStr);
            }
            fileScanner.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found!");
        }
    }

    public void printInfo() {
        System.out.println(dictionary.toString());
    }

    public boolean isValid(String password) {
        // First check: Length
        if (password.length() < 8) { 
            System.out.println("Failed check for a length >= 8 characters.");
            return false; 
        }
        // Second check: Word in dictionary
        if (dictionary.search(password) != null) { 
            System.out.println("Failed check that password is not a dictionary word.");
            return false; 
        }
        // Third check: Has letter and digit
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); ++i) {
            if (Character.isDigit(password.charAt(i))) { hasDigit = true; }
            if (Character.isAlphabetic(password.charAt(i))) { hasLetter = true; }
            if (hasLetter && hasDigit) { break; }
        }
        if (!(hasLetter) || !(hasDigit)) {
            System.out.println("Failed check for at least one letter and one digit.");
            return false;
        }
        // Fourth check: Password is not a dictionary word preceded or followed by a digit
        boolean preceded = (dictionary.search(password.substring(1, password.length()).toLowerCase()) != null);
        boolean succeeded = (dictionary.search(password.substring(0, password.length()-1).toLowerCase()) != null);
        if (preceded || succeeded) {
                System.out.println("Failed check for dict word followed or preceded by digit.");
                return false;
            }
        return true;
    }
    /*
    public static void main(String[] args) {
        /// Abs path
        //PasswordValidator test = new PasswordValidator("C:\\Users\\AMC\\IdeaProjects\\workshop-scratch-files\\src\\com\\A5AlexMcColm\\dictionary.txt");
        // Rel path
        PasswordValidator test = new PasswordValidator("src\\com\\A5AlexMcColm\\dictionary.txt");
        //System.out.println("RESULT: " + test.isValid("8password2335"));
        System.out.println("RESULT: " + test.isValid("1Numerous"));
        System.out.println("RESULT: " + test.isValid("Numerous3"));
        System.out.println("RESULT: " + test.isValid("numerous1"));
    }*/
}
