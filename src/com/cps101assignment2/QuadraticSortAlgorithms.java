package com.cps101assignment2;

// ************************************************
// File:    QuadraticSortAlgorithms
// Author:  Alex McColm
// Date:    February 7th, 2022
// Course: CPS 101
//
// PROBLEM STATEMENT: This class groups all the N^2 efficiency
// sorting algorithms together in the form of static methods
// to be used by the test driver.
//
// INPUT: Contains static methods which may be passed arrays to sort.
//
// OUTPUT: Sorts arrays in place.
// *************************************************

public class QuadraticSortAlgorithms {
    // **************************************************************
    // Method: bubbleSort
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    //
    // Return Value: Sorts the array in place.
    //
    // Sorts the array in place with Bubble Sort.
    public static void bubbleSort(int[] array) {
        // Declare counter variables and the holder variable for swaps
        int i;
        int j;
        int temp;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1] ) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } 
            }
        }
    }
    // **************************************************************
    // Method: selectionSort
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    //
    // Return Value: Sorts the array in place.
    //
    // Sorts the array in place with Selection Sort.
    public static void selectionSort(int[] array) {
        // TODO: Selection Sort
        for (int i = 0; i < array.length - 1; i++) {
            // Find index of smallest remaining element
            int indexSmallest = i;
            for (int j = i + 1; j < array.length; j++) {
               if (array[j] < array[indexSmallest]) {
                  indexSmallest = j;
               }
            }
            
            // Swap array[i] and array[indexSmallest]
            int temp = array[i];
            array[i] = array[indexSmallest];
            array[indexSmallest] = temp;
         }
    }
    // **************************************************************
    // Method: insertionSort
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    //
    // Return Value: Sorts the array in place.
    //
    // Sorts the array in place with Selection Sort.
    public static void insertionSort(int[] array) {
        // TODO: Insertion Sort
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
               // Swap array[j] and array [j - 1]
               int temp = array[j];
               array[j] = array[j - 1];
               array[j - 1] = temp;
               j--;
            }
         }
    } 
}