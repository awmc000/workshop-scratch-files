package com.school;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class StudentLabProgram {

    public static String findID(String studentName, Scanner infoScnr) throws Exception {
        /*
        * Method findID() takes two parameters, a student's name and a Scanner object
        * containing the text file's contents. Method findID() returns the ID associated
        * with the student's name if the name is in the file, otherwise the method
        * throws an Exception object with the message "Student ID not found for
        * studentName", where studentName is the name of the student.
         */
        boolean inputDone = false;
        String line;
        String[] splitLine;
        String studentID;
        while(infoScnr.hasNextLine()) {
            line = infoScnr.nextLine();
            splitLine = line.split(" ");
            if (studentName.equals(splitLine[0])) {
                return splitLine[1];
            }
        }
        throw new Exception("Student ID not found for "+ studentName);
    }

    public static String findName(String studentID, Scanner infoScnr) throws Exception {
        /*
        * Method findName() takes two parameters, a student's ID and a Scanner object
        * containing the text file's contents. Method findName() returns the name
        * associated with the student's ID if the ID is in the file, otherwise the
        * method throws an Exception object with the message "Student name not found
        * for studentID", where studentID is the ID of the student.
        * *
        */
        boolean inputDone = false;
        String line;
        String[] splitLine;
        String studentName;
        while (infoScnr.hasNextLine()) {
            line = infoScnr.nextLine();
            splitLine = line.split(" ");
            if (studentID.equals(splitLine[1])) {
                return splitLine[0];
            }
        }
        throw new Exception("Student name not found for " + studentID);
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String studentName;
        String studentID;
        String studentInfoFileName;
        FileInputStream studentInfoStream = null;
        Scanner studentInfoScanner = null;

        // Read the text file name from user
        studentInfoFileName = scnr.next();

        // Open the text file
        studentInfoStream = new FileInputStream(studentInfoFileName);
        studentInfoScanner = new Scanner(studentInfoStream);

        // Read search option from user. 0: findID(), 1: findName()
        int userChoice = scnr.nextInt();

        // findID() and findName() may throw an Exception.
        // Insert a try/catch statement to catch the exception and output the exception message.

        if (userChoice == 0) {
            studentName = scnr.next();
            try {
                studentID = findID(studentName, studentInfoScanner);
                System.out.println(studentID);
            }
            catch (Throwable throwableObject) {
                System.out.println("Student ID not found for " + studentName);
            }
        }
        else {
            studentID = scnr.next();
            try {
                studentName = findName(studentID, studentInfoScanner);
                System.out.println(studentName);
            }
            catch (Throwable throwableObject) {
                System.out.println("Student name not found for " + studentID);
            }
        }

        studentInfoStream.close();
    }
}
