package com.trees;

public class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i= 0; i < 10; ++i) {
            tree.insert(new Node(i + 5));
            tree.insert(new Node(i - 5));
        }
        tree.printInOrder(tree.getRoot());
    }
}