package Lab2.Exercise1;

import Lab2.implementQueue.MyQueue;
import Lab2.implementStack.MyStack;

public class Fraction{
    private int numer;
    private int denom;

    public Fraction(){
        this.numer = 0;
        this.denom = 1;
    }

    public Fraction(int x, int y){
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction fraction){
        this.numer = fraction.numer;
        this.denom = fraction.denom;
    }

    @Override
    public String toString() {
        return "Fraction [numer=" + numer + ", denom=" + denom + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
    
}

class test{
    public static void main(String[] args) {
        MyStack<Fraction> listOfFraction = new MyStack<>();
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(3,4);
        listOfFraction.push(f1);
        listOfFraction.push(f2);

        listOfFraction.print();

        listOfFraction.pop();
        listOfFraction.print();

        MyQueue<Fraction> listofQueue = new MyQueue<>();
        listofQueue.enQueue(f1);
        listofQueue.enQueue(f2);

        listofQueue.print();
        listofQueue.deQueue();
        listofQueue.print();

    }
}