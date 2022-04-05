package com.school;

public class FindPerimeter {
    public static int perimeter(int arr[]) {
        int perimeter = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            perimeter += arr[i];
        }
        return perimeter;
    }
    public static void main(String[] args) {
        int sides[] = {1,3,4,5};
        try {
            System.out.println("Perimeter for given sides is " + perimeter(sides));
        }
        catch (Exception excpt) {
            System.out.println("Caught Exception: " + excpt.getMessage());
        }
        finally{
            System.out.println("End");
        }
    }
}