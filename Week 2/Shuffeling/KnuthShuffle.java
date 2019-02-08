package Shuffeling;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle {

    public static void shuffle(Comparable[] a){
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
            swap(a, i, r);
        }
    }
    private static void swap(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
