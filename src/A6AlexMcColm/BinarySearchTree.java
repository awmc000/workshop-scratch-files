package A6AlexMcColm;

/* Class: BinarySearchTree
 * 
 * Author: Alex McColm
 * 
 * Date: March 17th, 2022
 * 
 * Desc: Generic implementation of a binary search tree.
 * Uses Node<T> as nodes.
 *
 * */
public class BinarySearchTree<T extends Comparable<T>> {
   // Root node
   private Node<T> root;

   // Default constructor: Empty BST.
   public BinarySearchTree() {
      root = null;
   }

   /* Function: getRoot()
    * 
    * Input: none
    * 
    * Output: Node<T>, root node
    */
   public Node<T> getRoot() {
      return root;
   }

   /* Function: getHeight()
    * 
    * Input: none
    * 
    * Output: int of tree height from root node
    *
    * Desc: Helper which calls recursive method
    */
   public int getHeight() {
      return this.getHeight(this.getRoot());
   }

   /* Function: getHeight()
    * 
    * Input: Node<T>
    * 
    * Output: int of tree height from node given from parameter
    *
    * Desc: Recursive method which finds largest path from given node
    * to a leaf node.
    */
   private int getHeight(Node<T> node) {
      if (node == null) {
         return 0;
      } else {
         int lefth = this.getHeight(node.left);
         int righth = this.getHeight(node.right);
         if (lefth > righth) { return lefth + 1; } else { return righth + 1; }
      }
   }

   /* Function: search()
    * 
    * Input: T, data to search for as a node's key 
    * 
    * Output: Node<T> object of first match
    * 
    * Desc: Binary tree search, uses a method very
    * reminiscient of the Binary Search algorithm itself 
    */
   public Node<T> search(T desiredKey) {
      Node<T> currentNode = root;
      while (currentNode != null) {
         // Return the node if the key matches
         if (currentNode.key.compareTo(desiredKey) == 0) {
            return currentNode;
         }

         // Navigate to the left if the search key is
         // less than the node's key.
         else if (desiredKey.compareTo(currentNode.key) < 0) {
            currentNode = currentNode.left;
         }

         // Navigate to the right if the search key is
         // greater than the node's key.
         else {
            currentNode = currentNode.right;
         }
      }

      // The key was not found in the tree.
      return null;
   }

   /* Function: insert()
    * 
    * Input: Node<T>, node to insert.
    * 
    * Output: None
    * 
    * Desc: Beginning at root node, and inserting at root if 
    * tree is empty, the insert function traverses the BST to find
    * where the new object should be inserted in order to maintain
    * the BST ordering property.
    */
   public void insert(Node<T> node) {
      // Check if tree is empty
      if (root == null) {
         root = node;
      } else {
         Node<T> currentNode = root;
         while (currentNode != null) {
            if (node.key.compareTo(currentNode.key) < 0) {
               // If no left child exists, add the new node
               // here; otherwise repeat from the left child.
               if (currentNode.left == null) {
                  currentNode.left = node;
                  currentNode = null;
               } else {
                  currentNode = currentNode.left;
               }
            } else {
               // If no right child exists, add the new node
               // here; otherwise repeat from the right child.
               if (currentNode.right == null) {
                  currentNode.right = node;
                  currentNode = null;
               } else {
                  currentNode = currentNode.right;
               }
            }
         }
      }
   }

   //  traversal print methods

   /* Method: printInOrder
    * 
    * Input: Node<T>, node to start from.
    * 
    * Output: Prints to console in proper order such that 
    * for any numbers A, B, C, A < B < C.
    * 
    * Desc: Recursive */
   public void printInOrder(Node<T> node) {
      if (node == null) {
         return;
      } else {
         printInOrder(node.left);
         System.out.print(node.key + " ");
         printInOrder(node.right);
      }
   }

   /* Method: printInPreOrder
    * 
    * Input: Node<T>, node to start from.
    * 
    * Output: Prints to console in the order of
    * a pre-order traversal.
    * 
    * Desc: Recursive */
   public void printInPreOrder(Node<T> node) {
      if (node == null) {
         return;
      } else {
         System.out.print(node.key + " ");
         printInPreOrder(node.left);
         printInPreOrder(node.right);
      }
   }

