package A7AlexMcColm;

/* Class: BSTNode
 * 
 * Desc: Node class for BSTs.
 */
public class BSTNode<T> {
   // Members
   public T key;
   public BSTNode<T> left;
   public BSTNode<T> right;

   // Constructor with key
   public BSTNode(T nodeKey) {
      key = nodeKey;
      left = null;
      right = null;
   }
}