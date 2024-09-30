package SortAlgorithms;

import Lab2.implementStack.MyStack;
import Lab2.implementStack.StackInterface;

import java.util.*;
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

    // can chung minh tinh dung dan cua thuat toan 6
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


    // xem lai va mo phong de hieu 
    public static void insertionSort(int[] a){
        for(int i = 1; i < a.length; ++i){
            int key = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j--;
                a[j+1] = key;
            }
        }
    }


    static void merge(int[] a,int l, int m, int r){
        int size1 = m - l + 1;
        int size2 = r - m;

        int[] LArray = new int[size1];
        int[] RArray = new int[size2];

        for(int i = 0; i < size1; i++){
            LArray[i] = a[l + i];
        }
        for(int j = 0; j < size2; j++){
            RArray[j] = a[m + 1 + j];
        }

        int i = 0; int j = 0;
        int k = l;
        while(i < size1 && j < size2){
            if(LArray[i] <= RArray[j]){
                a[k] = LArray[i];
                i++;
            }
            else{
                a[k] = RArray[j];
                j++;
            }
            k++;    
        }

        while (i < size1) {
            a[k] = LArray[i];
            i++; k++;
        }
        while(j < size2){
            a[k] = RArray[j];
            j++; k++;
        }
    }
    public static void mergeSort(int[] a, int l, int r){
        if(l < r ){
            int m = (l + r)/2;

            mergeSort(a, l, m);
            mergeSort(a, m+1, r);
            
            merge(a, l, m, r);
        }
    }
    


    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static int partition(int[] a, int l, int r){
        // choose the last is the pivot
        int pivot = a[r];
        // create the index that smaller than the pivot
        int i = l - 1;
        // move smaller element to the left of the partition
        for(int j = l; j < r; j++){
            if(a[j] < pivot){
                i++;
                swap(a, i, j);
            }
        }

        //swap the smaller index with the pivot 
        swap(a, i + 1, r);
        // return the new pivot
        return i + 1;

    }

    public static void quickSort(int [] a, int l, int r){
        if( l < r){
            int pivot = partition(a,l,r);

            quickSort(a, l, pivot - 1);
            quickSort(a, pivot + 1, r); 
        }
    }

    

//    static void insertElementStack(MyStack<Integer> myStack, Integer dataPrev) {
//
//        if (dataPrev != null) {
//            // If the stack is empty, just push the element back
//            if (myStack.isEmpty()) {
//                myStack.push(dataPrev);
//                return ;
//            }
//
//            // Compare with the top of the stack and insert in sorted order
//            if (myStack.getPeek() > dataPrev) {
//                int temp = myStack.pop(); // Temporarily remove the top
//                insertElementStack(myStack, dataPrev); // Recur to insert
//                myStack.push(temp); // Push the temporarily removed element back
//            } else {
//                // If it's already in the correct order, just push it back
//                myStack.push(dataPrev);
//            }
//        }
//
//    }
//    public static void StackSort(MyStack<Integer> myStack, boolean check) {
//        // Base case: If the stack is empty, return
//        if (myStack.isEmpty()) {
//            return;
//        }
//
//        // Pop the top element
//        Integer dataPrevious = myStack.pop();
//
//        // Sort the remaining stack
//        StackSort(myStack);
//
//        // Insert the popped element back in sorted order
//        insertElementStack(myStack, dataPrevious);
//    }


    public static void insertStack(Stack<Integer> myStack, int element){
        if(myStack.isEmpty() == true || myStack.peek() < element){
            myStack.push(element);
        }
        else{
            int temp = myStack.pop();
            insertStack(myStack, element);
            myStack.push(temp);
        }
    }


    public static void sortStack(Stack<Integer> myStack){
        if(myStack.isEmpty()){
            return;
        }

        int e = myStack.pop();
        sortStack(myStack);
        
        insertStack(myStack, e);
    }

    

    // author Le Minh Nhut 
}

