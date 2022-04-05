package com.cps101assignment2;

// ************************************************
// File:    LinearithmicSortAlgorithms
// Author:  Alex McColm
// Date:    February 7th, 2022
// Course: CPS 101
//
// PROBLEM STATEMENT: This class groups all the N*LogN efficiency sorting
// algorithms into one place in the form of static methods  for the test 
// driver to use.
//
// INPUT: Contains static methods which may be passed arrays to sort.
//
// OUTPUT: Sorts arrays in place.
// *************************************************

import java.util.ArrayList;

public class LinearithmicSortAlgorithms {
    // **************************************************************
    // Method: partition
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // - int startIndex - The left endpoint of the array or sublist in the 
    // array
    // - int endIndex - The right endpoint of the array or sublist in the 
    // array
    // Return Value: The high point of the sub-array
    // Partitioning algorithm used by Quick Sort.
    private static int partition(int[] array, int startIndex, int endIndex) {
        // Select the middle value as the pivot.
        int midpoint = startIndex + (endIndex - startIndex) / 2;
        int pivot = array[midpoint];
     
        // "low" and "high" start at the ends of the array segment
        // and move towards each other.
        int low = startIndex;
        int high = endIndex;
     
        boolean done = false;
        while (!done) {
           // Increment low while array[low] < pivot
           while (array[low] < pivot) {
              low = low + 1;
           }
        
           // Decrement high while pivot < array[high]
           while (pivot < array[high]) {
              high = high - 1;
           }
        
           // If low and high have crossed each other, the loop
           // is done. If not, the elements are swapped, low is
           // incremented and high is decremented.
           if (low >= high) {
              done = true;
           }
           else {
              int temp = array[low];
              array[low] = array[high];
              array[high] = temp;
              low++;
              high--;
           }
        }
  
        // "high" is the last index in the left segment.
        return high;
    }
    
    // **************************************************************
    // Method: quickSort
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // - int startIndex - The left endpoint of the array or sublist in the 
    // array
    // - int endIndex - The right endpoint of the array or sublist in the 
    // array
    // Return Value: Sorts array in place.
    // Recursive implementation of Quick Sort.
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        // Quick Sort
        // Only attempt to sort the array segment if there are
        // at least 2 elements
        if (endIndex <= startIndex) {
            return;
        }
         
        // Partition the array segment
        int high = partition(array, startIndex, endIndex);

        // Recursively sort the left segment
        quickSort(array, startIndex, high);

