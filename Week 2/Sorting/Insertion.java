package Sorting;

public class Insertion {


    //Performance: ~1/4 N ^2 (about a quarter of everything is examined).
    //Swaps: ~1/4 N ^2 (about a quarter of everything is swapped)
    //This is only if a array is randomly sorted
    //When the array is partly sorted the algorithm is more efficient

    //Worst case performance: ~1/2 n^2
    //Worst case exchanges: ~1/2 n^2
    //In worst case selection sort is faster because of less exchanges

    //Partially sorted: linear

    public static void sort(Comparable[] a){

        //Start at the left and move one place (index i)
        //See if the value at index j is less than the value at index j-1
        //If it's lower than the item left of it swap it (repeat)
        //If the item left of it is lower of equal don't swap and move index i with one to the right
        
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < 0; j--) {
                if (less(a[i], a[j])){
                    swap(a, j, j-1);
                } else {
                    break;
                }
                
            }
        }

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
