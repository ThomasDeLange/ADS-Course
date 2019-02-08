package Sorting;

public class Shell {



    public static void sort(Comparable[] a){

        //worst case = 0(N ^ 3/2)

        //Start at the left and move left bij h places (index i)
        //See if the value at index j is less than the value at index j-h
        //If it's lower than the item at index j-h of it swap it (repeat)
        //If the item at index j-h of it is lower of equal don't swap and move index i with h to the right

        //While you can divide n by 3 calculate the h-factor 4, 13, 40, 121, 364 ...
        //if you can't devide the array by 3 use 1 as the h-factor
        //This way the whole array gets sorted at the normal insertion way

        //Because you did multiple insertion sorts with multiple h's
        //The next iteration always goes fast because it does not have to move the rest of the values so much

        int N = a.length;

        int h = 1;
        while (h < N/3) h = 3 * h + 1;

        while(h >- 1){
            for (int i = h = 0; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j++) {
                    swap(a, j, j-h);

                }

            }
            h = h/3;
        }


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
