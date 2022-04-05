package com.company;

import java.util.Scanner;

public class DerivativeMachine {
    public static void main(String[] args) {
        //init
        DerivativeMachine derivativeMachine = new DerivativeMachine();

        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the 'h' value, followed by the 'a - h' value, followed by the 'a + h' value.");
        double hEntered = scnr.nextDouble();
        double aMinusHEntered = scnr.nextDouble();
        double aPlusHEntered = scnr.nextDouble();
        System.out.println(derivativeMachine.centralDifference(aMinusHEntered, aPlusHEntered, hEntered));
    }

    public double centralDifference(double aMinusH, double aPlusH, double h) {
        double centralDifference = ((aPlusH - aMinusH) / (2 * h));
        return centralDifference;
    }
}
