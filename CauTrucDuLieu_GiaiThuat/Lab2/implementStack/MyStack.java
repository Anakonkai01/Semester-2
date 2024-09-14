package Lab2.implementStack;

public class MyStack <E> implements StackInterface<E>{
    private Node<E> top;
    private int numNode;

    public MyStack(){
        this.top = null;
        this.numNode = 0;
    }

    @Override
    public void push(E item){
        Node<E> newNode = new Node<>(item);
        if(top == null){
            top = newNode;
        }
        else{
            newNode.setNext(top);
            top = newNode;
        }
        numNode++;
    }

    @Override
    public E pop(){
        if(top == null){
            System.out.println("Empty stack!!!");
            return null;
        }
        E elementRemove = top.getElement();
        top = top.getNext();
        numNode--;
        return elementRemove;
    }

    public int size(){
        return numNode;
    }

    @Override
    public boolean contains(E item){
        Node<E> curr = top;
        while(curr != null){
            if(curr.getElement().equals(item)) return true;
            curr = curr.getNext();
        }
        return false;
        
    }

    @Override
    public void print(){
        Node<E> curr = top;
        while(curr != null){
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty(){
        return top == null;
    }

    @Override
    public E getPeek(){
        if(isEmpty()) return null;
        return top.getElement();
    }
}
