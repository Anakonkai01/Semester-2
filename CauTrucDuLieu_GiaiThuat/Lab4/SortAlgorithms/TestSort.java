package Lab4.SortAlgorithms;


public class TestSort {
    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 6, 7};
        
        SortAlgorithms.quickSort(a,0,a.length -1);
        for(int i: a){
            System.out.println(i);
        }
    }
}
