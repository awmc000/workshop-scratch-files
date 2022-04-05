package com.school;

import java.util.Scanner;

public class FinalExam {
    /*public static void printer() {
        System.out.println("hello");
        printer();
    }*/
    public static void numberOfStudents(int num) {
        if (num >= 10) {
            System.out.println(num);
        }
        else {
            System.out.print("Bye");
            numberOfStudents(num+1);
        }
    }
    public static void displayTime(int hr, int min, int sec) {
        if(hr < 1 || hr > 12) {
            System.out.print("Error: hour ");
            hr = 1;
        }
        if(min < 1 || min > 59) {
            System.out.print("Error: minute ");
            min = 1;
        }
        if(sec < 1 || sec > 59) {
            System.out.print("Error: second ");
            sec = 1;
        }
        System.out.println(hr + ":" + min + ":" + sec);
    }
    public static void main(String[] args) {
        displayTime(15, 24, 65);
    }
}