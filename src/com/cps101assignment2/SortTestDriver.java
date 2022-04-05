package com.cps101assignment2;

// ************************************************
// File:    SortTestDriver
// Author:  Alex McColm
// Date:    February 7th, 2022
// Course: CPS 101
//
// PROBLEM STATEMENT: Write an application to empirically test 
// the performance efficiency of at least two quadratic sort algorithms 
// (O(N2) and two logarithmic algorithms (O(N*logN). You may use the 
// algorithms' Java implementations presented in chapters 3 and 4 directly or 
// group the quadratic and logarithmic algorithms into one or two classes and 
// write a driver class to do the test.
//
// INPUT: Takes no user input. The functionality test generates an array with
// a  small, fixed number of elements with 2 and 5 digits. The Big O test generates
// arrays of increasing sizes, by increments of 20,000 elements, until the C value
// stabilizes.
//
// OUTPUT: This program displays on screen the following:
// a) A small array before and after being sorted by:
//    i.   Bubble Sort
//    ii.  Selection Sort
//    iii. Insertion Sort
//    iv.  Quick Sort
//    v.   Radix Sort
// b) Much larger arrays, growing in size until C is stable, sorted by the same 
// algorithms, except not by Bubble Sort due to its unreasonable runtime.
// *************************************************

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


public class SortTestDriver {
    // **************************************************************
    // Method: getRandomInt
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    //
    // Return Value: a random integer n such that 0 > n > max.
    public static int getRandomInt(int max, Random rand) {
        return rand.nextInt(max);
    }
    
    // **************************************************************
    // Method: populateArray
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be assigned many integers in place
    // Return Value: None, but manipulates an array in place.
    //
    // Fills the array with as many random integers as it has the capacity
    // for.
    public static void populateArray(int max, Random rand, int[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = getRandomInt(max, rand);
        }
    }
    
