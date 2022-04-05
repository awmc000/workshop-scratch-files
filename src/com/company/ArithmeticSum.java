package com.company;

public class ArithmeticSum {
    public int AriSum(int val) {
        int sum = 0;
        int i = 1;
        while(i <= val) {
            sum = sum +i;
            System.out.println("execute");
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArithmeticSum aSum = new ArithmeticSum();
        System.out.println("The arithmetic sum is " + aSum.AriSum(5));
        System.out.println("The arithmetic sum is " + aSum.AriSum(6));
    }
}
