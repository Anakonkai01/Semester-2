package Exercise3;
import MyLinkedList.*;

public class MyBasicLinkedList {
    BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
    
    // a
    public int countEven(){
        int count = 0;
        ListNode<Integer> dummyNode = linkedList.getHead();
        while (dummyNode.getNext() != null) {
            if(dummyNode.getElement() % 2 == 0)count++;
            dummyNode = dummyNode.getNext();
        }
        return count;
    }

    // b
    public int countPrime(){
        int count = 0;
        ListNode<Integer> dummyNode = linkedList.getHead();
        while (dummyNode.getNext() != null) {
            if (checkPrime(dummyNode.getElement())) {
                count++;
            }
            
            dummyNode = dummyNode.getNext();
        }
        return count;
    }
    public boolean checkPrime(int data){
        for (int i = 2; i <= data /2 ; i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }
    // c
    public void addItemBeforeFirstEven(int item){
        ListNode<Integer> dummyNode = null;
        ListNode<Integer> nextDummyNode = linkedList.getHead();

        while (nextDummyNode.getNext() != null) {

            if(nextDummyNode.getElement() % 2 == 0){
                ListNode<Integer> temp = new ListNode<Integer>(item);
                temp.setNext(nextDummyNode);
                assert dummyNode != null;
                dummyNode.setNext(temp);
                break;
            }
            dummyNode = nextDummyNode;
            nextDummyNode = nextDummyNode.getNext();    
        }
    }

    // d
    public int maximumNum(){
        ListNode<Integer> dummyNode = linkedList.getHead();
        int max = dummyNode.getElement();
        while(dummyNode.getNext() != null){
            if(dummyNode.getElement() > max){
                max = dummyNode.getElement();
            }
            dummyNode = dummyNode.getNext();
        }
        return max;
    }

    // E
    public void reverseList(){
        ListNode<Integer> curr = linkedList.getHead();
        ListNode<Integer> prev = null;
        ListNode<Integer> next = null;

        while(curr.getNext() != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
    }

    // F
    

    public static void main(String[] args) {
        MyBasicLinkedList test = new MyBasicLinkedList();
        test.linkedList.addFirst(1);
        test.linkedList.addFirst(2);
        test.linkedList.addFirst(3);
        test.linkedList.addFirst(4);
        test.linkedList.addFirst(5);

        ListNode<Integer> cauA = test.linkedList.getHead().getNext().getNext();
        test.linkedList.print();
        test.linkedList.removeCurr(cauA);
        test.linkedList.print();

        System.out.println();
        System.out.println("A");
        System.out.println(test.countEven());
        System.out.println();
        System.out.println("B");
        System.out.println(test.countPrime());
        System.out.println();
        System.out.println("C");
        test.linkedList.print();
        test.addItemBeforeFirstEven(10000);
        test.linkedList.print();
        System.out.println();
        System.out.println("D");
        System.out.println(test.maximumNum());
        
        System.out.println();
        System.out.println("E:");
        test.reverseList();
        test.linkedList.print();
    }
}
