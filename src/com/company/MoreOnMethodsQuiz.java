package com.company;

public class MoreOnMethodsQuiz {
    public void getAverage(int[] num) {
        int avg;
        avg = (num[0] + num[1] + num[2]) / 3;
    }
    public static void main (String [] args) {
        MoreOnMethodsQuiz myAvg = new MoreOnMethodsQuiz();
        int avg;
        int[] newAvg = new int[3];

        avg = 0;
        newAvg[0] = 10;
        newAvg[1] = 20;
        newAvg[2] = 30;
        myAvg.getAverage(newAvg);
        System.out.println(avg);
    }
}
