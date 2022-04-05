package com.school;

public class countDigits {
    public int count(int number) {
        int counter;
        // Base case
        if (number < 10) {
            return 1;
        }
        // Recursive case
        if (number >= 10) {
            return 1 + count(number / 10);
        }
        // Should never be reached
        return -1;
    }
    // I tested it in the main method.
    public static void main(String[] args) {
        countDigits countMachine = new countDigits();
        System.out.println(countMachine.count(300000));
    }
}
