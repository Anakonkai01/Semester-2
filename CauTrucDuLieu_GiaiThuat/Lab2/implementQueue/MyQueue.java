package Lab2.implementQueue;

public class MyQueue <E> implements QueueInterface <E>{
    private Node<E> front;
    private Node<E> rear;
    private int numNode;

    public MyQueue(){
        this.front = null;
        this.rear = null;
        this.numNode = 0;
    }

    @Override
    public void enQueue(E item){
        Node<E> newNode = new Node<>(item);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.setNext(newNode);
            rear = newNode;
        }
        numNode++;
    }

    @Override
    public E deQueue(){
        if(isEmpty()){
            return null;
        }
        E dataRemove = front.getData();
        front = front.getNext();
        if(front == null){
            rear = null;
        } // which mean the queue is empty
        numNode--;
        return dataRemove;
    }

    @Override
    public int size(){
        return numNode;
    }

    @Override
    public boolean contains(E item){
        Node<E> curr = front;
        while(curr != null){
            if(curr.getData().equals(item)) return true;
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public void print(){
        Node<E> curr = front;
        while(curr != null){
            System.out.println(curr.getData()+"->");
            curr = curr.getNext();
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty(){
        return front == null;
    }

    @Override
    public E getFront(){
        return front.getData();
    }

    
}
