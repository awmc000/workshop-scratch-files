package com.datastructurediagrammer.linkedlists;

public class DoublyLinkedList<T extends Comparable<T>> {
    public DLLNode<T> head;
    public DLLNode<T> tail;

    public void prepend(T newData) {
        DLLNode<T> newNode = new DLLNode<T>(newData);
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        if (tail == null) { 
            tail = head;
        }
    }

    public void appendData(T newData) { 
        DLLNode<T> newNode = new DLLNode<T>(newData);

        // Case 1: Empty list - point head and tail to new node
        if (head == null) { 
            head = newNode;
            tail = newNode;
            return;
        }
        // Case 2: Non-empty list - point tail.next to new node and tail to new node.
        if (head != null) { 
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public int getLength() { 
        DLLNode<T> currentNode = head;
        int count = 0;
        while (currentNode != null) { 
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
}
