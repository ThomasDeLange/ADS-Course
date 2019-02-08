package Sorting;

public class Selection {

    //Performance: ~1/2 N ^2 (Half of everything is examined.
    //Minimum number of swaps: in one swap per entry everything is at its place

    public static void sort(Comparable[] a){

        //Check the whole array right of index i.
        //If there is a value smaller thant the value of the index i swap it
        //Else do nothing

        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = 0; i+1 < N; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            swap(a, i, min );
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
