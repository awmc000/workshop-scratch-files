package com.A3AlexMcColm;

class Stack {
    private DoublyLinkedList linkedList;
     
    Stack() {
       linkedList = new DoublyLinkedList();
    }
    
    public void push(int newData) {
       // Create a new node and prepend
       Node newNode = new Node(newData);
       linkedList.prepend(newNode);
    }
    
    public int pop() {
       // Copy list head's data
       int poppedItem = linkedList.getHeadData();
       
       // Remove list head
       linkedList.removeAfter(null);
       
       // Return popped item
       return poppedItem;
    }
    
    public void print() {
       linkedList.printList();
    }
 }