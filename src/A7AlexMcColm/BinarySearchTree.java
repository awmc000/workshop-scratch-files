package A7AlexMcColm;

public class BinarySearchTree<T extends Comparable<T>> {
   private BSTNode<T> root;

   // default constructor
   public BinarySearchTree() {
      root = null;
   }

   /* Method: getRoot()
    *
    * Input: none
    * 
    * Output: BSTNode<T> - root node
    *
    * Desc: Simple getter method.
    */
   public BSTNode<T> getRoot() {
      return root;
   }

   public BSTNode<T> search(T desiredKey) {
      BSTNode<T> currentNode = root;
      while (currentNode != null) {
         // Return the node if the key matches
         if (currentNode.key == desiredKey) {
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

   /* Method: insert()
    *
    * Input: BSTNode<T> - node to insert
    * 
    * Output: none, operates on self
    */
   public void insert(BSTNode<T> node) {
      // Check if tree is empty
      if (root == null) {
         root = node;
      } else {
         BSTNode<T> currentNode = root;
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

   /* Method: remove()
    * 
    * Input: T, which data key to remove
    * 
    * Output: Boolean value, of whether 
    * remove was successful
    * 
    * Desc: Operates similar to search, removes first match */
    public boolean remove(T key) {
      BSTNode<T> parent = null;
      BSTNode<T> currentNode = root;

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
               BSTNode<T> successor = currentNode.right;
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
   
   /* Function: getHeight()
    * 
    * Input: Node<T>
    * 
    * Output: int of tree height from node given from parameter
    *
    * Desc: Recursive method which finds largest path from given node
    * to a leaf node. Public so that height of non-root nodes can
    * also be found.
    */
   public int getHeight(BSTNode<T> node) {
      if (node == null) {
         return 0;
      } else {
         int lefth = this.getHeight(node.left);
         int righth = this.getHeight(node.right);
         if (lefth > righth) { return lefth + 1; } else { return righth + 1; }
      }
   }

   /* Method: getHeight()
    *
    * Input: none
    * 
    * Output: calls function by same name, getHeight(BSTNode<T>)
    */
   public int getHeight() { 
      return getHeight(root) - 1; // subtract 1 to correct result
   }

   /* Method: printLevelOrder()
    *
    * Input: None, operates on self
    * 
    * Output: Prints to console
    * 
    * Desc: From one of my previous assignment's 
    * classes. Public helper method which calls
    * recursive private method on root.
    */
   public void printLevelOrder() { 
      for (int i = 0; i < this.getHeight(); ++i) {
         System.out.print("Level " + i + ": ");
         this.printLevel(root, i);
         System.out.println();
      }
   }

   /* Method: printLevel()
    *
    * Input: BSTNode<T>, int - Current node being operated on
    * integer which tracks what level of tree we are on.
    *
    * Output: prints to console
    * 
    * Desc: Recursive
    */
   private void printLevel(BSTNode<T> node, int level) {
      if (this.root != null) {
         if (level == 0) {
            System.out.print(node.key + " ");
         } else {
            if (node.left != null) { printLevel(node.left, level-1); }
            if (node.right != null) { printLevel(node.right, level-1); }
         }
      }
   }
}
