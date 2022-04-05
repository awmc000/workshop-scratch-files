package A7AlexMcColm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Class: AVLTreeDriver
 *
 * Author: Alex McColm
 * 
 * Desc: Test driver which sets up AVL and Binary Search trees
 * and performs operations on them.
 */
public class AVLTreeDriver {

    /* Method: bstTest()
     * 
     * Input: none
     * 
     * Output: prints to console
     * 
     * Desc: Contains the binary search tree test,
     * notable exception - does not contain the BST
     * **dictionary** test.
     */
    public static void bstTest() {
        // Set up BST
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        // Numbers to insert 
        int[] intArr = {5, 10, 22, 12, 15, 47, 19, 3, 18};

        // Inserts them all with an enhanced for loop.
        for (int num : intArr) {
            // Set up a BST node containing current number
            BSTNode<Integer> newNode = new BSTNode<Integer>(num);

            binarySearchTree.insert(newNode);
        }
        System.out.println("BST height: " + binarySearchTree.getHeight());
        System.out.println("Printing Binary Search Tree: ");
        
        // Prints diagram of tree
        System.out.println(AVLPrint.treeToString(binarySearchTree.getRoot()));
        
        // Tree should contain 12 but not 30.
        binarySearchTree.remove(12);
        binarySearchTree.remove(30);

        System.out.println("After deleting 12 and 30: ");
        System.out.println("BST height: " + binarySearchTree.getHeight());
        
        // Prints diagram of tree
        System.out.println(AVLPrint.treeToString(binarySearchTree.getRoot()));
    }

    /* Method: dictionaryTest()
     * 
     * Input: operates on dictionary.txt
     * 
     * Output: prints to console
     *
     * Desc: Performs AVL and BST tests on 
     * dictionary txt file.
     */
    public static void dictionaryTest() { 
        // Set up AVL tree and BST objects
        AVLTree<String> dictionaryStringAVLTree = new AVLTree<>();
        BinarySearchTree<String> dictionaryStringBST = new BinarySearchTree<>();

        // Set up file object for the Scanner to read
        File dictionaryFile = new File("src\\A7AlexMcColm\\dictionary.txt");
        try {
            // Scanner takes File as a constructor
            Scanner fileScanner = new Scanner(dictionaryFile);

            // For every word in the file, insert it to both trees
            while (fileScanner.hasNext()) { 
                String str = fileScanner.next();
                dictionaryStringAVLTree.insert(new Node<String>(str));
                dictionaryStringBST.insert(new BSTNode<String>(str));
            }

            // Shut down the scanner, prevent memory leak/waste
            fileScanner.close();
        } catch (FileNotFoundException exception) { 
            System.out.println("File not found! Message: " + exception.getMessage());
        } catch (Throwable throwable) { 
            System.out.println("Other error: " + throwable.getMessage());
        }

        System.out.println("Height of dictionary AVL tree: " + dictionaryStringAVLTree.getRoot().height);
        System.out.println("Height of dictionary BST : " + dictionaryStringBST.getHeight());
        System.out.println("Printing contents of each level of the dictionary BST: ");
        dictionaryStringBST.printLevelOrder();
        System.out.println("Printing contents of each level of the dictionary AVL tree:");
        dictionaryStringAVLTree.printLevelOrder();
    }

    /* Method: simpleTest()
     *
     * Input: none
     * 
     * Output: prints to console
     * 
     * Desc: performs simple AVL tree tests 
     * with integer values
     */
    public static void simpleTest() { 
        AVLTree<Integer> integerTree = new AVLTree<>();
        int[] intArr = {5, 10, 22, 12, 15, 47, 19, 3, 18};
        System.out.print("Inserting into AVL tree: ");
        for (int num : intArr) {
            Node<Integer> newNode = new Node<Integer>(num);
            integerTree.insert(newNode);
            System.out.print(num + " ");
        }
        System.out.println(); // newline is needed after printing the series of numbers 
        integerTree.getRoot().right.right.updateHeight();
        integerTree.getRoot().right.updateHeight();
        integerTree.removeKey(12);
        integerTree.removeKey(30);
        integerTree.toString();
        System.out.println("Tree height: " + integerTree.getRoot().height);
        System.out.println("Printing AVL Tree: ");
        System.out.println(AVLPrint.treeToString(integerTree.getRoot()));
    }
    public static void main(String[] args) {
        simpleTest();
        System.out.println("++++++++++++++++++++++++++++++++++++");
        bstTest();
        System.out.println("++++++++++++++++++++++++++++++++++++");
        dictionaryTest();

    }
}