        // Recursively sort the right segment
        quickSort(array, high + 1, endIndex);
    }
    
    // **************************************************************
    // Method: improvedPartition
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // - int startIndex - The left endpoint of the array or sublist in the 
    // array
    // - int endIndex - The right endpoint of the array or sublist in the 
    // array
    // Return Value: The high point of the sub-array
    // Partitioning algorithm used by Improved Quick Sort. Has been altered
    // to take the average of first, middle, and last values and then use
    // that value as the pivot rather than using just the middle value.
    private static int improvedPartition(int[] array, int startIndex, int endIndex) {
        // Select the middle value as the pivot.
        int midpoint = startIndex + (endIndex - startIndex) / 2;
        int averagePoints = (array[startIndex] + array[midpoint] + array[endIndex]) / 3;
        int pivot = averagePoints;
        // "low" and "high" start at the ends of the array segment
        // and move towards each other.
        int low = startIndex;
        int high = endIndex;
     
        boolean done = false;
        while (!done) {
           // Increment low while array[low] < pivot
           while (array[low] < pivot) {
              low = low + 1;
           }
        
           // Decrement high while pivot < array[high]
           while (pivot < array[high]) {
              high = high - 1;
           }
        
           // If low and high have crossed each other, the loop
           // is done. If not, the elements are swapped, low is
           // incremented and high is decremented.
           if (low >= high) {
              done = true;
           }
           else {
              int temp = array[low];
              array[low] = array[high];
              array[high] = temp;
              low++;
              high--;
           }
        }
  
        // "high" is the last index in the left segment.
        return high;
    }
    
    // **************************************************************
    // Method: improvedQuickSort
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // - int startIndex - The left endpoint of the array or sublist in the 
    // array
    // - int endIndex - The right endpoint of the array or sublist in the 
    // array
    // Return Value: Sorts array in place.
    // Recursive implementation of Quick Sort with improvements.
    public static void improvedQuickSort(int[] array, int startIndex, int endIndex) {
        /*if (endIndex <= startIndex) {
            return;
        }*/
        // When the data to be partitioned is 7 elements or fewer, call insertion sort instead.
        if ((endIndex - startIndex) <=7) {
            QuadraticSortAlgorithms.insertionSort(array);
            return;
        }
         
        // Partition the array segment
        int high = improvedPartition(array, startIndex, endIndex);

        // Recursively sort the left segment
        improvedQuickSort(array, startIndex, high);

        // Recursively sort the right segment
        improvedQuickSort(array, high + 1, endIndex);
    }
    // **************************************************************
    // Method: merge
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // - int i - Start index of first sorted partition
    // - int j - End index of first sorted partition
    // - int k - End index of second sorted partition
    // Return Value: Performs part of a sorting in place.
    // Algorithm used to merge 2 sequential partitions by Merge Sort.
    private static void merge(int[] array, int i, int j, int k) {
        int mergedSize = k - i + 1;                // Size of merged partition
        int[] mergedNumbers = new int[mergedSize]; // Dynamically allocates temporary
                                                   // array for merged array
        int mergePos = 0;                          // Position to insert merged number
        int leftPos = i;                           // Initialize left partition position
        int rightPos = j + 1;                      // Initialize right partition position
        
        // Add smallest element from left or right partition to merged array
        while (leftPos <= j && rightPos <= k) {
           if (array[leftPos] <= array[rightPos]) {
              mergedNumbers[mergePos] = array[leftPos];
              leftPos++;
           }
           else {
              mergedNumbers[mergePos] = array[rightPos];
              rightPos++;
           }
           mergePos++;
        }
        
        // If left partition is not empty, add remaining elements to merged array
        while (leftPos <= j) {
           mergedNumbers[mergePos] = array[leftPos];
           leftPos++;
           mergePos++;
        }
     
        // If right partition is not empty, add remaining elements to merged array
        while (rightPos <= k) {
           mergedNumbers[mergePos] = array[rightPos];
           rightPos++;
           mergePos++;
        }
     
        // Copy merged array back to array
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
           array[i + mergePos] = mergedNumbers[mergePos];
        }
     }
     
    // **************************************************************
    // Method: mergeSort()
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // - int i - Start index of partition being sorted
    // - int k - End index of partition being sorted
    // Return Value: Sorts an array in place. 
    // Recursive implementation of Merge Sort.
    public static void mergeSort(int[] array, int i, int k) {
        int j = 0;
      
      if (i < k) {
         j = (i + k) / 2;  // Find the midpoint in the partition

         // Recursively sort left and right partitions
         mergeSort(array, i, j);
         mergeSort(array, j + 1, k);
            
         // Merge left and right partition in sorted order
         merge(array, i, j, k);
      }
    }
    // **************************************************************
    // Method: radixGetMaxLength
    //
    // Parameters: 
    // - int[] array - The array to be examined
    // Return Value: 
    // int - the longest digit length present in the array.
    //
    // Returns the maximum length, in number of digits, out of all 
    // array elements.
    public static int radixGetMaxLength(int[] array) {
        int maxDigits = 0;
        for (int i = 0; i < array.length; i++) {
            int digitCount = radixGetLength(array[i]);
            
            if (digitCount > maxDigits) {
                maxDigits = digitCount;
            }
        }
        return maxDigits;
    }
    // **************************************************************
    // Method: radixGetLength
    //
    // Parameters: 
    // - int value - The array to be examined
    // Return Value: 
    // - int - the digit length of the parameter 'value' which was
    // examined.
    //
    // Returns the maximum length, in number of digits, of a single
    // integer.
    public static int radixGetLength(int value) {
        if (value == 0) {
            return 1;
        }
    
        int digits = 0;

        while (value != 0) {
            digits++;
            value /= 10;
        }
    return digits;
    }
    
    // **************************************************************
    // Method: radixSort
    //
    // Parameters: 
    // - int[] array - The array to be sorted in place
    // Return Value:
    // - Array is sorted in place.
    //
    // Sorts in place using Radix Sort, the fast sorting
    // algorithm which exploits the base-10 number system, and uses
    // the concept of "buckets"!
    public static void radixSort(int[] array) {
            // TODO: Radix Sort
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        
        int copyBackIndex = 0;
        
        // Find the max length, in number of digits
        int maxDigits = radixGetMaxLength(array);
        
        int pow10 = 1;
        for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
            for (int i = 0; i < array.length; i++) {
                int num = array[i];
                int bucketIndex = (Math.abs(num) / pow10) % 10;
                buckets.get(bucketIndex).add(num);
            }
            
            // Copy buckets back into array array
            copyBackIndex = 0;
            for (int i = 0; i < 10; i++) {
                ArrayList<Integer> bucket = buckets.get(i);
                for (int j = 0; j < bucket.size(); j++) {
                array[copyBackIndex] = bucket.get(j);
                copyBackIndex++;
                }
                bucket.clear();
            }
            
            pow10 *= 10;
        }
        
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        ArrayList<Integer> nonNegatives = new ArrayList<Integer>();
        for (int num : array) {
            if (num < 0) {
                negatives.add(num);
            }
            else {
                nonNegatives.add(num);
            }
        }
        
        // Copy sorted content to array - negatives in reverse, then non-negatives
        copyBackIndex = 0;
        for (int i = negatives.size() - 1; i >= 0; i--) {
            array[copyBackIndex] = negatives.get(i);
            copyBackIndex++;
        }
        for (int i = 0; i < nonNegatives.size(); i++) {
            array[copyBackIndex] = nonNegatives.get(i);
            copyBackIndex++;
        }
    }
}