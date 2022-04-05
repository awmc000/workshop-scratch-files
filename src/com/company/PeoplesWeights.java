package com.company;

import java.util.Scanner;

/*

(1) Prompt the user to enter five numbers, being five people's weights. Store the numbers in an array of doubles.
Output the array's numbers on one line, each number followed by one space. (2 pts)

(2) Also output the total weight, by summing the array's elements. (1 pt)

(3) Also output the average of the array's elements. (1 pt)

(4) Also output the max array element. (2 pts)

 */

public class PeoplesWeights {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        final int NUM_WEIGHTS = 5;
        double[] weights = new double[5];
        double totalWeight = 0.0;
        double maxWeight = 0.0;

        for (int i = 0; i < NUM_WEIGHTS; ++i) {
            System.out.println("Enter weight " + (i + 1) + ":");
            weights[i] = scnr.nextDouble();
        }

        maxWeight = weights[0];
        System.out.print("You entered: ");
        for (double weight : weights) {
            System.out.print(weight + " ");
            totalWeight += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        System.out.println("\n" + "Total weight: " + totalWeight);
        System.out.println("Average weight: " + (totalWeight / NUM_WEIGHTS));
        System.out.println("Max weight: " + maxWeight);
    }
}
