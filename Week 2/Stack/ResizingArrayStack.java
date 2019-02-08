package Stack;


import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T>, Iterable<T> {

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

    // Function wich returns the iterator
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    //The iterator that will get returned
    //It's backwards because the last item added is at the end and the fist item added at the start
    private class ReverseArrayIterator implements Iterator<T>{

        //Get the index of the item
        private int i = N;

        //If the index is above 0 there are still numbers to the left
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        //Start at the end, give that node, make the current index one lower
        @Override
        public T next() {
            return s[--i];
        }
    }
}
