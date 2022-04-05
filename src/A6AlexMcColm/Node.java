package A6AlexMcColm;

public class Node <T extends Comparable<T>> implements Comparable<Node<T>> {
    public T key;
    public Node<T> left;
    public Node<T> right;
 
    public Node(T nodeKey) {
       key = nodeKey;
       left = null;
       right = null;
    }

    

    @Override
    public int compareTo(Node<T> o) {
        // TODO Auto-generated method stub
        return key.compareTo(o.key);
    }
}
