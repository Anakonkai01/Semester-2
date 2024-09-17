package Lab4.SortAlgorithms;


public class TestSort {
    public static void main(String[] args) {
        int[] a = {5,3,2,1,2,3,5,6,1,2,35,5,677};
        
        SortAlgorithms.insertionSort(a);
        for(int i: a){
            System.out.println(i);
        }
    }
}
