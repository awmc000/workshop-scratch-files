package com.school;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FoodLabProgram {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scnr.next());
        Scanner inputScanner = new Scanner(fileInputStream);

        boolean inputDone = false;

        String line;
        String[] strArray;

        while (!inputDone) {
            line = inputScanner.nextLine();
            strArray = line.split("\t");
            // If availability flag says available, print that item in specified style

            if (strArray[3].equals("Available")) {
                System.out.println(strArray[1] + " (" + strArray[0] + ") -- " + strArray[2]);
            }

            if (!inputScanner.hasNextLine()) {
                inputDone = true;
            }
        }
    }
}
