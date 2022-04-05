package com.school;

import java.util.ArrayList;
import java.util.Scanner;

public class IntegerTable {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        Scanner scnr = new Scanner(System.in);
        int i;
        int counter; // Will be used for finding min & max
        System.out.println("Enter integers separated by a space " +
                "and finished by a negative value:");
        int input = scnr.nextInt();

        // While input is non-negative, add to integerList
        while (input > 0) {
            integerList.add(input);
            input = scnr.nextInt();
        }

        // Ask how many values to display per row
        System.out.println("How many values to show per row?");
        int valuesPerRow = scnr.nextInt();
        int numberRowsNeeded = (integerList.size() / valuesPerRow);

        // Print table
        for (i = 0; i < integerList.size(); ++i) {
            System.out.print(" " + integerList.get(i));
            if ((i + 1) % valuesPerRow == 0) {
                System.out.print("\n");
            }
        }
        // Print a new line after completed table
        System.out.print("\n");


        // Find minimum
        int minimum = integerList.get(0);

        for (i = 0; i < integerList.size(); ++i) {
            if (integerList.get(i) < minimum) {
                minimum = integerList.get(i);
            }
        }

        // Find maximum
        int maximum = integerList.get(0);

        for (i = 0; i < integerList.size(); ++i) {
            if (integerList.get(i) > maximum) {
                maximum = integerList.get(i);
            }
        }

        // Find average (mean)
        double average;
        double sum = 0;

        // Sum all values in integerList
        for (i = 0; i < integerList.size(); ++i) {
            sum += integerList.get(i);
        }

        average = sum / integerList.size();

        // Print min, max, and average
        System.out.println("Min: " + minimum);
        System.out.println("Max: " + maximum);
        System.out.println("Average: " + average);
    }
}
