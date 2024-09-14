import java.util.*;

public class TestBasicLinkedList1 {
	public static void main(String [] args) 
		                   throws NoSuchElementException {
		BasicLinkedList <Integer> list = new BasicLinkedList <Integer>();
		list.addFirst(5);
		list.addFirst(6);
		list.addFirst(1);
		list.addFirst(10);
		list.addFirst(8);

		list.print();
		
	}
}
