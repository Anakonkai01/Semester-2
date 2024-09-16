package Lab2.Exercise6;

import Lab2.implementQueue.MyQueue;
import Lab2.implementStack.MyStack;

public class CheckPalindrome {

    public static boolean checkPalindrome(String str){
        String s1 = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        MyQueue<Character> myQueue = new MyQueue<>();
        MyStack<Character> myStack = new MyStack<>();
        
        for(char c : s1.toCharArray()){
            myQueue.enQueue(c);
            myStack.push(c);
        }

        while(!myStack.isEmpty()){
            if(myQueue.deQueue() != myStack.pop()) return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        String s1 = "dad";
        String s2 = "A man, a plan, a canal: Panama";
        String s3 = "hehehehbioyyy";

        System.out.println(checkPalindrome(s1));
        System.out.println(checkPalindrome(s2));
        System.out.println(checkPalindrome(s3));
    }
}
