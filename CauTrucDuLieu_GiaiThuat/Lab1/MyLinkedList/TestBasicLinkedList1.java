package MyLinkedList;

import java.util.*;

public class TestBasicLinkedList1 {
	public static void main(String [] args) 
		                   throws NoSuchElementException {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		list.addFirst(8);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		list.addSortedList(6);
		list.print();
		
	}
}
