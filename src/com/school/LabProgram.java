package com.school;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.PrintWriter;
import java.io.IOException;

public class LabProgram {
    public static String studentMark(int midterm1, int midterm2, int finalExam) {
        int studentGradeSum = midterm1 + midterm2 + finalExam;
        double studentAvg = studentGradeSum / 3.0;
        if (studentAvg >= 90) {
            return "A";
        } else if (studentAvg >=80) {
            return "B";
        } else if (studentAvg >= 70) {
            return "C";
        } else if (studentAvg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        /* TODO: Declare any necessary variables here. */
        FileInputStream inStream = null;
        Scanner inScanner = null;

        FileOutputStream outStream = null;
        PrintWriter printWriter = null;

        boolean inputDone;
        String fileName;

        String lastName;
        String firstName;

        int midterm1Score;
        int midterm2Score;
        int finalScore;

        int midterm1Sum = 0;
        int midterm2Sum = 0;
        int finalSum = 0;

        int studentCount = 0;

        String line;
        ArrayList<String> newLines = new ArrayList<String>();


        inputDone = false;

        /* TODO: Read a file name from the user and read the tsv file here. */

        fileName = scnr.next();
        inStream = new FileInputStream(fileName);
        inScanner = new Scanner(inStream);
        while (!inputDone) {
            if (!inScanner.hasNext()) {
                inputDone = true;
            } else {
                lastName = inScanner.next();
                firstName = inScanner.next();

                midterm1Score = inScanner.nextInt();
                midterm1Sum += midterm1Score;

                midterm2Score = inScanner.nextInt();
                midterm2Sum += midterm2Score;

                finalScore = inScanner.nextInt();
                finalSum += finalScore;

                line = lastName + "\t" + firstName + "\t"
                        + midterm1Score + "\t" + midterm2Score + "\t" +
                        finalScore + "\t" + studentMark(midterm1Score, midterm2Score, finalScore);
                System.out.println(line);
                newLines.add(line);
                studentCount +=1;
            }
        }
        inStream.close();
        /* TODO: Compute student grades and exam averages, then output results to a text file here. */
        outStream = new FileOutputStream("report.txt");
        printWriter = new PrintWriter(outStream);
        for (int i = 0; i < newLines.size(); ++i) {
            printWriter.println(newLines.get(i));
        }
        printWriter.print("\nAverages: Midterm1 ");
        printWriter.printf("%.2f", (1.0 * midterm1Sum / studentCount));
        printWriter.print(", Midterm2 ");
        printWriter.printf("%.2f", (1.0 * midterm2Sum / studentCount));
        printWriter.print(", Final ");
        printWriter.printf("%.2f", (1.0 * finalSum / studentCount));
        printWriter.println();
        printWriter.close();
    }
}