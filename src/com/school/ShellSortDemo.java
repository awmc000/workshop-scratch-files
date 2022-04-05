package com.school;

import java.util.Arrays;

/**
 * ShellSortDemo
 */
public class ShellSortDemo {

    public static void insertionSortInterleaved(int[] array, int size, int startIndex, int gap) {
        int i = 0;
        int j = 0;
        int temp = 0;

        for (i = startIndex + gap; i < size; i = i + gap) {
            j = i;
            while ((j - gap >= startIndex) && (array[j] < array[j - gap])) {
                System.out.println("i: "+ i + "j: "+ j + " " + array[j] + " <- Swap -> " + array[j - gap]);
                temp = array[j];
                array[j] = array[j - gap];
                array[j - gap] = temp;
                j -= gap;
            }
        }
    }
    
    public static void shellSort(int[] array, int size, int[] gapValues) {
        for (int i = 0; i < gapValues.length; ++i) {
            for (int j = 0; j < gapValues[j]; ++j) {
                insertionSortInterleaved(array, size, j, gapValues[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 2, 4, 6, 7, 12, 3, 466, 2, 001, 4543, 20};
        int[] gaps = {31, 15, 7, 3, 1};
        System.out.println("UNSORTED: " + Arrays.toString(numbers));
        shellSort(numbers, 12, gaps);
        System.out.println("Completely Sorted: " + Arrays.toString(numbers));
    }

}