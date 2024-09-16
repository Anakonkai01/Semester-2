package Lab3.Exercise6;

public class Exercise6 {
    // a
    public static int minimumRecursive(int[] a, int size) {
        if (size == 1) {
            return a[0];
        }

        int minRest = minimumRecursive(a, size - 1);

        return Math.min(a[size - 1], minRest);
    }

    // b
    public static int sumAllElement(int[] a, int size){
        if(size == 1){
            return a[0];
        }

        return a[size-1] + sumAllElement(a, size-1);
    }

    // c
    public static int countEvenNumber(int[] a, int size){
        if(size == 0){
            return 0;
        }
        if(a[size - 1] % 2 == 0){
            return 1 + countEvenNumber(a, size-1);
        }
        return countEvenNumber(a, size-1);
    }
    public static void main(String[] args) {
        // int[] a = {5,3,1,2};
        // System.out.println(minimumRecursive(a, a.length));

        // int[] a = {1,2,3,4,5};
        // System.out.println(sumAllElement(a, a.length));

        int[] a = {1,2,3,4};
        System.out.println(countEvenNumber(a, a.length));
    }
}
