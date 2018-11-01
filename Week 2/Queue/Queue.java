package Queue;

public interface Queue<T> {

    T dequeue();
    void enqueue(T item);
    boolean isEmpty();
}
