package com.company;

import java.util.Scanner;
import java.util.Random;
public class MidtermExam {
    public static void main(String    [] args) {
        int a = 1222;
        int b = 332;
        int c = 22;

        if ((a < b) && (a < c)) {
            System.out.println(a);
        } else if ((b < a) && (b < c)) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }
}
