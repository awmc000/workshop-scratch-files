package com.A3AlexMcColm;

/* *************************************************
 * File: OrderedDLinkedList
 * Author: Alex McColm
 * Date: Feb 18th 2022
 * Course: CPS 101
 * 
 * PROBLEM STATMENT: Create a class OrderedDLinkedList that 
 * extends the DoublyLinkedList. Other than the inherited 
 * components from the DoublyLinkedList class, the OrderedDLinkedList 
 * also has its own add() method. Implement this method so that it 
 * will add a data element to an OrderedDLinkedList and the data in 
 * the list will be kept in ascending order.
 * 
 * INPUT: Can add nodes by passing Node object OR data of the 
 * parameterized type.
 * OUTPUT: List can be printed.
 * 
 * ************************************************* */

class OrderedDLinkedList<T extends Comparable<T>> extends DoublyLinkedList<T> {
    /* Method: findLarger()
    * 
    * Input: Node<T> newNode
    * 
    * Output: Node<T> 
    * 
    * Desc: Returns the first node in the 
    * linked list which is larger than 
    * newNode.
    */
    public Node<T> findLarger(Node<T> newNode) {
        if (this.head != null) {
            return this.findLargerRecursive(this.head, newNode);
        }
        return null;
    }

    // Private helper method for findLarger.
    private Node<T> findLargerRecursive(Node<T> listNode, Node<T> newNode) {
        if (listNode.data.compareTo(newNode.data) > 0) {
            return listNode;
        } else if (listNode.next != null) {
            return this.findLargerRecursive(listNode.next, newNode);
        } else {
            return null;
        }
    }

    /* Method: oldAdd()
    * 
    * Input: Node<T> newNode
    * 
    * Output: none 
    * 
    * Desc: Adds a node the lazy way:
    * appends and calls insertion sort.
    */
    public void oldAdd(Node<T> newNode) {
        // Lazy solution: Just appends node and does an insertion sort
        this.append(newNode);
        this.insertionSortDoublyLinked();
        
    }

    /* Method: add()
    * 
    * Input: Node<T> newNode
    * 
    * Output: none 
    * 
    * Desc: Adds a node to its correct
    * sorted position the better way:
    * Finds the first node larger than 
    * newNode recursively and inserts
    * newNode before it.
    */
    public void add(Node<T> newNode) {
        Node<T> larger = this.findLarger(newNode);
        if (larger == null) {
            this.append(newNode); // O(1)
        } else {
            this.insertBefore(larger, newNode);
        }
    }

    // Methods that follow were added for the EmployeeApp
    
    /* Method: add()
    * 
    * Input: T data (Generic)
    * 
    * Output: none 
    * 
    * Desc: Creates a node with 
    * given data and passes it to add().
    */
    public void addByData(T data) {
        Node<T> newNode = new Node<T>(data);
        add(newNode);
    }

    /* Method: size()
    * 
    * Input: none
    * 
    * Output: int 
    * 
    * Desc: Uses a list traversal and an 
    * accumulator to find & return the 
    * size of the list.
    */
    public int size() {
        if (head == null) { 
            return 0; 
        } else if (head == tail) {
            return 1;
        }
        Node<T> nextNode = head;
        int accumulator = 0;
        while (nextNode != null) {
            accumulator += 1;
            nextNode = nextNode.next;
        }
        return accumulator;
    }

    /* Method: removeByData()
    * 
    * Input: T data (Generic)
    * 
    * Output: none
    * 
    * Desc: *SHOULD* remove node:
    * not functional!
    */
    public void removeByData(T data) {
        Node<T> newNode = new Node<T>(data);
        remove(newNode);
    }

    /* Method: printListLn()
    * 
    * Input: none
    * 
    * Output: Prints text to System.out
    * 
    * Desc: Prints nodes in the list, 
    * one per line.
    */
    public void printListLn() {
        Node<T> node = head;
        while (node != null) {
           System.out.println(node.data + " ");
           node = node.next;
        }
        System.out.println();
    }

    /* Method: get()
    * 
    * Input: int
    * 
    * Output: T (Generic)
    * 
    * Desc: Returns node at given index.
    */
    public T get(int index) {
        Node<T> node = head;
        int counter = index;
        while (counter > 0) {
           node = node.next;
           counter -= 1;
        }
        if (node != null) {
            return node.data;
        } else {
            // if index not found return null
            return null;
        }
    }
}