package com.school;

import java.util.Scanner;

public class Fibonacci {
    public static int fibonacci(int value) {
        // Base case
        if (value < 2) {
            return value;
        } else { // recursive case
            return (fibonacci(value - 1) + fibonacci(value - 2));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        int givenNum;
        while (cont) {
            givenNum = scan.nextInt();
            if (givenNum == 332) {
                cont = false;
                break;
            }
            System.out.println(fibonacci(givenNum));
        }

    }
}
