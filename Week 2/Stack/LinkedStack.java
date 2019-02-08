package Stack;

//Every operation is constant

import java.util.Iterator;

//Implement interface for stack with generic
//implement interface so client can iterate trough list

public class LinkedStack<T> implements Stack<T>, Iterable<T> {


    //Set the first node to null so if nothing is added it is empty
    private Node first = null;

    private class Node{
        //Private inner class
        T item;
        Node next;
    }

    public boolean isEmpty(){
        //Test if the first node is null
        return first == null;
    }

    public void push(T item) {
        //Made the first node the oldfirst,
        // create a new node wich is the first,
        // set the item to the first,
        // set the next to the old first wich is now the second node

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public T pop(){

        //Get the item,
        // set the first to the next node,
        // return the item
        T item = first.item;
        first = first.next;
        return item;
    }

    //Use this class to return when client wants to iterate
    private class ListIterator implements Iterator<T> {

        //Set the current node to the first so we can start at the beginning
        private Node current = first;

        //If the current node is null the end is reached
        @Override
        public boolean hasNext() {
            return current != null;
        }


        //Get the current item and set the current to the next item
        @Override
        public T next() {
            T t = current.item;
            current = current.next;
            return t;
        }
    }

    // This function returns the ListIterator
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


}
