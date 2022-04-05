package com.company;

/*
 Write a program with total change amount as an integer input that outputs the
 change using the fewest coins, one coin type per line. The coin types are dollars,
 quarters, dimes, nickels, and pennies. Use singular and plural coin names as
 appropriate, like 1 penny vs. 2 pennies.

 If the input is 0 or less, output "no change".

 If the input is 45, the output is

 "1 quarter
 2 dimes"

 Must define and call the following method. Positions 0-4 of coinVals should
 contain the number of dollars, quarters, dimes, nickels and pennies respectively.

 public static void exactChange(int userTotal, int[] coinVals)

*/

import java.util.Scanner;

public class ExactChange {
    public static void exactChange(int userTotal, int[] coinVals) {
        if (userTotal == 0) {
            System.out.println("no change");
        } else {
            int currAmount = userTotal;
            int numDollars = currAmount / 100;
            currAmount %= 100;
            int numQuarters = currAmount / 25;
            currAmount %= 25;
            int numDimes = currAmount / 10;
            currAmount %= 10;
            int numNickels = currAmount / 5;
            currAmount %= 5;
            int numPennies = currAmount;

            coinVals[0] = numDollars;
            coinVals[1] = numQuarters;
            coinVals[2] = numDimes;
            coinVals[3] = numNickels;
            coinVals[4] = numPennies;
        }

    }
    public static void main(String[] args) {
        int[] coinVals = new int[5];
        String[] coinTypesSingular = new String[]{"dollar", "quarter", "dime", "nickel", "penny"};
        String[] coinTypesPlural = new String[]{"dollars", "quarters", "dimes", "nickels", "pennies"};
        Scanner scnr = new Scanner(System.in);
        int userTotal = scnr.nextInt();

        exactChange(userTotal, coinVals);
        for (int i = 0; i < coinVals.length; ++i) {
            if (coinVals[i] > 1) {
                System.out.println(coinVals[i] + " " + coinTypesPlural[i]);
            } else if (coinVals[i] == 1) {
                System.out.println(coinVals[i] + " " + coinTypesSingular[i]);
            }

        }
    }
}
