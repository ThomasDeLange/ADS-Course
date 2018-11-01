package com.company.Queue;

public class LinkedQueueOfStrings implements QueueOfStrings{

    private Node first, last;

    private class Node{
        //Private inner class
        String item;
        Node next;
    }

    public void enqueue(String item) {
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

    public String dequeue() {
        //Get the item of the first node
        //Set the first node to the next node
        //If the stack is empty set the last node to null
        //Else return the item

        String item = first.item;
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