    // **************************************************************
    // Method: bubbleSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with Bubble Sort. Takes an extremely long time.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float bubbleSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== Bubble Sort Test ====
        // Grab the time when the bubbleSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        QuadraticSortAlgorithms.bubbleSort(array);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        //System.out.println("Bubble Sort of " + array.length + " elements" +
        //" completed in " + totalRuntime + " nanoseconds.");
        //System.out.println("C = " + ((float)totalRuntime) / ((float)array.length * array.length));
        float c = ((float)totalRuntime) / ((float)array.length * array.length);
        if (printDetails) { System.out.println("Array Size: " + array.length + "; time used: " + totalRuntime + "ns; C: " + c); };
        return c;
    }
    
    // **************************************************************
    // Method: selectionSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with Selection Sort.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float selectionSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== Selection Sort Test ====
        // Grab the time when the bubbleSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        QuadraticSortAlgorithms.selectionSort(array);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        float c = ((float)totalRuntime) / ((float)array.length * array.length);
        if (printDetails) { System.out.println("Array Size: " + array.length + "; time used: " + totalRuntime + "ns; C: " + c); }
        return c;
    }
    
    // **************************************************************
    // Method: insertionSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with Insertion Sort.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float insertionSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== Insertion Sort Test ==== 
        // Grab the time when the bubbleSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        QuadraticSortAlgorithms.insertionSort(array);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        float c = ((float)totalRuntime) / ((float)array.length * array.length);
        if (printDetails) { System.out.println("Array Size: " + array.length + "; time used: " + totalRuntime + "ns; C: " + c); }
        return c;
    }
    
    // **************************************************************
    // Method: quickSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with Quick Sort.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float quickSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== quick Sort Test ==== 
        // Grab the time when the quickSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        LinearithmicSortAlgorithms.quickSort(array, 0, array.length - 1);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        float c = (float) (((float)totalRuntime) / ((float)array.length * Math.log10(array.length)));
        if (printDetails) { System.out.println("Array Size:" + array.length + "; time used: " + totalRuntime + " ns. C = " + c); }
        return c;
    }

        // **************************************************************
    // Method: improvedQuickSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with an improved version of Quick Sort.
    // Quicksort is improved as follows:
    // - Calls insertion sort when partition is smaller than 7 elements.
    // - uses a pivot value which is the average of first, middle, last element.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float improvedQuickSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== quick Sort Test ==== 
        // Grab the time when the quickSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        LinearithmicSortAlgorithms.improvedQuickSort(array, 0, array.length - 1);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        float c = (float) (((float)totalRuntime) / ((float)array.length * Math.log10(array.length)));
        if (printDetails) { System.out.println("Array Size:" + array.length + "; time used: " + totalRuntime + " ns. C = " + c); }
        return c;
    }
    
    // **************************************************************
    // Method: mergeSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with Merge Sort.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float mergeSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== MergeSort Test ====
        // Grab the time when the bubbleSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        LinearithmicSortAlgorithms.mergeSort(array, 0, array.length - 1);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        float c = (float) (((float)totalRuntime) / ((float)array.length * Math.log10(array.length)));
        if (printDetails) { System.out.println("Array Size:" + array.length + "; time used: " + totalRuntime + " ns. C = " + c); }
        return c;
    }
    
    // **************************************************************
    // Method: radixSortTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // - Random rand - The random object used to populate the array with ints
    // - int[] array - The array to be sorted in place
    // - boolean printDetail - Boolean value tells the method whether to print 
    // information to console or not.          
    // Return Value: Value of C in the form of a float.
    //
    // Sorts the array in place with Radix Sort.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static float radixSortTest(int max, Random rand, int[] array, boolean printDetails) {
        long startTime;
        long completionTime;
        long totalRuntime;
        // ==== MergeSort Test ====
        // Grab the time when the bubbleSort starts
        startTime = System.nanoTime();
        // Execute bubble sort on the testArray
        LinearithmicSortAlgorithms.mergeSort(array, 0, array.length - 1);
        // Grab the time when the bubbleSort completes
        completionTime = System.nanoTime();
        totalRuntime = completionTime - startTime;
        float c = (float) (((float)totalRuntime) / ((float)array.length * Math.log10(array.length)));
        if (printDetails) { System.out.println("Array Size:" + array.length + "; time used: " + totalRuntime + " ns. C = " + c); }
        return c;
    }
    
    // **************************************************************
    // Method: bigArraysTest()
    //
    // Parameters: none
    // Return Value: none, but prints detailed information
    //
    // A series of while loops and variable assignments follow this
    // general pattern:
    // 1. Set up variables for the next algorithm test.
    // 2. While loop: As long as C is unstable, call the sorting algorithm 
    // on arrays with more and more elements.
    // This general pattern repeats for Selection, Insertion, Quick, 
    // Improved Quick, Merge,
    // and Radix Sort. 
    // **************************************************************
    public static void bigArraysTest() {
        //int i;
        int max = 10000;
        Random rand = new Random(1);
        int[] testArray;

        float lastC;
        float newC;
        float difference;
        float threshold = 10.0f;

        System.out.println("\nSelection Sort:");
        lastC = 0.0f;
        newC = 0.0f;
        int k = 1;
        ArrayList<Float> cDifferenceList = new ArrayList<Float>();
        boolean cStable = false;
        while (!cStable) {
            testArray = new int[k * 20000];
            populateArray(max, rand, testArray);
            if (k > 1) {
                newC = selectionSortTest(max, rand, testArray, true);
                difference = ((Math.abs(lastC - newC))/((lastC + newC)/2)) * 100;
                System.out.println("The difference between the last two values of C is: " + difference + "%");
                // Adding primitive float type to ArrayList containing wrapper class Float elements.
                // It will autobox. 
                cDifferenceList.add(difference);
                lastC = newC;
            } else {
                newC = selectionSortTest(max, rand, testArray, true);
                lastC = newC;
            }
            // Check if the last 3 C differences were all less than 3.0%. If so, C is stable, and the condition to end the loop is satisfied.
            if (cDifferenceList.size() >=3) {
                if ((cDifferenceList.get(cDifferenceList.size() - 1) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 2) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 3) < threshold)) {
                    cStable = true;
                    System.out.println("C is found to be stable.");
                }
            }
            k++;
        }


        System.out.println("\nInsertion Sort:");
        lastC = 0.0f;
        newC = 0.0f;
        k = 1;
        cDifferenceList = new ArrayList<Float>();
        cStable = false;
        while (!cStable) {
            testArray = new int[k * 20000];
            populateArray(max, rand, testArray);
            if (k > 1) {
                newC = insertionSortTest(max, rand, testArray, true);
                difference = ((Math.abs(lastC - newC))/((lastC + newC)/2)) * 100;
                System.out.println("The difference between the last two values of C is: " + difference + "%");
                // Adding primitive float type to ArrayList containing wrapper class Float elements.
                // It will autobox. 
                cDifferenceList.add(difference);
                lastC = newC;
            } else {
                newC = insertionSortTest(max, rand, testArray, true);
                lastC = newC;
            }
            // Check if the last 3 C differences were all less than 3.0%. If so, C is stable, and the condition to end the loop is satisfied.
            if (cDifferenceList.size() >=3) {
                if ((cDifferenceList.get(cDifferenceList.size() - 1) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 2) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 3) < threshold)) {
                    cStable = true;
                    System.out.println("C is found to be stable.");
                }
            }
            k++;
        }

        System.out.println("\nQuick Sort:");
        lastC = 0.0f;
        newC = 0.0f;
        k = 1;
        cDifferenceList = new ArrayList<Float>();
        cStable = false;
        while (!cStable) {
            testArray = new int[k * 20000];
            populateArray(max, rand, testArray);
            if (k > 1) {
                newC = quickSortTest(max, rand, testArray, true);
                difference = ((Math.abs(lastC - newC))/((lastC + newC)/2)) * 100;
                System.out.println("The difference between the last two values of C is: " + difference + "%");
                // Adding primitive float type to ArrayList containing wrapper class Float elements.
                // It will autobox. 
                cDifferenceList.add(difference);
                lastC = newC;
            } else {
                newC = quickSortTest(max, rand, testArray, true);
                lastC = newC;
            }
            // Check if the last 3 C differences were all less than 3.0%. If so, C is stable, and the condition to end the loop is satisfied.
            if (cDifferenceList.size() >=3) {
                if ((cDifferenceList.get(cDifferenceList.size() - 1) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 2) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 3) < threshold)) {
                    cStable = true;
                    System.out.println("C is found to be stable.");
                }
            }
            k++;
        }

        System.out.println("\nImproved Quick Sort:");
        lastC = 0.0f;
        newC = 0.0f;
        k = 1;
        cDifferenceList = new ArrayList<Float>();
        cStable = false;
        while (!cStable) {
            testArray = new int[k * 20000];
            populateArray(max, rand, testArray);
            if (k > 1) {
                newC = improvedQuickSortTest(max, rand, testArray, true);
                difference = ((Math.abs(lastC - newC))/((lastC + newC)/2)) * 100;
                System.out.println("The difference between the last two values of C is: " + difference + "%");
                // Adding primitive float type to ArrayList containing wrapper class Float elements.
                // It will autobox. 
                cDifferenceList.add(difference);
                lastC = newC;
            } else {
                newC = quickSortTest(max, rand, testArray, true);
                lastC = newC;
            }
            // Check if the last 3 C differences were all less than 3.0%. If so, C is stable, and the condition to end the loop is satisfied.
            if (cDifferenceList.size() >=3) {
                if ((cDifferenceList.get(cDifferenceList.size() - 1) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 2) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 3) < threshold)) {
                    cStable = true;
                    System.out.println("C is found to be stable.");
                }
            }
            k++;
        }

        System.out.println("\nMerge Sort:");
        lastC = 0.0f;
        newC = 0.0f;
        k = 1;
        cDifferenceList = new ArrayList<Float>();
        cStable = false;
        while (!cStable) {
            testArray = new int[k * 20000];
            populateArray(max, rand, testArray);
            if (k > 1) {
                newC = mergeSortTest(max, rand, testArray, true);
                difference = ((Math.abs(lastC - newC))/((lastC + newC)/2)) * 100;
                System.out.println("The difference between the last two values of C is: " + difference + "%");
                // Adding primitive float type to ArrayList containing wrapper class Float elements.
                // It will autobox. 
                cDifferenceList.add(difference);
                lastC = newC;
            } else {
                newC = mergeSortTest(max, rand, testArray, true);
                lastC = newC;
            }
            // Check if the last 3 C differences were all less than 3.0%. If so, C is stable, and the condition to end the loop is satisfied.
            if (cDifferenceList.size() >=3) {
                if ((cDifferenceList.get(cDifferenceList.size() - 1) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 2) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 3) < threshold)) {
                    cStable = true;
                    System.out.println("C is found to be stable.");
                }
            }
            k++;
        }
        System.out.println("\nRadix Sort:");
        lastC = 0.0f;
        newC = 0.0f;
        k = 1;
        cDifferenceList = new ArrayList<Float>();
        cStable = false;
        while (!cStable) {
            testArray = new int[k * 20000];
            populateArray(max, rand, testArray);
            if (k > 1) {
                newC = radixSortTest(max, rand, testArray, true);
                difference = ((Math.abs(lastC - newC))/((lastC + newC)/2)) * 100;
                System.out.println("The difference between the last two values of C is: " + difference + "%");
                // Adding primitive float type to ArrayList containing wrapper class Float elements.
                // It will autobox. 
                cDifferenceList.add(difference);
                lastC = newC;
            } else {
                newC = radixSortTest(max, rand, testArray, true);
                lastC = newC;
            }
            // Check if the last 3 C differences were all less than 3.0%. If so, C is stable, and the condition to end the loop is satisfied.
            if (cDifferenceList.size() >=3) {
                if ((cDifferenceList.get(cDifferenceList.size() - 1) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 2) < threshold) &&
                    (cDifferenceList.get(cDifferenceList.size() - 3) < threshold)) {
                    cStable = true;
                    System.out.println("C is found to be stable.");
                }
            }
            k++;
        }
    }
    
    // **************************************************************
    // Method: functionalityTest
    //
    // Parameters: 
    // - int max - The largest possible integer an array element may be
    // Return Value: 
    //
    // Sorts the array in place with Bubble Sort. Takes an extremely long time.
    // If printDetail is enabled (passed a true boolean), this method will also
    // print total runtime in nanoseconds and C value.
    public static void functionalityTest(int max) {
        int[] testArray = new int[20];
        Random rand = new Random();
        populateArray(max, rand, testArray);
        
        System.out.println("Before Bubble Sort:");
        System.out.println(Arrays.toString(testArray));
        int[] cloneArray = testArray.clone();
        bubbleSortTest(max, rand, cloneArray, false);
        System.out.println("After Bubble Sort:\n" + Arrays.toString(cloneArray)); 

        //populateArray(max, rand, testArray);
        System.out.println("Before Selection Sort:");
        System.out.println(Arrays.toString(testArray));
        cloneArray = testArray.clone();
        selectionSortTest(max, rand, cloneArray, false);
        System.out.println("After Selection Sort:\n" + Arrays.toString(cloneArray)); 

        //populateArray(max, rand, testArray);
        System.out.println("Before Insertion Sort:");
        System.out.println(Arrays.toString(testArray));
        cloneArray = testArray.clone();
        insertionSortTest(max, rand, cloneArray, false);
        System.out.println("After Insertion Sort:\n" + Arrays.toString(cloneArray)); 

        //populateArray(max, rand, testArray);
        System.out.println("Before Quick Sort:");
        System.out.println(Arrays.toString(testArray));
        cloneArray = testArray.clone();
        quickSortTest(max, rand, cloneArray, false);
        System.out.println("After Quick Sort:\n" + Arrays.toString(cloneArray)); 

        //populateArray(max, rand, testArray);
        System.out.println("Before Merge Sort:");
        System.out.println(Arrays.toString(testArray));
        cloneArray = testArray.clone();
        mergeSortTest(max, rand, cloneArray, false);
        System.out.println("After Merge Sort:\n" + Arrays.toString(cloneArray)); 

        //populateArray(max, rand, testArray);
        System.out.println("Before Radix Sort:");
        System.out.println(Arrays.toString(testArray));
        cloneArray = testArray.clone();
        radixSortTest(max, rand, cloneArray, false);
        System.out.println("After Radix Sort:\n" + Arrays.toString(cloneArray)); 
    }
    
    // **************************************************************
    // Method: main
    //
    // Parameters: String[] args is the array holding command line
    // parameters
    //
    // Return Value: none
    //
    // 1) Announce the functionality test with 2 digit numbers.
    // 2) Call the functionalityTest static method, which will print
    // full results.
    // 3) Announce the functionality test with 5 digit numbers.
    // 4) Same as step 2, call the functionalityTest static method,
    // printing full results.
    // 5) Announce the Big O test.
    // 6) Call the bigArraysTest static method, which will take a
    // couple minutes, and print full results of the test. 
    // **************************************************************
    public static void main(String[] args) {
        System.out.println("========= Checking if the algorithms work with an array of 20 2-digit random integers. =========");
        // Run the functionality test with 2-digit integers.
        functionalityTest(100);
        System.out.println("\n========= Checking if the algorithms work with an array of 20 5-digit random integers. =========");
        // Run the functionality test with 5-digit integers.
        functionalityTest(100000);
        System.out.println("\n========= Conducting the Big O test, with very large, growing array sizes. =========");
        // Run the Big-O test. The moment of truth!
        bigArraysTest();    
    }
}
