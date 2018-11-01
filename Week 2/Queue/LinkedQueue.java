package Queue;

public class LinkedQueue<T> implements Queue<T> {

    private Node first, last;

    private class Node{
        //Private inner class
        T item;
        Node next;
    }

    public void enqueue(T item) {
        //Set the node oldLast to last
        //Make a new last node with the item
        //Set the next for the last to be null (since it's the last)
        //if the stack is empty the last is the first
        //else set the next to oldLast (wich was null) to the last

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
    }

    public T dequeue() {
        //Get the item of the first node
        //Set the first node to the next node
        //If the stack is empty set the last node to null
        //Else return the item

        T item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        return item;

    }

    public boolean isEmpty() {
        return first == null;
    }
}
