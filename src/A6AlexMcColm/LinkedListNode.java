package A6AlexMcColm;

public class LinkedListNode<T extends Comparable<T>> {
    public T data;
    public LinkedListNode<T> next;
    public LinkedListNode<T> previous;
 
    public LinkedListNode(T initialData) {
       data = initialData;
       next = null;
       previous = null;
    }

    public void printData() {
        System.out.println(data.toString());
    }

    public T getData() { return data; }

    public int compareTo(LinkedListNode<T> otherNode) {
        return data.compareTo(otherNode.getData());
    }
}