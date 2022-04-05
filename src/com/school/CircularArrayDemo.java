package com.school;
// Java program to demonstrate use of circular
// array using extra memory space
//import java.util.*;
//import java.lang.*;

public class CircularArrayDemo {
	
	// function to print circular list
	// starting from given index ind.
	public static void print(char a[], int n,
								int ind){
		
		// print from ind-th index to
		// (n+i)th index.
		for (int i = ind; i < n + ind; i++) {
			System.out.print(a[(i % n)] + " ");
            System.out.println(i + "%" + n + " = "+ i % n);
        }
	}
	
	// driver code
	public static void main(String argc[]){
		char[] a = new char[]{ 'A', 'B', 'C',
							};
		int n = 3;
		print(a, n, 2);
	}
}

/* This code is contributed by Sagar Shukla */
