package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initialized");
        Scanner scnr = new Scanner(System.in);
        int result;
        int stop;
        int a;
        int b;
        System.out.println("Enter stop number:");
        stop = scnr.nextInt();
        result = 0;

        for (a = 0; a < 3; ++a) {
            System.out.print(a + ": ");
            for (b = 0; b < 4; ++b) {
                result += a + b;
                if (result > stop) {
                    System.out.print("_ ");
                    continue;
                }
                System.out.print(result + ",");
            }
            System.out.println();
        }
    }
}
