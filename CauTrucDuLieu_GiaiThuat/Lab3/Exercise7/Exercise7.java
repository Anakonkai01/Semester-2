package Lab3.Exercise7;

public class Exercise7 {
    // a
    public static int minimum(int[] a, int size){
        int min = a[0];
        for(int i: a){
            if(i < min) min = i;
        }
        return min;
    }

    // b
    public static int sumAllElement(int []a,int size){
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }

    // c
    public static int countEvenNumber(int[] a,int size){
        int countEven = 0;
        for(int i : a){
            if(i % 2 == 0) countEven++;
        }
        return countEven;
    }

}
