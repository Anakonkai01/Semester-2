package Exercise2;


public class exercise2{
    public void removeCurr(ListNode<E> curr){
        ListNode<E> prev = head;
        ListNode<E> current = head;
        while (current.getNext() != null) {

            if(current.getElement() == curr.getElement()){
                prev.setNext(current.getNext());
                break;
            }
            prev = current;
            current = current.getNext();    
        }
    }
}