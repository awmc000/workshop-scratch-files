package com.A3AlexMcColm;

class Queue {
    private DoublyLinkedList<Integer> linkedList;
     
    Queue() {
       linkedList = new DoublyLinkedList<>();
    }
    
    public void enqueue(int newData) {
       // Create a new node
       Node<Integer> newNode = new Node(newData);
        
       // Insert as list tail (end of queue)
       linkedList.append(newNode);
    }
    
    public int dequeue() {
       // Copy list head's data
       int dequeuedItem = linkedList.getHeadData();
       
       // Remove list head
       linkedList.removeAfter(null);
       
       // Return dequeued item
       return dequeuedItem;
    }
    
    public void print() {
       linkedList.printList();
    }
 }
