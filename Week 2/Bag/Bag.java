package Bag;

import java.util.Iterator;

public class Bag<T> implements iBag<T>, Iterable<T> {


    @Override
    public int size() {
        return 0;
    }

    //An array wich stores the items
    private T[] s;
    //The current index where a new item can co
    //The previous index (--N) contains the last item
    private int N = 0;

    public Bag(){
        s = (T[]) new Object[1];
    }

    public void add(T item) {
        //If the array is full, double it
        if (N == s.length) resize(2*s.length);

        //Set the value of the current index in the array to the item
        //Then increase the value of N
        s[N++] = item;

        //s[n] = item;
        //N++;
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
