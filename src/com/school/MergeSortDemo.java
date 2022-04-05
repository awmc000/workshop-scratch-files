package com.school;

import java.util.Arrays;

public class MergeSortDemo {
    private static void merge(int[] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;
        int[] mergedNumbers = new int[mergedSize]; 
        int mergePos = 0;
        int leftPos = i;
        int rightPos = j + 1;

        // Add smallest element from left or right partition to merged nums
        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // If left partition is not empty, add remaining elements to merged nums
        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition is not empty, add remaining elements to merged nums
        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    private static void mergeSort(int[] numbers, int i, int k) {
        int j = 0;

        if (i < k) {
            j = (i + k) / 2; // find midpoint in partition

            // Recursively sort left and right partitions
            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            // Merge left and right partitions in sorted order
            merge(numbers, i, j, k);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {33, 21, 1, 4, 9, 99, 382, 220, 202, 11, 21, -1};

        System.out.println("UNSORTED: " + Arrays.toString(numbers));
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("SORTED: " + Arrays.toString(numbers));
    }
}