package SortAlgorithms;


import Lab2.implementStack.MyStack;

public class TestSort {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(12);
        myStack.push(11);
        myStack.push(6);
        myStack.push(4);
        myStack.push(5);
        SortAlgorithms.StackSort(myStack);

        myStack.print();
    }
}
