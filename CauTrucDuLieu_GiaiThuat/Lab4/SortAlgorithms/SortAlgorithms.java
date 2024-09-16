package Lab4.SortAlgorithms;

public class SortAlgorithms {
    public static void selectionSort(int[] a){        
        for(int i = 0; i < a.length - 1; ++i){
            int minIndex = i;
            for(int j = i + 1; j < a.length; ++j){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }

            // swap
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    // can chung minh tinh dung dan cua thuat toan 
    public static void bubbleSort(int[] a){
        for(int i = 0; i < a.length - 1; ++i){
            for(int j = 0; j < a.length - i - 1; ++j){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] a){

    }

    public static void mergeSort(int[] a){

    }

    public static void quickSort(int [] a){

    }
}
