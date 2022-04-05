package com.A4AlexMcColm;

/* **********************************************************
 * File: GenericStack.java
 * 
 * Author: Alex McColm
 * 
 * Date: March 4th 2022
 * 
 * Problem statement: Reference zyDE 6.5.1: Stack and Queue 
 * data structures to implement a generic Stack and generic 
 * Queue so that they can be used to create a stack or queue 
 * of any reference data type such as Integer, String, etc. 
 * You may use a modified SinglyLinkedList or the generic 
 * DoublyLinkedList class you created in the last assignment
 * as the underlying container for the Stack and Queue 
 * classes.
 * 
 * Desc: Generic Stack implementation used elsewhere in the 
 * project. 
 * **********************************************************/
public class GenericStack <T extends Comparable<T>> {
   private DoublyLinkedList<T> linkedList;
   
   // Constructor
   GenericStack() {
      linkedList = new DoublyLinkedList<T>();
   }
   
   /* Method: push
    *
    * Input: T (whichever type was chosen)
    *
    * Output: None
    * 
    * Desc: Puts item on top of stack */
   public void push(T newData) {
      // Create a new node and prepend
      Node<T> newNode = new Node<>(newData);
      linkedList.prepend(newNode);
   }
   
   /* Method: pop
    * Input: none
    * Output: T, item at the top of the stack */
   public T pop() {
      // Copy list head's data
      T poppedItem = linkedList.getHeadData();
       
      // Remove list head
      linkedList.removeAfter(null);
       
      // Return popped item
      return poppedItem;
   }

   /* Method: print
    *
    * Input: none
    * 
    * Output: prints list to terminal*/ 
   public void print() {
      linkedList.printList();
   }
   
   /* Method: isEmpty
    * 
    * Input: none
    * 
    * Output: Boolean of whether the Stack is empty. */
   public boolean isEmpty() {
      return linkedList.head == null;
   }
}
