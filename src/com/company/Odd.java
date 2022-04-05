package com.company;

import java.util.Arrays;

public class Odd {

    public int[] removeEvens(int [] nums) {
        /*
        *  A counter of how many odd numbers there are, and a second counter which holds how many have been added to the
        *  array.
        */
        int numOdd = 0;
        int oddAdded = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                numOdd += 1;
            }
        }
        int[] oddArray = new int[numOdd]; /* Length of the array is the number of odd values present, which the first
                                           * for loop counted. */
        for (int i = 0; i < nums.length; ++i) {   //Can use enhanced for loop instead.
            if (nums[i] % 2 != 0) {
                oddArray[oddAdded] = nums[i];
                oddAdded += 1;
            }
        }
        return oddArray;
    }

    public static void main(String[] args) {
        Odd labObject = new Odd();
        int [] input = {1,2,3,4,5,6,7,8,9};
        int [] result = labObject.removeEvens(input);

        // Helper method Arrays.toString() converts int[] to a String
        System.out.println(Arrays.toString(result)); // Should print [1, 3, 5, 7, 9]
    }
}