   /* Method: printInPostOrder
    * 
    * Input: Node<T>, node to start from.
    * 
    * Output: Prints to console in the order of
    * a post-order traversal.
    * 
    * Desc: Recursive */
   public void printInPostOrder(Node<T> node) {
      if (node == null) {
         return;
      } else {
         printInPostOrder(node.left);
         printInPostOrder(node.right);
         System.out.print(node.key + " ");
      }
   }

   /*
    * DONE: Fix This generics issue with the GenericQueue parametrized to hold
    * Node<T> objects
    * This version uses a loop, it is not recursive!
    */
   /* Method: printInLevelorderLoop()
    * 
    * Input: Node<T>, node to start from
    * 
    * Output: Prints to console
    * 
    * Desc: Recursive. Makes use of a GenericQueue parametrized with 
    * type Node<T>. Not a recursive level order print, so
    * not neccesary. */
   private void printInLevelOrderLoop(Node<T> node) {
      GenericQueue<Node<T>> nodeQueue = new GenericQueue<>();
      nodeQueue.enqueue(node);
      while (!nodeQueue.isEmpty()) {
         Node<T> currNode = nodeQueue.dequeue();
         System.out.print(currNode.key + ", ");
         if (currNode.left != null) {
            nodeQueue.enqueue(currNode.left);
         }
         if (currNode.right != null) {
            nodeQueue.enqueue(currNode.right);
         }
      }
   }
   /* Method: printInLevelorderLoop()
    * 
    * Input: None
    * 
    * Output: Prints to console
    * 
    * Desc: Overloaded helper function which 
    * calls the recursive function by the 
    * same name on the root node. */
   public void printInLevelOrderLoop() {
      this.printInLevelOrderLoop(root);
   }

   /* Method: printInLevelOrder()
    * 
    * Input: None
    * 
    * Output: Prints to console
    * 
    * Desc: Helper function which calls printLevel for
    * every level of the BST. */
   public void printLevelOrder() { 
      for (int i = 0; i < this.getHeight(); ++i) {
         System.out.print("Level " + i + ": ");
         this.printLevel(root, i);
         System.out.println();
      }
   }

   /* Method: printLevel()
    * 
    * Input: Node<T> node (especially root),
    * int what level *from node* to print.
    * 
    * Output: Prints to console
    * 
    * Desc: Recursive function which prints
    * a specified level of the subtree of the
    * node given as a param */
   private void printLevel(Node<T> node, int level) {
      if (this.root != null) {
         if (level == 0) {
            System.out.print(node.key + " ");
         } else {
            if (node.left != null) { printLevel(node.left, level-1); }
            if (node.right != null) { printLevel(node.right, level-1); }
         }
      }
   }

