package com.company;

import java.util.Random;

public class BetweenFourtyAndSixty {
    public static void main(String[] args) {
        final int NUMBER_OF_INTS = 20;
        Random randGen = new Random();
        int[] randNums = new int[NUMBER_OF_INTS];
        int oddNumsSum = 0;


        for (int i = 0; i < NUMBER_OF_INTS; ++i) {
            randNums[i] = (randGen.nextInt(20) + 40);
            //System.out.println(randNums[i]);
        }

        // I did not entirely understand whether to display each odd number, their total sum, or both, so I did both.
        for (int i = 0; i < NUMBER_OF_INTS; ++i) {
            if ((randNums[i] % 2) != 0) {
                System.out.println(randNums[i] + " is an odd value.");
                oddNumsSum += randNums[i];
            }
        }

        System.out.println("The total of all odd numbers is " + oddNumsSum);
    }
}
