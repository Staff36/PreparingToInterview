package linkedlists;

public class Node<T> {

    private Node next;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public boolean hasNext(){
        return next != null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
