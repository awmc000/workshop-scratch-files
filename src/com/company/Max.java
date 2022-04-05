package com.company;

import java.util.Scanner;

public class Max {
    public int findMax() {
        //TODO
        int currentMax = 0;
        int i;
        int currentValue;

        Scanner scanner = new Scanner(System.in);
        currentValue = scanner.nextInt();

        while (currentValue >= 0) {
            if (currentValue > currentMax) {
                currentMax = currentValue;
            }
            currentValue = scanner.nextInt();
        }
        return currentMax;
    }
    public static void main(String[] args) {
        Max test = new Max();
        System.out.println(test.findMax());
    }
}
