package com.A4AlexMcColm;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> next;
    public Node<T> previous;
 
    public Node(T initialData) {
       data = initialData;
       next = null;
       previous = null;
    }

    public void printData() {
        System.out.println(data.toString());
    }
}