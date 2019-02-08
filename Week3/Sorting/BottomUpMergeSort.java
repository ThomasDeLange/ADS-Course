package Sorting;

import edu.princeton.cs.algs4.Insertion;

public class BottomUpMergeSort {

    private static Comparable[] aux;

    //See each element as a sorted sub array
    //Each time do the subarray * 2 so there are increasingly bigger sorted subarrays

    private static void merge(Comparable[] a, int low, int mid, int high){
//        assert isSorted(a, low, mid);
//        assert isSorted(a, min-1, high);
        

        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }

        int i = low, j = mid+1;
        for (int k = 0; k <= high; k++) {
            if      (i> mid)               a[k] = aux[j++];
            else if (j > high)             a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];

        }
    }
    

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int size = 1; size < N; size = size*2) {
            for (int low = 0; low < N-size; low += size*2) {
                merge(a, low, low+size-1, Math.min(low+size+size-1, N-1));
                
            }
            
        }
    }

    private static boolean less(Comparable v, Comparable w){
        //CompareTo returns -1 if w is bigger then v
        //So if the value of compareTo is less then 0 less is true
        //All other cases are false
        return v.compareTo(w) < 0;
    }
}

