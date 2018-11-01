package com.company.Stack;

//Every operation is constant

public class LinkedStackOfStrings implements StackOfStrings {


    //Set the first node to null so if nothing is added it is empty
    private Node first = null;

    private class Node{
        //Private inner class
        String item;
        Node next;
    }

    public boolean isEmpty(){
        //Test if the first node is null
        return first == null;
    }

    public void push(String item){
        //Made the first node the oldfirst,
        // create a new node wich is the first,
        // set the item to the first,
        // set the next to the old first wich is now the second node

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop(){

        //Get the item,
        // set the first to the next node,
        // return the item
        String item = first.item;
        first = first.next;
        return item;
    }
}
