package com.A3AlexMcColm;

import java.util.Random;

/* *************************************************
 * File: OrderedListApp
 * Author: Alex McColm
 * Date: Feb 18th 2022
 * Course: CPS 101
 * 
 * PROBLEM STATMENT:Create a class titled OrderedListApp. 
 * In the main() method of this class do the following:
 * Create an ordered list of Integers. Add 5 random integers 
 * to the list, then display the list content.
 * Create an ordered list of String type. Add 5 unordered 
 * strings to the list, then display the list content.
 * 
 * INPUT: None
 * OUTPUT: Main method prints test results to console.
 * 
 * ************************************************* */

public class OrderedListApp {
    public static void main(String[] args) { 
        // Set up Random and OrderedDLinkedList objects
        Random rand = new Random();
        OrderedDLinkedList<Integer> integerList = new OrderedDLinkedList<>();
        OrderedDLinkedList<String> stringList = new OrderedDLinkedList<>();

        // Declare values to be added to nodes
        int num;
        String str;
        
        // Declare nodes to be added to lists
        Node<Integer> intNode;
        Node<String> strNode;
        
        // 5 unordered words to add to list
        String[] strings = {"Xenophobe", "Board", "Apple", "Carp", "Deal"};

        // Add all 5 integers
        System.out.print("Values are added in this sequence: ");
        for (int i = 0; i < 5; ++i) {
            num = rand.nextInt(1000);
            intNode = new Node<Integer>(num);
            integerList.add(intNode);
            System.out.print(num + " ");
        }
        
        System.out.println("\nOrdered List:");
        integerList.printList();
        System.out.println();

        // Add all 5 strings
        System.out.print("Values are added in this sequence: ");
        for (int i = 0; i < 5; ++i) {
            str = strings[i];
            strNode = new Node<String>(str);
            stringList.add(strNode);
            System.out.print(str + ", ");
        }

        System.out.println("\nOrdered List:");
        stringList.printList();
        System.out.println();

        /* The test will remove a couple integers.
           Specifically, it will remove the second, and the fourth.
        */
        Node<Integer> firstIntegerRemove = integerList.tail.previous;
        Node<Integer> secondIntegerRemove = integerList.head.next;

        System.out.println("These integers will be removed from the integer list: " +
        firstIntegerRemove.data.toString() + " and " + secondIntegerRemove.data.toString());
        integerList.remove(firstIntegerRemove);
        integerList.remove(secondIntegerRemove);
        System.out.println("Integer list after values are removed:");
        integerList.printList();

        /* The test will remove a couple strings.
           Specifically, it will remove the second and third.
        */

        Node<String> firstStringRemove = stringList.head.next;
        Node<String> secondStringRemove = firstStringRemove.next;

        System.out.println("These strings will be removed from the string list: " + firstStringRemove.data + " and " + secondStringRemove.data);
        stringList.remove(firstStringRemove);
        stringList.remove(secondStringRemove);
        System.out.println("String list after values are removed:");
        stringList.printList();
    }
}
