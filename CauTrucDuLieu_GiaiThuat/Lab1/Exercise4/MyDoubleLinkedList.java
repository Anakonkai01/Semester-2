package Exercise4;

public class MyDoubleLinkedList {
    private Node head;
    private Node tail;

    // addFirst 
    public void addFirst(double data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    // addLast
    public void addLast(double data){
        Node newNode = new Node(data);

        if(tail == null){
            head = tail = newNode;
        }
        else{
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // removeFIrst
    public void removeFirst(){
        if(head == null) return;
        if(head == tail){
            head = tail = null;
            return;
        } // only 1 node 


        head = head.getNext();
        head.setPrev(null);
    }

    public void removeLast(){
        if(tail == null) return;
        if(head == tail){
            head = tail = null;
            return;
        } // only 1 node 

        tail = tail.getPrev();
        tail.setNext(null);
    }

    public void removeSpecific(double data){
        if(head == null) return;

        Node curr = head;

        while(curr.getNext() != null && curr.getData() != data){
            curr = curr.getNext();
        }
        
        if(curr == head){
            removeFirst();
            return;
        }

        if(curr == tail){
            removeLast();;
            return;
        }

        if(curr.getPrev() != null){
            curr.getPrev().setNext(curr.getNext());
        }
        
        if(curr.getNext() != null){
            curr.getNext().setPrev(curr.getPrev());
        }
    }

    // print
    public void printListForward(){
        Node curr = head;
        while(curr.getNext() != null){
            System.out.print(curr.getData()+ "->");
            curr = curr.getNext();
        }
        System.out.println("null");
    }

    public void printListBackward(){
        Node curr = tail;
        while(curr.getPrev() != null){
            System.out.print(curr.getPrev()+" ");
            curr = curr.getPrev();
        }
        System.out.println("null");
    }
}
