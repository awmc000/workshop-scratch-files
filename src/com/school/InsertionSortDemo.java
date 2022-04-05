package com.school; 

import java.util.Arrays;

public class InsertionSortDemo {
    public static void insertionSort(int[] numsArray) {
        int i, j, temp;
        for (i = 1; i < numsArray.length; ++i) {
            j = i;
            while (j > 0 && numsArray[j] < numsArray[j - 1]) {
                temp = numsArray[j];
                System.out.println("Replacing " + numsArray[j] + " with " + numsArray[j - 1]);
                numsArray[j] = numsArray[j - 1];
                numsArray[j - 1] = temp;
                --j;
            }
            System.out.println("Current Array: " + Arrays.toString(numsArray));
        }
    }

    public static void main(String[] args) {
        int[] numsArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Unsorted: " + Arrays.toString(numsArray));
        insertionSort(numsArray);
        System.out.println("Sorted: " + Arrays.toString(numsArray));
    }
}