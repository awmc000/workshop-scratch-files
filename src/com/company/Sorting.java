package com.company;

public class Sorting {

    public boolean inOrder(int [] nums) {
        int lastValue = 0;
        boolean inOrder = true;
        for (int currentValue : nums) {
            if (currentValue == nums[0]) {
                lastValue = currentValue;
            } else if (currentValue < lastValue) {
                inOrder = false;
            }
        }
        return inOrder;
    }

    public static void main(String[] args) {
        Sorting s = new Sorting();

        // Test out-of-order example.
        int [] nums1 = {5, 6, 7, 8, 3};

        if(s.inOrder(nums1)){
            System.out.println("In order");
        }else{
            System.out.println("Not in order");
        }

        // Test in-order example.
        int [] nums2 = {5, 6, 7, 8, 10};

        if(s.inOrder(nums2)){
            System.out.println("In order");
        }else{
            System.out.println("Not in order");
        }
    }
}
