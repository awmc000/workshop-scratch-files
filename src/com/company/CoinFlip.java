package com.company;

import java.util.Scanner;
import java.util.Random;

public class CoinFlip {

    /* Define your method here */
    public static String headsOrTails(Random rand) {
        int heads = rand.nextInt(2);
        if (heads == 0) {
            return "heads";
        } else {
            return "tails";
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random(2); // Unique seed
        // Add more variables as needed
        int numberDecisions = scnr.nextInt();
        /* Type your code here. */
        for (int i = 0; i < numberDecisions; ++i) {
            System.out.println(headsOrTails(rand));
        }
    }
}