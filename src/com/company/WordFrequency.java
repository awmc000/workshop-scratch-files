package com.company;

import java.util.Scanner;

public class WordFrequency {
    public static int getFrequencyOfWord(String[] wordsList, int listSize, String currWord) {
        //TODO: Go through the array passed, and check frequency of th currWord
        int frequencyCount = 0;
        for (int i = 0; i < listSize; ++i) {
            if (wordsList[i].equals(currWord)) {
                //System.out.print(wordsList[i] + " " + currWord);
                frequencyCount += 1;
            }
        }
        //System.out.println("freq: " + frequencyCount + " " + currWord);
        return frequencyCount;
    }
    
    public static void main(String[] args) {
        //TODO: Read in words and add them to an array.
        Scanner scnr = new Scanner(System.in);

        int listSizeInput = scnr.nextInt();
        String[] wordsList = new String[listSizeInput];
        int[] wordsFrequencies = new int[listSizeInput];
        for (int i = 0; i < listSizeInput; ++i) {
            wordsList[i] = scnr.next();
        }
        //TODO: Given the method parameters, each method call will get one word's frequency
        //TODO: So, we need a loop to take each word and print it and its frequency in the array?
        for (int i = 0; i < listSizeInput; ++i) {
            wordsFrequencies[i] = getFrequencyOfWord(wordsList, listSizeInput, wordsList[i]);
        }

        for (int i = 0; i < listSizeInput; ++i) {
            System.out.println(wordsList[i] + " " + wordsFrequencies[i]);
        }

    }

}
