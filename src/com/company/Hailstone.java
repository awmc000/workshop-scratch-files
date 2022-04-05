package com.company;

import java.util.Scanner;

public class Hailstone {

    public static void main(String[] args) {
        //System.out.print("Main method of hailstone class run.");
        Scanner scnr = new Scanner(System.in);
        Hailstone labObject = new Hailstone();
        int num;

        num = scnr.nextInt();
        labObject.hailstone(num); // Call hailstone() to print out the hailstone sequence.
    }

    public void hailstone(int num) {
        // Hailstone sequence method.
        int step = 0;
        while (num != 1) {
            /*
               Print number at the beginning of the loop, because it has either been determined in
               the previous iteration, or it is the first number the user entered, which we want
               to display.
            */
            System.out.print(num + "\t");

            // if-else statement checks if number is even or odd and operates on 'num' accordingly
            if (num % 2 == 0) {
                num /= 2;
                step += 1;
            } else {
                num = (num * 3) + 1;
                step += 1;
            }
            /*
            // if statement checks if the step counter has reached a multiple of 10, and if so, it
            // prints a newline
            */
            if ((step % 10) == 0) {
                System.out.println();
            }
        }
        System.out.println(num);
    }
}
