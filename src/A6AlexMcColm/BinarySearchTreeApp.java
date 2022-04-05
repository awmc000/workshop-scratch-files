package A6AlexMcColm;

import java.util.Random;

/**
 * Class: BinarySearchTreeApp
 * 
 * Date: Mar 17th 2022
 * 
 * Author: Alex McColm
 * 
 * Desc: Main driver for Binary Search Tree testing.
 * Calls Trie test driver, so that the full test is
 * run by running this file only.
 */
public class BinarySearchTreeApp {
    public static void main(String[] args) {
        /*
        // Creating the BST itself
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        //BSTPrint bstPrinter = new BSTPrint<>();
        // Creating the Random object for random numbers
        Random random = new Random(3);

        // Add ten random Integers to the bst
        for (int i = 0; i < 10; ++i) {
            int nextInt = random.nextInt(100);
            System.out.println("Inserting " + nextInt);
            binarySearchTree.insert(new Node<Integer>(nextInt));
        }
        
        // Printing using treeToString method from Zybooks copied code
        System.out.println("printing formatted tree:");
        System.out.println(binarySearchTree.treeToString(binarySearchTree.getRoot()));

        // Print the tree in level order with a loop
        System.out.println("Printing in level order using loop:");
        binarySearchTree.printInLevelOrderLoop();
        System.out.println();

        // Print the tree in level order using recursion
        System.out.println("printing in level order using recursion: ");
        binarySearchTree.printLevelOrder();

        // Print with in-order traversal
        System.out.println("Printing in-order:");
        binarySearchTree.printInOrder(binarySearchTree.getRoot());
        System.out.println();
        // Print with pre-order traversal
        System.out.println("Printing pre-order:");
        binarySearchTree.printInPreOrder(binarySearchTree.getRoot());
        System.out.println();
        // Print with post-order traversal
        System.out.println("Printing post-order:");
        binarySearchTree.printInPostOrder(binarySearchTree.getRoot());
        System.out.println();

        // Get height
        System.out.println("Height: " + binarySearchTree.getHeight());

        // Running the Trie test
        Trie.main(args);
        */
        BinarySearchTree<Character> letterTree = new BinarySearchTree<>();
        letterTree.insert(new Node<Character>('A'));
    }
}