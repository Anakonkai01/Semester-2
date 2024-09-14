package Lab2.implementQueue;

public class MyQueue <E> {
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

    }

    @Override
    public E deQueue(){

        E dataRemove = ;
        return dataRemove;
    }

    @Override
    public int size(){
        return numNode;
    }

    @Override
    public boolean contains(E item){

    }

    @Override
    public boolean isEmpty(){
        return;
    }

    public E getFront(){
        return front.getData();
    }

    
}
