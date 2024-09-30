package Lab2.Exercise5;


import Lab2.implementStack.MyStack;

public class QueueUsingTwoStacks <E> {
    private MyStack<E> stack1;
    private MyStack<E> stack2;

    public QueueUsingTwoStacks(){
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    // push to stack1
    public void enQueue(E item){
        stack1.push(item);
    }

    // if stack2 is empty then pop all element from stack1 and push to stack2
    public E deQueue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // getFront
    public E getFront(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.getPeek();
    }

    //check empty
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        
        System.out.println(queue.deQueue()); // Output: 1
        System.out.println(queue.getFront());// Output: 2
        System.out.println(queue.deQueue()); // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
        System.out.println(queue.deQueue()); // Output: 3
        System.out.println(queue.isEmpty()); // Output: true
        
    }

}