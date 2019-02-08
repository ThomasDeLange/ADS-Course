package Sorting;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    //Best case compares: ~n log(n)
    //Worst case compares: ~1/2 n^2

    public static int partition(Comparable[] a, int low, int high){

        //Sorting:
        //Get the first value, you want to put that in the middle
        //If right of the middle there is a value bigger than the begin value, prepare for swap
        //if left of the middle there is a value lower than the begin value, prepare for swap
        //If there is no lower of higer, move the pointer a step up or down
        //When two swappables are found, swap.
        //Repeat

        //When the first is done, left and right of the first value are two new arrays that need to be sorted
        //LEFT:
        //Get the first value and put it in the middle, repeat first steps
        //LEFT OF LEFT
        //Get the first value and put it in the middle, repeat first steps
        //LEFT OF LEFT OF LEFT
        //Get the first value and put it in the middle, repeat first steps

        //ETCETERA
        //Same for right

        int i = low, j = high;
        //repeat
        while(true) {
            //Find item on the left to swap
            while(less(a[++i], a[low])){
                if (i == high){
                    break;
                }
            }

            //find item on right to swap
            while(less(a[low], a[--j])){
                if (j == low){
                    break;
                }
            }

            //Check if pointers cross
            if (i >= j){
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        //This item is in place
        //All left is smaller
        //All right is bigger
        return j;
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length -1);
    }

    private static void sort(Comparable[] a, int low, int high){
        if (high <= low + 10) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static boolean less(Comparable v, Comparable w){
        //CompareTo returns -1 if w is bigger then v
        //So if the value of compareTo is less then 0 less is true
        //All other cases are false
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