   /* Method: remove()
    * 
    * Input: T, which data key to remove
    * 
    * Output: Boolean value, of whether 
    * remove was successful
    * 
    * Desc: Operates similar to search, removes first match */
   public boolean remove(T key) {
      Node<T> parent = null;
      Node<T> currentNode = root;

      // Search for the node.
      while (currentNode != null) {
         // Check if currentNode has a matching key.
         if (currentNode.key == key) {
            if (currentNode.left == null && currentNode.right == null) {
               if (parent == null) { // Node<T> is root
                  root = null;
               } else if (parent.left == currentNode) {
                  parent.left = null;
               } else {
                  parent.right = null;
               }
               return true; // Node<T> found and removed
            } else if (currentNode.left != null && currentNode.right == null) {
               if (parent == null) { // Node<T> is root
                  root = currentNode.left;
               } else if (parent.left == currentNode) {
                  parent.left = currentNode.left;
               } else {
                  parent.right = currentNode.left;
               }
               return true; // Node<T> found and removed
            } else if (currentNode.left == null && currentNode.right != null) {
               if (parent == null) { // Node<T> is root
                  root = currentNode.right;
               } else if (parent.left == currentNode) {
                  parent.left = currentNode.right;
               } else {
                  parent.right = currentNode.right;
               }
               return true; // Node<T> found and removed
            } else {
               // Find successor (leftmost child of right subtree)
               Node<T> successor = currentNode.right;
               while (successor.left != null) {
                  successor = successor.left;
               }
               currentNode.key = successor.key; // Copy successor to current node
               parent = currentNode;
               currentNode = currentNode.right; // Remove successor from right subtree
               key = successor.key; // Loop continues with new key
            }
         } else if (currentNode.key.compareTo(key) < 0) { // Search right
            parent = currentNode;
            currentNode = currentNode.right;
         } else { // Search left
            parent = currentNode;
            currentNode = currentNode.left;
         }
      }
      return false; // Node<T> not found
   }
   /* Method: treeToString()
    * 
    * Input: Node<T> whose subtree will be 
    * formatted into a string
    * 
    * Output: String, containing
    * a diagram representation
    * 
    * Desc: Not my work - from ZyDE. */
   public String treeToString(Node<T> subtreeRoot) {
      if (subtreeRoot == null) {
         return "(empty tree)";
      }

      // First convert the tree to an array of line strings
      String[] lines = this.treeToLines(subtreeRoot);

      // Combine all lines into 1 string
      String treeString = lines[0];
      for (int i = 1; i < lines.length; i++) {
         treeString += ("\n" + lines[i]);
      }
      return treeString;
   }

   /* Method: treeToLines()
    * 
    * Input: Node<T> whose subtree should be
    * formatted into a String array of lines
    * 
    * Output: String[] of lines
    * 
    * Desc: not my work, from ZyDE
    */
   private String[] treeToLines(Node<T> subtreeRoot) {
      if (subtreeRoot == null) {
         return new String[0];
      }

      // Make a string with the subtreeRoot's key enclosed in brackets
      String rootString = "[" + subtreeRoot.key + "]";
      int rootStrLen = rootString.length();

      // Case 1: subtreeRoot is a leaf
      if (subtreeRoot.left == null && subtreeRoot.right == null) {
         String[] oneLine = new String[1];
         oneLine[0] = rootString;
         return oneLine;
      }

      // Recursively make line strings for each child
      String[] leftLines = treeToLines(subtreeRoot.left);
      String[] rightLines = treeToLines(subtreeRoot.right);

      int lineCount = Math.max(leftLines.length, rightLines.length);
      String[] allLines = new String[lineCount + 2];

      // Case 2: subtreeRoot has no left child
      if (subtreeRoot.left == null) {
         // Create the first 2 lines, not yet indented
         allLines[0] = rootString;
         allLines[1] = getSpaces(rootStrLen) + "\\";

         // Find where the right child starts
         int rightChildIndent = rightLines[0].indexOf('[');

         // Goal: Indent lines appropriately so that the parent's right branch
         // character ('\') matches up with the right child's '['.

         if (rightChildIndent <= rootStrLen) {
            // Indent all lines below
            indentLines(rightLines, rootStrLen - rightChildIndent);
         } else {
            // Indent first 2 lines
            String indent = getSpaces(rightChildIndent - rootStrLen);
            allLines[0] = indent + allLines[0];
            allLines[1] = indent + allLines[1];
         }

         // Copy rightLines into allLines starting at index 2
         System.arraycopy(rightLines, 0, allLines, 2, rightLines.length);

         return allLines;
      }

      // Case 3: subtreeRoot has no right child
      if (subtreeRoot.right == null) {
         // Goal: Indent lines appropriately so that the parent's left branch
         // character ('/') matches up with the left child's ']'.

         // Create the first 2 lines
         String indent = getSpaces(leftLines[0].indexOf(']'));
         allLines[0] = indent + " " + rootString;
         allLines[1] = indent + "/";

         // Copy leftLines into allLines starting at index 2
         System.arraycopy(leftLines, 0, allLines, 2, leftLines.length);

         return allLines;
      }

      // Case 4: subtreeRoot has both a left and right child

      // The goal is to have the two child nodes as close to the parent as
      // possible without overlap on any level.

      // Compute absolute indentation, in number of spaces, needed for right lines
      int indentNeeded = 0;
      if (rightLines.length > 0) {
         // Indent should at least get the immediate right child to be to the
         // right of the root
         indentNeeded = Math.max(0,
               leftLines[0].length() + rootString.length() - rightLines[0].indexOf('['));
      }
      for (int i = 0; i < leftLines.length && i < rightLines.length; i += 2) {
         // Lines with branches are skipped, so the line of interest has only
         // nodes. The difference between where the left line ends and the
         // right line begins should be at least 3 spaces for clarity.
         //int leftEnd = leftLines[i].lastIndexOf(']');
         int rightBegin = rightLines[i].indexOf('[');

         int forThisLine = leftLines[i].length() + 3 - rightBegin;
         indentNeeded = Math.max(indentNeeded, forThisLine);
      }

      // Build final lines in allLines starting at index 2
      String absoluteIndent = getSpaces(indentNeeded);
      for (int i = 0; i < leftLines.length || i < rightLines.length; i++) {
         // If no right line, just take the left
         if (i >= rightLines.length) {
            allLines[2 + i] = leftLines[i];
         } else {
            String left = "";
            if (i < leftLines.length) {
               left = leftLines[i];
            }
            String right = absoluteIndent + rightLines[i];
            allLines[2 + i] = left + right.substring(left.length());
         }
      }

      // The first 2 lines remain. allLines[2] has the proper string for the
      // 2 child nodes, and thus can be used to create branches in allLines[1].
      int leftIndex = allLines[2].indexOf(']');
      int rightIndex = allLines[2].lastIndexOf('[');
      allLines[1] = getSpaces(leftIndex) + "/" +
            getSpaces(rightIndex - leftIndex - 1) + "\\";

      // The space between leftIndex and rightIndex is the space that
      // subtreeRoot's string should occupy. If rootString is too short, put
      // underscores on the sides.
      rootStrLen = rightIndex - leftIndex - 1;
      if (rootString.length() < rootStrLen) {
         int difference = rootStrLen - rootString.length();
         String underscores = getRepeated('_', difference / 2);
         if (difference % 2 == 0) {
            rootString = underscores + rootString + underscores;
         } else {
            rootString = underscores + rootString + underscores + "_";
         }
      }
      allLines[0] = getSpaces(leftIndex + 1) + rootString;

      return allLines;
   }

