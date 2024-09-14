package Lab2.Exercise2;

import Lab2.implementStack.MyStack;

public class Exercise2 {

    
    
    
    // recursion
    public static long computeFunctionP_UsingRecursion(int n){
        if(n == 1){
            return 3;
        }
        return (long) (Math.pow(2, n) + n*n + computeFunctionP_UsingRecursion(n - 1));
    }

    // stack
    public static long computeFunctionP_UsingStack(int n){
        MyStack<Long> myStack = new MyStack<>();
        
        long res = 0;
        while(n > 1){
            long temp = (long) (Math.pow(2, n) + n*n);
            myStack.push(temp);
            n--;
        }

        while(!myStack.isEmpty()){
            res += myStack.pop();
        }
        return res + 3;
    }

    public static void main(String[] args) {
        int n  = 3;
        System.out.println(computeFunctionP_UsingStack(n));
        
    }
}
