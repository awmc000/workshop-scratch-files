package com.school;

import java.util.Scanner;

public class CountDownTimer {
    public static void countDown(int countInt) {
        if (countInt <= 0) {
            System.out.println("Go!");
        } else {
            System.out.println(countInt);
            countDown(countInt - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter value to count down from:");
        Scanner scanner = new Scanner(System.in);
        countDown(scanner.nextInt());
    }
}
