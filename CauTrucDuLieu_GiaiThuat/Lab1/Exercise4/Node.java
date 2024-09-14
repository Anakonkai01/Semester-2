package Exercise4;

public class Node {
    private double data;
    private Node next;
    private Node prev;

    public Node(){
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
    
    public Node(double data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    

    
}