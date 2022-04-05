package com.school;

import java.util.Arrays;

public class SelectionSortDemo {
    private static void selectionSort(int[] numArray) {
        for (int i = 0; i < numArray.length - 1; ++i) {
            int indexSmallest = i;
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[j] < numArray[indexSmallest]) {
                    indexSmallest = j;
                
                }
            }
            
            // Where the swap occurs.
            int temp = numArray[i];
            numArray[i] = numArray[indexSmallest];
            numArray[indexSmallest] = temp;
            System.out.println("Sorted: " + Arrays.toString(numArray));
        }
    }

    public static void main(String[] args) {
        int[] numArray = {324, 273, 338, 334, 279};

        System.out.println("Unsorted: " + Arrays.toString(numArray));
        selectionSort(numArray);
        //System.out.println("Sorted: " + Arrays.toString(numArray));
    }
}
