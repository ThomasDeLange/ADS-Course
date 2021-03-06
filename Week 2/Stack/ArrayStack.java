package Stack;

import java.util.Iterator;

//Implement interface for stack with generic
//implement interface so client can iterate trough list

public class ArrayStack<T> implements Stack<T>, Iterable<T> {

    //An array wich stores the items
    private T[] s;
    //The current index where a new item can co
    //The previous index (--N) contains the last item
    private int N = 0;

    public ArrayStack(int capacity){
        s = (T[]) new Object[capacity];
    }

    public boolean isEmpty(){
        //Check if N has moved a place a.k.a. index 0 has an item
        return N == 0;
    }

    public void push(T item){
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
        return item;

        //N--;
        //T item = s[N]
        //s[N] = null;
        //return item;
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


