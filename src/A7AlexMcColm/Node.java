package A7AlexMcColm;

/* Class: Node<T>
 *
 * Author: Alex McColm
 * 
 * Desc: AVL tree node, with parent
 * pointer and height member in addition
 * to basic BST members. 
 */
public class Node<T> {
    /* Enumeration: Child
     *
     * States: LEFT, RIGHT
     * 
     * Desc: Used for operations to specify which child
     * of a node to be operated on.
     */
    public enum Child {
        LEFT, RIGHT
    }

    // Members
    public T key;
    public Node<T> parent;
    public Node<T> left;
    public Node<T> right;
    public int height;

    // Constructor with data key
    public Node(T nodeKey) { 
        key = nodeKey;
        parent = null;
        left = null;
        right = null;
        height = 0;
    }

    /* Method: getBalance()
     *
     * Input: none, operates on self
     * 
     * Output: Integer balance factor
     */
    public int getBalance() { 
        int leftHeight = -1;

        // If left subtree height not null, grab it.
        // Otherwise, keep leftHeight as -1.
        if (left != null) { 
            leftHeight = left.height;
        }

        int rightHeight = -1; 

        // If right subtree height not null, grab it.
        // Otherwise, keep rightHeight as -1.
        if (right != null) { 
            rightHeight = right.height;
        }

        // Calculate BF
        return leftHeight - rightHeight;
    }

    /* Method: updateHeight()
     *
     * Input: none
     * 
     * Output: none, changes field of self
     * 
     * Desc: Updates height by subtracting (leftHeight - rightHeight). 
     * If either child is null, its spot in the equation is filled by -1.
     */
    public void updateHeight() { 
        int leftHeight = -1;
        if (left != null) { 
            leftHeight = left.height;
        }

        int rightHeight = -1;
        if (right != null) { 
            rightHeight = right.height;
        }

        height = Math.max(leftHeight, rightHeight) + 1;
    }

    /* Method: setChild()
     *
     * Input: Child, Node<T> - Which child of which node?
     * 
     * Output: boolean - set operation was successful/failed
     * 
     * Desc: Calls updateHeight()
     */
    public boolean setChild(Child whichChild, Node<T> child) { 
        if (whichChild == Child.LEFT) { 
            left = child; 
        } else { 
            right = child;
        }

        if (child != null) { 
            child.parent = this;
        }

        updateHeight();
        return true;
    }

    /* Method: replaceChild
     *
     * Input: Node<T>, Node<T> - existing node, new node to replace
     * it with
     * 
     * Output: boolean - replace was successful/failed
     *
     */
    public boolean replaceChild(Node<T> currentChild, Node<T> newChild) { 
        if (left == currentChild) { 
            return setChild(Child.LEFT, newChild);
        } else if (right == currentChild) { 
            return setChild(Child.RIGHT, newChild);
        }

        return false;
    }

}
