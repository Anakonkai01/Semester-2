package Lab2.implementQueue;

public interface QueueInterface <E> {
    void enQueue(E item);
    E deQueue();
    int size();
    boolean contains(E item);
    void print();
    boolean isEmpty();
    E getFront();
}
