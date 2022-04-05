package com.company;

import java.util.Scanner;

public class TwoWords {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String firstWord = scnr.next();
        String secondWord = scnr.next();
        if (firstWord.length() < secondWord.length()) {
            System.out.println(firstWord.length() + " " + firstWord + " " + secondWord.charAt(0));
        } else {
            System.out.println(secondWord.length() + " " + secondWord + " " + firstWord.charAt(0));
        }
    }
}
