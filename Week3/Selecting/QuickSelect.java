package Selecting;

import Sorting.QuickSort;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSelect {

    //Pick the first item
    //Partition the array around the first item so its in middle
    //Check wich side k will be
    //Prodeed partitioning that side untill only one value is left

    public static Comparable select(Comparable[] a, int k){
        StdRandom.shuffle(a);

        int low = 0, high = a.length -1;

        while (high > low){
            int j = QuickSort.partition(a, low, high);
            if (j< k) low = j+1;
            else if (j > k) high = j-1;
            else return a[k];
        }
        return a[k];
    }


}
