package Stack;


public class ResizingArrayStack<T> implements Stack<T> {

    //An array wich stores the items
    private T[] s;
    //The current index where a new item can co
    //The previous index (--N) contains the last item
    private int N = 0;

    public ResizingArrayStack(){
        s = (T[]) new Object[1];
    }

    public boolean isEmpty(){
        //Check if N has moved a place a.k.a. index 0 has an item
        return N == 0;
    }

    public void push(T item) {
        //If the array is full, double it
        if (N == s.length) resize(2*s.length);

        //Set the value of the current index in the array to the item
        //Then increase the value of N
        s[N++] = item;

        //s[n] = item;
        //N++;
    }


    public T pop(){
        //Return the item one place before the current index en set the value to null for efficient memory
        T item = s[--N];
        s[N] = null;

        //If the array a quarter full, halve it
        if (N > 0 && N == s.length/4) resize(s.length/2);

        return item;

        //N--;
        //T item = s[N]
        //s[N] = null;
        //return item;
    }

    private void resize(int capacity){

        //Create a new T with a the new capacity
        //Loop trough the s array and put all the values in the copy array
        //The copy becomes s
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
}
