package com.datastructurediagrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import java.time.LocalDateTime;

import com.datastructurediagrammer.arrays.ArrayDiagrammer;
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

        for (int i = 0; i < 100; ++i) { 
            intList.appendData(rand.nextInt(10000));
            intDList.appendData(rand.nextInt(100));
        }

        SinglyLinkedListDiagrammer.renderDiagram(sList, "listDiagram.png");
        SinglyLinkedListDiagrammer.renderDiagram(intList, "intListDiagram.png");
        DoublyLinkedListDiagrammer.renderDiagram(intDList, "doublelinkedlist.png");
    }
    public static void bstTest() { 
        //BinarySearchTree<String> stringTree = new BinarySearchTree<String>();
        Random rand = new Random();
        /*String[] characters = {"a", "b", "c", "d", "e", "f"};
        String generatedString; */
        
        //System.out.println("printing:");
        //stringTree.printInOrder(stringTree.root);
        //System.out.println("height: " + stringTree.getHeight());
        BinarySearchTree<Integer> heightTree = new BinarySearchTree<>();
        BinarySearchTree<Integer> randomTree = new BinarySearchTree<>();
        int testCount = 40;
        for (int i = 0; i < testCount; ++i) {
            heightTree.insert(i);
            randomTree.insert(rand.nextInt(10000));
        }
        System.out.println(heightTree.getTotalNodes());
        String timeStamp = LocalDateTime.now().toString().replace(':', '-');
        BSTDiagrammer.renderDiagram(heightTree, timeStamp + "int_max_tree" + testCount + ".png");
        BSTDiagrammer.renderDiagram(randomTree, timeStamp + "random_int_tree" + testCount + ".png");
        System.out.println("saved");
        //BSTDiagrammer.renderDiagram(stringTree, "long_tree.png");
    }
    public static void arrayTest() { 
        String timeStamp = LocalDateTime.now().toString().replace(':', '-');
        Integer[] intArray = {2, 4, 88, 9993, 234, 0, -1, 23, 4};
        ArrayDiagrammer<Integer> arrayDiagrammer = new ArrayDiagrammer<Integer>();
        arrayDiagrammer.drawToFile(intArray, "Integers", timeStamp + "int_array.png");
        String[] stringArray = {"Hello", "world", "object", "oriented", "java", "is", "interpreted", "AND", "compiled"};
        ArrayDiagrammer<String> stringDiagrammer = new ArrayDiagrammer<String>();
        stringDiagrammer.drawToFile(stringArray, "String", timeStamp + "string_array.png");
    }
    public static void main(String[] args) {
        try { 
            //sllTest();
            //bstTest();
            arrayTest();
        } catch (Throwable t) {
            t.printStackTrace();
         }
    }
}
