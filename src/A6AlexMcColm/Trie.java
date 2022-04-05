package A6AlexMcColm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Class: Trie
 * Date: Mar 19th, 2022
 * 
 * Author: Alex McColm
 * 
 * Desc: Special K-ary Tree data structure
 * which contains a number of strings very efficiently
 * by containing a network of nodes. Any path from the 
 * root to a terminal node will form a sring which is 
 * contained.
 */

public class Trie {
    private TrieNode root;

    // Default constructor
    public Trie() {
        root = new TrieNode();
    }

    // String constructor
    public Trie(String str) {
        root = new TrieNode();
        this.insert(str);
    }

    // String[] constructor
    public Trie(String[] stringArray) {
        root = new TrieNode();
        for (int i = 0; i < stringArray.length; ++i) {
            this.insert(stringArray[i]);
        }
    }

    /* Method: Constructor taking file
     *  
     * Input: File object
     * 
     * Output: Sets up Trie's root node,
     * and populates with contents of file.
     */
    public Trie(File file) {
        root = new TrieNode();
        // file constructor.
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String nextWord = scanner.next();
                this.insert(nextWord.toUpperCase());
            }
            scanner.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found! " + exception.getMessage());
        } catch (Throwable t) {
            System.out.println("Other error while constructing Trie from File: " + t.getMessage());
        }
    }

    /* Method: getRoot()
     * 
     * Input: none
     * 
     * Output: TrieNode object of root node.
     * 
     * Desc: As the root node, this should 
     * return a character which has a key of
     * empty character or null.
     */
    public TrieNode getRoot() {
        return root;
    }

    /* Method: insert()
     *
     * Input: String, string to be added.
     * 
     * Output: None. Adds string to Trie
     * character by character.
     * 
     * Desc: Finds correct position, including
     * any existing nodes which do not need
     * to be remade. Inserts neccesary nodes,
     * and flags end of word as a terminal node.
     * 
     * Example: Adding "Hello" to empty tree
     * 
     * In an empty tree, this would add 5 nodes, 
     * each a child of the last.
     * 
     * Example: Adding "He" to a tree which contains
     * Hello
     * 
     * This would add no nodes, but would traverse down to
     * H -> E and flag E as a terminal node.
     */
    public void insert(String newString) {
        newString = newString.toUpperCase();
        
        TrieNode currNode = root;
        TrieNode newNode;
        // For characters in string
        for (int i = 0; i < newString.length(); ++i) {
            if (!Character.isAlphabetic(newString.charAt(i))) { return; }
            int charVal = newString.charAt(i) - TrieNode.CHARACTER_OFFSET;
            newNode = new TrieNode(newString.charAt(i));
            if (currNode.children[charVal] == null) {
                currNode.children[charVal] = newNode;
            }
            currNode = currNode.children[charVal];
        }
        currNode.setIsTerminalNode(true);

    }

    /*
     * public void insertAfter(TrieNode existingNode, char newKey) {
     * TrieNode currNode = existingNode;
     * TrieNode newNode = new TrieNode(newKey);
     * //currNode.addChild(newNode);
     * }
     */

    /* Method: search()
     * 
     * Input: String, to be search key
     * 
     * Output: TrieNode of terminal node
     * of match
     */
    public TrieNode search(String searchKey) {
        searchKey = searchKey.toUpperCase();
        TrieNode currNode = root;
        for (int i = 0; i < searchKey.length(); ++i) {
            if (!Character.isAlphabetic(searchKey.charAt(i))) { return null; }
            if (currNode.children[searchKey.charAt(i) - TrieNode.CHARACTER_OFFSET] == null) {
                return null;
            } else {
                currNode = currNode.children[searchKey.charAt(i) - TrieNode.CHARACTER_OFFSET];
            }
        }
        if (currNode.getIsTerminalNode()) {
            return currNode;
        }
        return null;
    }


    /* Method: contains()
     * 
     * Input: String, to be search key
     * 
     * Output: Boolean value of the statement
     * "This trie contains the search key".
     * 
     * Desc: Uses search() and double checks
     * that it is a terminal node. Take an 
     * empty Trie, add HELLO, search HE, this
     * will return false.
     */
    public boolean contains(String searchKey) {
        TrieNode currNode = search(searchKey);
        return (currNode != null) && (currNode.getIsTerminalNode());
    }

    /* Method: delete()
     * 
     * Input: String to delete
     * 
     * Output: Boolean value of if delete
     * was successful
     * 
     * Desc: Helper method which calls recursive
     * method deleteRecursive()
     */
    public boolean delete(String deleteKey) {
        return deleteRecursive(root, deleteKey.toUpperCase(), 0);
    }

    /* Method: deleteRecursive() 
     * 
     * Input: trieNode to start traversal at,
     * String of string to delete, int of what
     * index of the string has been completed
     * so far.
     */
    private boolean deleteRecursive(TrieNode trieNode, String deleteKey, int index) {
        if (index == deleteKey.length()) {
            if (trieNode.getIsTerminalNode()) {
                trieNode.setIsTerminalNode(false);
                return true;
            }
            return false;
        }

        char character = deleteKey.charAt(index);

        if (trieNode.children[character - TrieNode.CHARACTER_OFFSET] == null) {
            return false;
        }

        TrieNode child = trieNode.children[character - TrieNode.CHARACTER_OFFSET];

        deleteRecursive(child, deleteKey, index + 1);

        if (child.childrenEmpty()) {
            // System.out.println(child.getKey() + " removed while removing " + deleteKey);
            trieNode.children[character - TrieNode.CHARACTER_OFFSET] = null;
        }

        return true;
    }

    /* Method: printInLevelOrderLoop() 
     * 
     * Input: trieNode to print subtree of
     * 
     * Output: Prints to console
     * 
     * Desc: Uses a loop, does not function 
     * properly.
     */
    public void printInLevelOrderLoop(TrieNode node) {
        GenericQueue<TrieNode> nodeQueue = new GenericQueue<>();
        nodeQueue.enqueue(node);
        while (!nodeQueue.isEmpty()) {
            TrieNode currNode = nodeQueue.dequeue();
            System.out.print((char) (currNode.getKey() - TrieNode.CHARACTER_OFFSET) + ", ");
            for (int i = 0; i < currNode.children.length; ++i) {
                if (currNode.children[i] != null) {
                    nodeQueue.enqueue(currNode.children[i]);
                }
            }

        }
    }

    /* Method: printInLevelOrderLoop()
     *
     * Input: none
     * 
     * Output: prints to console
     * 
     * Desc: Helper method which calls recursive 
     * method sharing same name (overloaded),
     * passing it the root node of the Trie.
     */
    public void printInLevelOrderLoop() {
        this.printInLevelOrderLoop(root);
    }

    /* Method: displayRecursive()
     * 
     * Input: TrieNode to display the level below.
     * Integer of number of spaces to offset it by.
     * 
     * Output: Prints to console.
     * 
     * Desc: Recursive, does not function properly,
     * prints node keys but not formatted correctly.
     */
    private void displayRecursive(TrieNode node, int offset) {
        String offsetString = " ".repeat(offset);
        Character nodeKey = (char) (node.getKey() - TrieNode.CHARACTER_OFFSET);
        System.out.print(nodeKey + offsetString);
        if (!node.childrenEmpty()){
            for (TrieNode childNode: node.children) {
                if (childNode != null) {
                    displayRecursive(childNode, offset + 1);
                }
            }
            System.out.println();
        }
    }

    /* Method: display()
     * 
     * Input: None
     * 
     * Output: Prints to console
     * 
     * Desc: Helper method which calls recursive
     * displayRecursive() on root.
     * 
     */
    public void display() {
        displayRecursive(root, 0);
    }

    public static void main(String[] args) {
        System.out.println("===============Simple trie test with a few strings.===============");
        
        // Array of simple strings, with some overlap.
        String[] simpleStrings = {"HELLO", "HELP", "HE", "DO", "DOUGH", "DOOR"};
        
        // Construct Trie object for simple strings.
        Trie simpleTrie = new Trie(simpleStrings);
        
        System.out.print("Initialized the simple trie with the following strings: ");
        
        // Print each string on the same line.
        for (int i = 0; i < simpleStrings.length; ++i) { 
            System.out.print(simpleStrings[i] + " ");
        }

        System.out.println("\nChecking if the simple trie contains the strings added by using the search algorithm.");
        // For each string in the original string array,
        for (int i = 0; i < simpleStrings.length; ++i) {
            // grab the current string.
            String currentString = simpleStrings[i];
            
            // set up a string of the result, default "found".
            String result = "found";

            // If the string is not contained, prefix "found" with "not " for "not found".
            if (!simpleTrie.contains(currentString)) { 
                result = "not " + result; 
            }
            
            // Print search result: Search key and result.
            System.out.println("Searching for: " + currentString + ". Found: " + result);
        }

        // Setting up the false positive contains() test.

        // Similarly, set up a result strig for the false positive contains() test,
        // prepending "not " if it is not found to be contained.
        String falsePositiveTestResult = "found";

        if (!simpleTrie.contains("AXOLOTL")) { 
            falsePositiveTestResult = "not " + falsePositiveTestResult; 
        }
        System.out.println("Now, to test for false positives, let's check for a string that should *not* be contained.\nSearching for: AXOLOTL. Found: " + falsePositiveTestResult);
        
        System.out.println("=============== Moving on to the file test.===============");
        
        File dictionaryFile = new File("src\\A6AlexMcColm\\dictionary.txt");
        System.out.println("Made file");
        
        Trie fileTrie = new Trie(dictionaryFile);
        System.out.println("Made fileTrie");
        System.out.println("Iterating through the dictionary file, checking if the trie contains each word that should have been added.");
        
        // Search the Trie for *EVERY* string contained in the file.
        try {
            Scanner fileScanner = new Scanner(dictionaryFile);
            while (fileScanner.hasNext()) {
                String contained = " found";
                String currentString = fileScanner.next();
                boolean result = fileTrie.contains(currentString.toUpperCase());
                if (!result) { 
                    contained = "not " + contained; 
                }
                System.out.println("Searched trie for: " + currentString +". " + contained);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! " + e.getMessage());
        } catch (Throwable t) {
            System.out.println("Other error loading file: " + t.getMessage());
        }
        
        // Deleting from the fileTrie test.
        System.out.println("Now, to remove a couple words from the trie, and check if they are contained.");
        fileTrie.delete("lung");
        System.out.println("Deleted 'lung'");
        fileTrie.delete("welcome");
        System.out.println("Deleted 'welcome'");
        fileTrie.delete("nitrogen");
        System.out.println("Deleted 'nitrogen'");
        System.out.println("'lung' is contained in the trie: " + fileTrie.contains("lung"));
        System.out.println("'welcome' is contained in the trie: " + fileTrie.contains("welcome"));
        System.out.println("'nitrogen' is contained in the trie: " + fileTrie.contains("nitrogen"));
    }

}
