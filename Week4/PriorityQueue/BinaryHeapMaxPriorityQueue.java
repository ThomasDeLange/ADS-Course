package PriorityQueue;

//Array          | insert | del max | max

//unordered      | 1      | N       | N
//Binary heap    | log(N) | log(N)  | 1   (this one)
//Goal           | log(N) | log(N)  | log(N)

public class BinaryHeapMaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public BinaryHeapMaxPriorityQueue(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    //Insert key at the last array entry, the most bottom right node on the tree
    //Let it swim up if it is bigger than it's parent
    public void insert(Key key){
        pq[++N] = key;
        swim(N);
    }

    //The max is located at the first array entry or the top of the tree
    //Swap the latest entry with the first, remove the latest entry
    //Let the first entry sink down if it is smaller than a child
    public Key delmax(){
       Key max = pq[1];
       swap(1, N--);
       sink(1);
       pq[N+1] = null;
       return max;
    }

    //The parent of k is located at index k/2 because nodes have 2 childern max
    //If the parent is smaller swap the index with the parent
    //repeat for as long as there are smaller parents
    private void swim(int k){
        while (k > 1 && less(k/2, k)){
            swap(k, k/2);
            k = k/2;
        }

    }

    //The child of k is located at index k*2 because nodes have 2 childern max
    //Swap the parent with the smaller child
    //Repeat for as long there are bigger children
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if (j< N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        //CompareTo returns -1 if w is bigger then v
        //So if the value of compareTo is less then 0 less is true
        //All other cases are false
        return pq[i].compareTo(pq[j]) < 0;
        }

    private void swap(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
