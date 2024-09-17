package Lab3.Exercise8;
import java.util.*;

public class BasicLinkedList <E> implements ListInterface <E> {
	private ListNode <E> head = null;
	private int num_nodes = 0;

    public ListNode<E> getHead(){
        return head;
    }
	public boolean isEmpty() { return (num_nodes == 0); }

	public int size() { return num_nodes; }

	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("can't get from an empty list");
		else return head.getElement();
	}

	public boolean contains(E item) {
		for (ListNode <E> n = head; n != null; n = n.getNext())
			if (n.getElement().equals(item)) return true;
		return false;
	}
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
 		//ListNode p = new ListNode (item);
		//p.setNext(head);//p.next = head
		//head = p;

		num_nodes++;
	}

    // public void addFirst(E data){
    //     ListNode newNode = new ListNode<E>(data);
    //     newNode.setNext(head);
    //     head = newNode;
    // }

	public E removeFirst() throws NoSuchElementException {
		ListNode <E> ln;
		if (head == null) 
			throw new NoSuchElementException("can't remove from empty list");
		else { 
			ln = head;
			head = head.getNext();
			num_nodes--;
			return ln.getElement();
		}
	}

    // public void removeFirst(){
    //     if(head == null){
    //         return ;
    //     }
    //     else{
    //         head = head.getNext();
    //     }
    // }

	public void print() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("Nothing to print...");

		ListNode <E> ln = head;
		while(ln != null)
        {
			System.out.print(ln.getElement() + " -> ");
            ln = ln.getNext();//i++
		}
		System.out.println("null");
	}
    public void addLast(E item)
    {
        if (head == null)
        {
            addFirst(item);
            return;
        }
        ListNode<E> q = head;
        while (q.getNext() != null) 
        {
            q = q.getNext();    
        }
        ListNode<E> p = new ListNode<E>(item, null);
        //p.setNext(null);
        q.setNext(p);

    }

    // public void addLast (E data){
    //     ListNode<E> newnNode = new ListNode<E>(data,null);
    //     ListNode<E> dummyNode = head;
    //     while (dummyNode != null) {
    //         dummyNode = dummyNode.getNext();
    //     }
    //     dummyNode.setNext(newnNode);;
    // }
    public void addAfter (E y, E x)
    {
        ListNode<E> q = head;
        while (q != null) 
        {
            if(q.getElement().equals(y))
                break;
            q = q.getNext();    
        }
        if(q != null)//found y
        {
            ListNode<E> p = new ListNode<E>(x, null);
            p.setNext(q.getNext());
            q.setNext(p);
        }

    }
	public void addAfter(ListNode<E> y, ListNode<E> x)
	{
		//Find Node y
		ListNode<E> q = head;
        while (q != null) 
        {
            if(q.getElement().equals(y.getElement()))
                break;
            q = q.getNext();    
        }
        if(q != null)//found y
        {
            x.setNext(q.getNext());
            q.setNext(x);
        }

	}
	public void removeAfter(E x){
        ListNode<E> q = head;
        ListNode<E> nodeBefore = null;
        ListNode<E> nodeAfter = null;
        while(q != null){
            nodeBefore = q;
            ListNode<E> nodeRemove = nodeBefore.getNext();
            if(nodeRemove.getElement().equals(x))
            {
                nodeAfter = nodeRemove.getNext();
                break;
            }
            q = q.getNext();
        }

        nodeBefore.setNext(nodeAfter);
    }

    public void removeCurr(ListNode<E> curr){
        ListNode<E> prev = head;
        ListNode<E> current = head;

        
        while (current.getNext() != null) {

            if(current.getElement() == curr.getElement()){
                prev.setNext(current.getNext());
                break;
            }
            prev = current;
            current = current.getNext();    
        }
    }
    
    public void addSortedList(E item){
        ListNode<E> node = head;
        
        if((int)node.getElement() > (int) item){
            addFirst(item);
            return;
        }
        
        ListNode<E> getNode = getNodeBigger(node, item);
        if(getNode == null) addLast(item);
        
        ListNode<E> newNode = new ListNode<>(item);
        newNode.setNext(getNode.getNext());
        getNode.setNext(newNode);
    }

    public ListNode<E> getNodeBigger(ListNode<E> curr, E item){
        if(curr == null) return null;
        if((int)curr.getNext().getElement() > (int) item) return curr;
        return getNodeBigger(curr.getNext(), item);
    }

    // count even number
    // 2.1
    public int countEvenNumber(ListNode<E> curr){
        if(curr == null) return 0;
        if((int) curr.getElement() % 2 == 0) {
            return 1 + countEvenNumber(curr.getNext());
        }
        return countEvenNumber(curr.getNext());
    }
	
    //2.2
    public int summAllNumber(ListNode<E> curr){
        if(curr == null){
            return 0;
        }
        return (int)curr.getElement() + summAllNumber(curr.getNext());
    }
}