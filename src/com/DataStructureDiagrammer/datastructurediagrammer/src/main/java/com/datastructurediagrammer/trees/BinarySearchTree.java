package com.datastructurediagrammer.trees;

public class BinarySearchTree<T extends Comparable<T>> {
    public BSTNode<T> root;

    public BinarySearchTree() { 
        root = null;
    }

    public void insert(T newData) { 
        BSTNode<T> newNode = new BSTNode<T>(newData);
        BSTNode<T> currentNode = root;
        if (root == null) { 
            root = newNode;
            return;
        }
        while (currentNode != null) { 
            if (newNode.compareTo(currentNode) < 0) { 
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    currentNode = null;
                } else { 
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) { 
                    currentNode.right = newNode;
                    currentNode = null;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    // TODO: finish implementing remove algorithm
    public void remove(T dataRemove) { 
        BSTNode<T> currentNode = this.search(dataRemove);
        // Case 1: Leaf node
        if ((currentNode.left == null) || (currentNode.right == null)) { 
            currentNode = null;
        }
        // Case 2: Internal node with one child
        if ((currentNode.left == null)) { 

        }
    }

    public BSTNode<T> search(T searchKey) { 
        BSTNode<T> currentNode = root;
        while (currentNode != null) { 
            if (currentNode.getData() == searchKey) { 
                return currentNode;
            } else if (currentNode.getData().compareTo(searchKey) < 0) { 
                currentNode = currentNode.left;
            } else if (currentNode.getData().compareTo(searchKey) > 0) { 
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    public void printInOrder(BSTNode<T> node) { 
        if (node == null) { 
            return;
        }
        printInOrder(node.left);
        System.out.println(node.getData() + " ");
        printInOrder(node.right);
    }

    public int getHeight() {
        if (root == null) { 
            return 0;
        } else { 
            return maxDepth(this.root) + 1;
        }
    }

    public int maxDepth(BSTNode<T> node) { 
        if (node == null ) { return -1; }
        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);
        int maxDepth = Math.max(leftHeight, rightHeight) + 1;
        return maxDepth; 
    }

    public int getTotalNodes() { 
        return countNodes(0, root);
    }

    private int countNodes(int count, BSTNode<T> node) {
        if (node == null) { 
            return 0;
        } else {
            return countNodes(count, node.left) + count + 1 + countNodes(count, node.right);
        }
    }
}