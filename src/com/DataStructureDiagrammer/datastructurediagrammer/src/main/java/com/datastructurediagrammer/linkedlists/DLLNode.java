package com.datastructurediagrammer.linkedlists;

public class DLLNode <T extends Comparable<T>> {
    DLLNode(T initData) {
        this.data = initData;
    }

    public DLLNode<T> previous;
    public DLLNode<T> next;
    public T data;

    public T getData() { 
        return data;
    }
}