package com.A4AlexMcColm;

import java.util.Scanner;

/* File: PalindromeApp
 *
 * Author: Alex McColm
 * 
 * Date: March 4th 2022
 * 
 * Problem Statement: Create a new application or add a new method 
 * to the existing application to assess if a string 
 * is a palindrome, with the assistance of a stack 
 * and a queue. 
 * 
 * Description: Contains static methods needed to perform 
 * a post-fix evaluation of an expression given as a string
 * with operands and operators separated by spaces.
 */

public class PalindromeApp {

    /* Method: checkPalindrome
     * 
     * Input: String
     * 
     * Output: Boolean indicating whether the String
     * given is a palindrome or not.
     * 
     * Desc: Determines whether the string is a 
     * palindrome or not like this:
     * 1. Put the first half of the string in a stack.
     * 2. Put the same first half of the string in a queue.
     * 3. Form a "guess" by making a string of stack and queue 
     * contents.
     * 4. If 我这儿会写汉字
     */
    public static boolean checkPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[!. _,'@?//s]", "");
        GenericStack<Character> charStack = new GenericStack<>();
        GenericQueue<Character> charQueue = new GenericQueue<>();
        for (int i = 0; i < str.length() / 2; ++i) {
            charQueue.enqueue(str.charAt(i));
            charStack.push(str.charAt(i));
        }
        if (str.length() % 2 != 0) { charStack.push(str.charAt(str.length() / 2)); }
        String guessStr = "";
        while (!charQueue.isEmpty()) {
            guessStr += charQueue.dequeue();
        }
        while (!charStack.isEmpty()) {
            guessStr += charStack.pop();
        }
        System.out.println(guessStr);
        if (guessStr.equals(str)) { return true; }
        return false;
    }
    /* Method: main
     * 
     * Input: String[] (runtime arguments)
     * 
     * Output: Prints to the terminal
     * 
     * Desc: Takes user input. If input is any 
     * string besides "-1", print whether or not 
     * it is a palindrome. If it *is* -1, exit.
     */
    public static void main(String[] args) {
        boolean cont = true;
        Scanner scnr = new Scanner(System.in);
        String choice = "";
        while (cont) {
            System.out.println("Please enter a phrase, -1 to exit:");
            choice = scnr.next();
            if (choice.equals("-1")) { cont = false; } else {
                if (checkPalindrome(choice)) {
                    System.out.println(choice + " is a palindrome.");
                } else {
                    System.out.println(choice + " is not a palindrome.");
                }
            }
            // Exit if user enters -1
            
        }
        scnr.close();
    }
}
