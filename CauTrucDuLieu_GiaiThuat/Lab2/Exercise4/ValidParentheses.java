package Lab2.Exercise4;

import Lab2.implementStack.MyStack;

public class ValidParentheses {

    public static boolean checkValidParentheses(String str){
        MyStack<Character> myStack = new MyStack<>();

        for(char c : str.toCharArray()){
            // if open parenthesic => add it to stack
            if(c == '(' || c == '{' || c == '['){
                myStack.push(c);
            }
            // if close parenthesic => pop and check
            else if(!myStack.isEmpty() && myStack.getPeek() == '(' && c  == ')'){
                myStack.pop();
            }
            else if(!myStack.isEmpty() && myStack.getPeek() == '[' && c  == ']'){
                myStack.pop();
            }
            else if(!myStack.isEmpty() && myStack.getPeek() == '{' && c  == '}'){
                myStack.pop();
            }
            else{ 
                return false;
            }
        }

        return myStack.isEmpty(); // if stack empyt => trueeee
    }


    public static void main(String[] args) {
        String str1 = "()()()";
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([{}])";

        System.out.println(checkValidParentheses(str1));
        System.out.println(checkValidParentheses(s1));
        System.out.println(checkValidParentheses(s2));
        System.out.println(checkValidParentheses(s3));
    }
}
