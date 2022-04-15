package com.datastructurediagrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import com.datastructurediagrammer.linkedlists.DoublyLinkedList;
import com.datastructurediagrammer.linkedlists.DoublyLinkedListDiagrammer;
import com.datastructurediagrammer.linkedlists.SinglyLinkedList;
import com.datastructurediagrammer.linkedlists.SinglyLinkedListDiagrammer;
import com.datastructurediagrammer.trees.BSTDiagrammer;
import com.datastructurediagrammer.trees.BinarySearchTree;

public class TestDriver {
    public static void sllTest() throws FileNotFoundException { 
        System.out.println("Constructing list");
        SinglyLinkedList<String> sList = new SinglyLinkedList<String>("A");
        System.out.println("List constructed");
        
        // add data
        sList.appendData("B");
        sList.appendData("D");
        sList.insertAfterData(sList.head.next, "C");
        sList.prependData("S");
        sList.insertAfterData(sList.tail, "E");
        System.out.println("Elements added..");
        System.out.println("List: " + sList.toString());
        sList.print();
        File sllCheck = new File("sllCheck.txt");
        PrintWriter pw = new PrintWriter(sllCheck);
        pw.write(sList.toString());
        pw.close();
        System.out.println("Printed list");
        
        Random rand = new Random(4);

        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        DoublyLinkedList<Integer> intDList = new DoublyLinkedList<Integer>();

        for (int i = 0; i < 30; ++i) { 
            intList.appendData(rand.nextInt(10000));
            intDList.appendData(rand.nextInt(100));
        }

        SinglyLinkedListDiagrammer.renderDiagram(sList, "listDiagram.png");
        SinglyLinkedListDiagrammer.renderDiagram(intList, "intListDiagram.png");
        DoublyLinkedListDiagrammer.renderDiagram(intDList, "doublelinkedlist.png");
    }
    public static void bstTest() { 
        BinarySearchTree<String> stringTree = new BinarySearchTree<String>();
        Random rand = new Random();
        String[] characters = {"a", "b", "c", "d", "e", "f"};
        String generatedString; 
        for (int i = 0; i < 30; ++i) {
            generatedString = characters[rand.nextInt(6)] + characters[rand.nextInt(6)] + characters[rand.nextInt(6)];
            stringTree.insert(generatedString);
        }
        System.out.println("printing:");
        stringTree.printInOrder(stringTree.root);
        System.out.println("height: " + stringTree.getHeight());
        BinarySearchTree<Integer> heightTree = new BinarySearchTree<>();
        heightTree.insert(2);
        heightTree.insert(3);
        heightTree.insert(-1);
        System.out.println("Should be 3: " + heightTree.getHeight());
        heightTree.insert(1);
        System.out.println("SHould be 3 still: " + heightTree.getHeight());
        heightTree.insert(5);
        System.out.println("should be 4: " + heightTree.getHeight());
        heightTree.insert(4);
        BSTDiagrammer.renderDiagram(heightTree, "short_tree.png");
        BSTDiagrammer.renderDiagram(stringTree, "long_tree.png");
    }
    public static void main(String[] args) {
        try { 
            //sllTest();
            bstTest();
        } catch (Throwable t) { }
    }
}
