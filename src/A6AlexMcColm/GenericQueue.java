package A6AlexMcColm;

/* **********************************************************
 * File: GenericQueue.java
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
 * Desc: Generic Queue implementation used elsewhere in the 
 * project. 
 * **********************************************************/
public class GenericQueue<T extends Comparable<T>> {
   private DoublyLinkedList<T> linkedList;
   
   // Constructor
   GenericQueue() {
      linkedList = new DoublyLinkedList<>();
   }
    
   /* Method: enqueue
    *
    * Input: T - data to be added to 
    * back of queue
    * 
    * Output: none*/
   public void enqueue(T newData) {
      // Create a new node with given data
      LinkedListNode<T> newNode = new LinkedListNode<T>(newData);
        
      // Insert as list tail (end of queue)
      linkedList.append(newNode);
   }
    
   /* Method: dequeue
    * 
    * Input: none
    * 
    * Output: T - Data from item at front 
    * of queue */
   public T dequeue() {
      // Copy list head's data
      T dequeuedItem = linkedList.getHeadData();
       
      // Remove list head
      linkedList.removeAfter(null);
       
      // Return dequeued item
      return dequeuedItem;
   }
   
   /* Method: print
    * 
    * Input: None
    *
    * Output: Prints to terminal */
   public void print() {
      linkedList.printList();
   }

   /* Method: isEmpty
    * 
    * Input: none
    *
    * Output: boolean - whether queue is empty */
   public boolean isEmpty() {
      return linkedList.head == null;
   }
}