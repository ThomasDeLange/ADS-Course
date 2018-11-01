package Queue;

public class ArrayQueue<T> implements Queue<T> {

    //An array wich stores the items
    private T[] q;
    //The current index where a new item can co
    //The previous index (--tail) contains the last item
    private int tail = 0;
    private int head = 0;
    private int N = 0;

    public ArrayQueue(){
        q = (T[]) new Object[1];
    }

    public boolean isEmpty(){
        //Check if the head and the tail are equal, than the queue is empty
        return tail == head;
    }

    public void enqueue(T item) {
        //If the array is full, double it
        if (tail == q.length) resize(2*q.length);

        //Set the value of the current index in the array to the item
        //Then increase the value of tail
        q[tail++] = item;

        //q[n] = item;
        //tail++;
    }

    public T dequeue(){
        //Return the item currently at the head, set the head to null
        //Increase the head
        T item = q[head];
        q[head] = null;
        head++;

        //If the array a quarter full, halve it
        if (tail > 0 && tail == q.length/4) resize(q.length/2);

        return item;
    }

    private void resize(int capacity){

        //Create a new T with a the new capacity
        //Loop trough the q array and put all the values in the copy array
        //The copy becomes q
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < tail; i++) {
            copy[i] = q[i];
        }
        q = copy;
    }
}
