package Sorting;

import edu.princeton.cs.algs4.Insertion;

public class MergeSort {

    private static Comparable[] aux;

    //Copy the half half sorted array to an aux array
    //Set a pointer to the first element of the first array
    //Set a pointer to the first and second half of the aux array
    //Compare the two aux pointers and put the lowest in the old array
    //If an element is added, increase the k pointer and the pointer where the element got from
    //If the two pointers point to the same values, pick the first and increace that pointer
    //Repeat

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

    //Compute the middle
    //Sort the first half
    //Sort the second half
    //Merge
    private static void sort(Comparable[] a, Comparable[] aux, int low, int high){
        //To avoid mergesorting small array's use for array's smaller than 8 the insertion sort
        if (high <= low + 8 -1) {
            Insertion.sort(a, low, high);
            return;

        }
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid+1, high);
        //If the biggest of the birst is lower than the lowest of the second it is already sorted.
        if (!less(a[mid+1], a[mid])) return;
        merge(a, low, mid, high);
    }

    //The public sort api
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length);
    }


    private static boolean less(Comparable v, Comparable w){
        //CompareTo returns -1 if w is bigger then v
        //So if the value of compareTo is less then 0 less is true
        //All other cases are false
        return v.compareTo(w) < 0;
    }

}

