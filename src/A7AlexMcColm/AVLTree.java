package A7AlexMcColm;

/* Class: AVLTree
 *
 * Author: ZyBooks
 * 
 * Desc: Balanced binary search tree which performs
 * rebalance operations to maintain an efficient tree
 */
public class AVLTree<T extends Comparable<T>> {
    // Root node
    private Node<T> root;

    // Default constructor
    public AVLTree() {
        root = null;
    }

    // Getter method for root node
    public Node<T> getRoot() {
        return root;
    }

    /* Method: rotateLeft
     *
     * Input: Node<T>
     * 
     * Output: Node<T>
     * 
     * Desc: Performs a left rotation at the given node. Returns the
     * subtree's new root.
     */
    public Node<T> rotateLeft(Node<T> node) {
        // Define a convenience pointer to the right child of the
        // left child.
        Node<T> rightLeftChild = node.right.left;

        // Step 1 - the right child moves up to the node's position.
        // node is temporarily detached from the tree, but will be reattached
        // later.
        if (node.parent != null) {
            node.parent.replaceChild(node, node.right);
        } else { // node is root
            root = node.right;
            root.parent = null;
        }

        // Step 2 - the node becomes the left child of what used
        // to be node's right child, but is now node's parent. This will
        // detach rightLeftChild from the tree.
        node.right.setChild(Node.Child.LEFT, node);

        // Step 3 - reattach rightLeftChild as the right child of node.
        node.setChild(Node.Child.RIGHT, rightLeftChild);

        return node.parent;
    }
    
    /* Method: rotateRight
     *
     * Input: Node<T>
     * 
     * Output: Node<T>
     * 
     * Desc: Performs a right rotation at the given node. Returns the
     * subtree's new root.
     */
    public Node<T> rotateRight(Node<T>node) {
        // Define a convenience pointer to the left child of the
        // right child.
        Node<T> leftRightChild = node.left.right;

        // Step 1 - the left child moves up to the node's position.
        // node is temporarily detached from the tree, but will be reattached
        // later.
        if (node.parent != null) {
            node.parent.replaceChild(node, node.left);
        } else { // node is root
            root = node.left;
            root.parent = null;
        }

        // Step 2 - the node becomes the right child of what used
        // to be node's left child, but is now node's parent. This will
        // detach leftRightChild from the tree.
        node.left.setChild(Node.Child.RIGHT, node);

        // Step 3 - reattach leftRightChild as the right child of node.
        node.setChild(Node.Child.LEFT, leftRightChild);

        return node.parent;
    }

    /* Method: rebalance()
     *
     * Input: Node<T>
     * 
     * Output: Node<T>
     * 
     * Desc: Updates the given node's height and rebalances the subtree if
     * the balancing factor is now -2 or +2. Rebalancing is done by
     * performing a rotation. Returns the subtree's new root if
     * a rotation occurred, or the node if no rebalancing was required.
     */
    public Node<T> rebalance(Node<T> node) {
        // First update the height of this node.
        node.updateHeight();

        // Check for an imbalance.
        if (node.getBalance() == -2) {
            // The subtree is too big to the right.
            if (node.right.getBalance() == 1) {
                // Double rotation case. First do a right rotation
                // on the right child.
                rotateRight(node.right);
            }

            // A left rotation will now make the subtree balanced.
            return rotateLeft(node);
        } else if (node.getBalance() == 2) {
            // The subtree is too big to the left
            if (node.left.getBalance() == -1) {
                // Double rotation case. First do a left rotation
                // on the left child.
                rotateLeft(node.left);
            }

            // A right rotation will now make the subtree balanced.
            return rotateRight(node);
        }

        // No imbalance, so just return the original node.
        return node;
    }

