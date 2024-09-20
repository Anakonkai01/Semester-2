package MyLinkedList;

import java.util.*;

public interface ListInterface <E> {
	public boolean isEmpty();
	public int     size();
	public E       getFirst() throws NoSuchElementException; 
	public boolean contains(E item);
	public void    addFirst(E item);
	public E       removeFirst() throws NoSuchElementException;  
	public void    print();
    public void addLast(E item);
    public void addAfter (E y, E x);
	public void addAfter  (ListNode<E> y, ListNode<E> x);
	public void removeAfter(E x);
	public void removeCurr(ListNode<E> Node);

}
