package com.company;

import java.util.ArrayList;

public class ChEightQuiz {
    public ChEightQuiz() {}

    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int count;
        for(count = 1; count < 10; ++count) {
            numList.add(count);
        }
        System.out.println(numList.get(4));
    }
}