    /* Method: search()
     * 
     * Input: T - key of whichever data type the node is 
     * parametrized to hold.
     * 
     * Output: Node<T> - first match
     * 
     * Desc: Searches for a node with a matching key. Does a regular
     * binary search tree search operation. Returns the node with the
     * matching key, or null if no matching key exists in the tree.
     */
    public Node<T> search(T desiredKey) {
        Node<T> currentNode = root;
        while (currentNode != null) {
            // Return the node if the key matches
            if (currentNode.key == desiredKey) {
                return currentNode;
            }

            // Navigate to the left if the search key is
            // less than the node's key.
            else if (currentNode.key.compareTo(desiredKey) < 0) {
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
     * Input: Node<T> - node to insert
     * 
     * Output: none
     */
    public void insert(Node<T> node) {
        // Check if tree is empty
        if (root == null) {
            root = node;
        } else {
            // Step 1 - do a regular binary search tree insert.
            Node<T> currentNode = root;
            while (currentNode != null) {
                // Choose to go left or right
                // If the condition is instead node.key.compareTo(currentNode.key > 0),
                // the tree is mirrored
                if (node.key.compareTo(currentNode.key) < 0) {
                    // Go left. If left child is null, insert the new
                    // node here.
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        node.parent = currentNode;
                        currentNode = null;
                    } else {
                        // Go left and do the loop again.
                        currentNode = currentNode.left;
                    }
                } else {
                    // Go right. If the right child is null, insert the
                    // new node here.
                    if (currentNode.right == null) {
                        currentNode.right = node;
                        node.parent = currentNode;
                        currentNode = null;
                    } else {
                        // Go right and do the loop again.
                        currentNode = currentNode.right;
                    }
                }
            }

            // Step 2 - Rebalance along a path from the new node's parent up
            // to the root.
            node = node.parent;
            while (node != null) {
                rebalance(node);
                //System.out.println("Rebalanced: " + node.key);
                //System.out.println(node.height);
                node = node.parent;
            }
        }
    }

    /* Method: removeKey
     *
     * Input: T - finds the node with this key and removes
     * 
     * Output: boolean - true if successful, false if failed.
     * 
     * Desc: Attempts to remove a node with a matching key. 
     * If no node has a matching key then nothing is done and 
     * false is returned; otherwise the node is removed and
     * true is returned.
     */
    public boolean removeKey(T key) {
        Node<T>node = search(key);
        if (node == null) {
            return false;
        } else {
            return removeNode(node);
        }
    }
    /* Method: removeNode
     *
     * Input: Node<T> - node to remove
     * 
     * Output: boolean - true if successful, false if failed.
     * 
     * Desc: Attempts to remove a node given as a parameter. 
     * If the remove operation fails then nothing is done and 
     * false is returned; otherwise the node is removed and
     * true is returned.
     */
    private boolean removeNode(Node<T> nodeToRemove) {
        // # Base case:
        if (nodeToRemove == null) {
            return false;
        }

        // Parent needed for rebalancing.
        Node<T>parent = nodeToRemove.parent;

        // Case 1: Internal node with 2 children
        if (nodeToRemove.left != null && nodeToRemove.right != null) {
            // Find successor
            Node<T>successorNode = nodeToRemove.right;
            while (successorNode.left != null) {
                successorNode = successorNode.left;
            }

            // Copy the value from the node
            nodeToRemove.key = successorNode.key;

            // Recursively remove successor
            removeNode(successorNode);

            // Nothing left to do since the recursive call will have rebalanced
            return true;
        }

        // Case 2: Root node (with 1 or 0 children)
        else if (nodeToRemove == root) {
            if (nodeToRemove.left != null) {
                root = nodeToRemove.left;
            } else {
                root = nodeToRemove.right;
            }

            if (root != null) {
                root.parent = null;
            }

            return true;
        }

        // Case 3: Internal with left child only
        else if (nodeToRemove.left != null) {
            parent.replaceChild(nodeToRemove, nodeToRemove.left);
        }

        // Case 4: Internal with right child only OR leaf
        else {
            parent.replaceChild(nodeToRemove, nodeToRemove.right);
        }

        // nodeToRemove is gone. Anything that was below nodeToRemove that has persisted
        // is already correctly balanced, but ancestors of nodeToRemove may need
        // rebalancing.
        nodeToRemove = parent;
        while (nodeToRemove != null) {
            rebalance(nodeToRemove);
            nodeToRemove = nodeToRemove.parent;
        }

        return true;
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
        for (int i = 0; i < this.root.height; ++i) {
           System.out.print("Level " + i + ": ");
           this.printLevel(root, i);
           System.out.println();
        }
     }
  
     /* Method: printLevel
      *
      * Input: Node<T>, int - Current node being operated on
      * integer which tracks what level of tree we are on.
      *
      * Output: prints to console
      * 
      * Desc: Recursive
      */
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
}