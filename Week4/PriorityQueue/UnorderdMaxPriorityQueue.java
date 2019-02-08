package PriorityQueue;

//Array          | insert | del max | max

//unordered      | 1      | N       | N (this one)
//orderd         | N      | 1       | 1
//Goal           | log(N) | log(N)  | log(N)

public class UnorderdMaxPriorityQueue <Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public UnorderdMaxPriorityQueue(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key x){
        pq[N++] = x;
    }

    public Key delmax(){
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i)){
                max = i;
            }
            swap(pq, max, N-1);
            return pq[--N];
        }
        return pq[max];
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
