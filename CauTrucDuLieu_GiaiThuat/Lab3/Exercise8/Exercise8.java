package Lab3.Exercise8;

import java.util.LinkedList;


public class Exercise8 {
    // nam ben BasicLinkedList
    
    public static void main(String[] args) {
        BasicLinkedList<Integer> myList = new BasicLinkedList<>();
        myList.addLast(1);;
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);

        System.out.println(myList.countEvenNumber(myList.getHead()));
        System.out.println(myList.summAllNumber(myList.getHead()));
    }
}
