package com.company;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        //String inputWord = "Hello!";
        Scanner scnr = new Scanner(System.in);
        int x = scnr.nextInt();
        int sum = 0;
        int i;
        int currValue = 0;
        for (i = 0; i < x; ++i) {
            currValue = scnr.nextInt();
            sum += currValue;
            System.out.println(sum);
        }
    }
}
