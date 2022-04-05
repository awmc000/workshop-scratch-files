package com.A4AlexMcColm;

/* *************************************************
 * File: DoublyLinkedList
 * Author: Alex McColm
 * Date: Feb 18th 2022
 * Course: CPS 101
 * 
 * DESCRIPTION: The DoublyLinkedList class as found
 * in the text, with the insertionSort() method also
 * from the text, and the insertBefore method written
 * by me based on the insertAfter method.
 * 
 * INPUT: Can add nodes by passing Node object.
 * OUTPUT: List can be printed.
 * 
 * NOTE: Reused for assignment 4 as the underlying 
 * container for the Stack and Queue.
 * 
 * ************************************************* */

public class DoublyLinkedList<T extends Comparable<T>> {
    protected Node<T> head;
    protected Node<T> tail;
   
    // Constructor: sets head and tail to null
    public DoublyLinkedList() {
       head = null;
       tail = null;
    }
     
   /* Method: append()
    * 
    * Input: Node<T> object
    * 
    * Output: none
    * 
    * Desc: Adds object to end of list.
    */
    public void append(Node<T> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }
   /* Method: prepend()
    * 
    * Input: Node<T> object
    * 
    * Output: none
    * 
    * Desc: Adds object to beginning of list.
    */
    public void prepend(Node<T> newNode) {
       if (head == null) {
          head = newNode;
          tail = newNode;
       }
       else {
          newNode.next = head;
          head.previous = newNode;
          head = newNode;
       }
    }
   /* Method: printList()
    * Input: none
    * Output: none
    * Desc: Prints list on a single line, followed by
    * a newline.
    */
    public void printList() {
       Node<T> node = head;
       while (node != null) {
          System.out.print(node.data + " ");
          node = node.next;
       }
       System.out.println();
    }
   /*
   public void printListBackwards() {
      Node<T> node = tail;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.previous;
      }
      System.out.println();
   }*/
    
   /* Method: insertAfter()
    * 
    * Input: Node<T> objects currentNode
    * and newNode.
    * 
    * Output: none
    * 
    Desc: Places newNode after currentNode in
    * the list.
    */
    public void insertAfter(Node<T> currentNode, Node<T> newNode) {
       if (head == null) {
          head = newNode;
          tail = newNode;
       }
       else if (currentNode.data.compareTo(tail.data) == 0) {
          tail.next = newNode;
          newNode.previous = tail;
          tail = newNode;
       }
       else {
          Node<T> successor = currentNode.next;
          newNode.next = successor;
          newNode.previous = currentNode;
          currentNode.next = newNode;
          successor.previous = newNode;
       }
    }
    

   /* Method: insertBefore()
    * 
    * Input: Node<T> objects currentNode
    * and newNode.
    * 
    * Output: none
    * 
    Desc: Places newNode before currentNode in
    * the list.
    */
    public void insertBefore(Node<T> currentNode, Node<T> newNode) {
      // If the list is empty, make the node the head and tail
      if (head == null) {
         head = newNode;
         tail = newNode;
      } // If the element is being inserted before the head, make it the new head
      else if (currentNode.data.compareTo(head.data) == 0) {
         head.previous = newNode;
         newNode.next = head;
         head = newNode;
      } // If the list is going between existing elements:
      else {
         //----------Node<T> successor = currentNode.next;
         Node<T> predecessor = currentNode.previous;
         newNode.next = currentNode;
         newNode.previous = predecessor;
         currentNode.previous = newNode;
         predecessor.next = newNode;
      }
   }

   /* Method: remove()
    * 
    * Input: Node<T> object currentNode.
    * 
    * Output: none
    * 
    * Desc: Removes currentNode from the list.
    */
   public void remove(Node<T> currentNode) {
      Node<T> successor = currentNode.next;
      Node<T> predecessor = currentNode.previous;
         
      if (successor != null) 
         successor.previous = predecessor;
            
      if (predecessor != null)
         predecessor.next = successor;
            
      if (currentNode.data.compareTo(head.data) == 0)
         head = successor;
            
      if (currentNode.data.compareTo(tail.data) == 0)
         tail = predecessor;
      }

   /* Method: insertionSortDoublyLinked()
    * 
    * Input: none
    * 
    * Output: none
    * 
    * Desc: Sorts list using adapted Insertion 
    * Sort.
    */
    public void insertionSortDoublyLinked() {
      Node<T> currentNode = head.next;
      while (currentNode != null) {
         Node<T> nextNode = currentNode.next;
         Node<T> searchNode = currentNode.previous;
         
         while (searchNode != null && searchNode.data.compareTo(currentNode.data) < 0)
            searchNode = searchNode.previous;
      
         // Remove and re-insert currentNode
         remove(currentNode);
         if (searchNode == null) {
            currentNode.previous = null;
            prepend(currentNode);
         }
         else
            insertAfter(searchNode, currentNode);

         // Advance to next node
         currentNode = nextNode;
      }
   }

   public T getHeadData() {
      return head.data;
   }

   public void removeAfter(Node<T> currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node<T> succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node<T> succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
   }
 }
 
