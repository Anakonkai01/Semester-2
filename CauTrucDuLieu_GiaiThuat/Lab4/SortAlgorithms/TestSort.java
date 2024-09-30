package SortAlgorithms;

import java.util.*;
public class TestSort {
    public static void main(String[] args) {
        Random rand = new Random();
        Stack<Integer> myStack = new Stack<>();
        for(int i = 10; i > 0; i--){
            int ran = rand.nextInt(100);
            myStack.push(ran);
        }
        System.out.println(myStack);
        SortAlgorithms.sortStack(myStack);
        System.out.println(myStack);
    }
}
