package Stack;

public class ArrayStack<T> implements Stack<T> {

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
}