   /* Method: getRepeated()
    * 
    * Input: char object to repeat, number
    * of times to repeat it
    * 
    * Output: String of given character repeated
    * given num of times.
    * 
    * Desc: not my work, from ZyDE.
    * Ex. getRepeated('A', 3) = "AAA"
    */
   private static String getRepeated(char toRepeat, int numberOfTimes) {
      if (numberOfTimes <= 0) {
         return "";
      }

      char[] chars = new char[numberOfTimes];
      for (int i = 0; i < numberOfTimes; i++) {
         chars[i] = toRepeat;
      }
      return new String(chars);
   }

   /* Method: getSpaces()
    * 
    * Input: int, number of spaces desired
    * 
    * Output: String of desired numbers of spaces
    * 
    * Desc: eg. getSpaces(1) = " ", getSpaces(2) = "  "
    */
   private static String getSpaces(int numberOfSpaces) {
      return getRepeated(' ', numberOfSpaces);
   }

   /* Method: indentLines
    * 
    * Input: String[] of lines of diagram, int of 
    * number of spaces to indent with
    * 
    * Output: Modifies String array in place
    * 
    * Desc: not my work, from ZyDE
    */
   private static void indentLines(String[] lines, int numberOfSpaces) {
      if (numberOfSpaces <= 0) {
         return;
      }

      // Prepend indentation to each line
      String indent = getSpaces(numberOfSpaces);
      for (int i = 0; i < lines.length; i++) {
         lines[i] = indent + lines[i];
      }
   }
}
