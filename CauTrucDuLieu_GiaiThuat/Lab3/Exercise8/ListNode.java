package Lab3.Exercise8;

class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
	public ListNode(E item) { this(item, null); }
/*{
Element = item;
Next = null;
}*/

	public ListNode(E item, ListNode <E> n) { 
		element = item; 
		next = n;
	}

	/* get the next ListNode */
	public ListNode <E> getNext() { return next; }

	/* get the element of the ListNode */
	public E getElement() { return element; }

	/* set the next reference */
	public void setNext(ListNode <E> n) { next = n ;}
}
