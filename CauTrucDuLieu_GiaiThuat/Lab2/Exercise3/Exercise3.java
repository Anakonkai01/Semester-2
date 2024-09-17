package Lab2.Exercise3;

import Lab2.implementStack.MyStack;

public class Exercise3 {

    
    public static void printReverseOrder(String str){        
        MyStack<Character> myStack = new MyStack<>();
        for(char c : str.toCharArray()){
            myStack.push(c);
        }

        while(!myStack.isEmpty()){
            System.out.print(myStack.pop());
        }
    }
    
    
    public static void main(String[] args) {
        String str = "nguyen tran hoang nhan";
        printReverseOrder(str);
    }
}
