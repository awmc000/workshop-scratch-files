package com.school;

//import java.lang.Arrays;

public class InsertionSortDemoII {
    public static void insertionSort(int[] nums) {
        int indexSorted = 0;
        int indexUnsorted = 0;
        int temp = 0;
        for (indexSorted = 1; indexSorted < nums.length; ++indexSorted) {
            indexUnsorted = indexSorted;
            // Insert nums[indexSorted] into sorted part
            // Stopping once nums[indexSorted] is in correct position
            while ((indexUnsorted > 0) && (nums[indexUnsorted] < nums[indexUnsorted-1])) {
                // Swap nums[j] and nuums[j - 1]
                temp = nums[indexUnsorted];
                nums[indexUnsorted] = nums[indexUnsorted - 1];
                nums[indexUnsorted - 1] = temp;
                --indexUnsorted;
            }
        }
    }

    public static void main(String[] args) {
        int[] testNumbers = {30, 20, 22, 180, 320, 2, 200, 0, 4, -1};
        //InsertionSortDemoII sorter = new InsertionSortDemoII();
        insertionSort(testNumbers);
        for (int i = 0; i < testNumbers.length; ++i) {
            System.out.print(testNumbers[i] + " ");
        }
    }
}
