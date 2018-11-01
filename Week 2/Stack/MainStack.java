package com.company.Stack;

import edu.princeton.cs.algs4.StdIn;

public class MainStack {

    public static void main(String[] args) {

        /*
        inputstring extists of words and "-"
        Every word will be added to the stack and for every "-" the first word will be added to the print string
        Example: 1 2 3 4 5 - - - - - quit
        Outcome: 5 4 3 2 1
        Example: 1 2 5 - 3 4 - - - - quit
        Outcome: 5 4 3 2 1
        Example: 5 - 4 - 3 - 2 - 1 - quit
        Outcome: 5 4 3 2 1
         */

        /*
        LinkedStack has constant time at worst, Is a little slower
        ResizingArrayStack has constant time average, Is a little faster


         */

//        LinkedStackOfStrings stack = new LinkedStackOfStrings();
//        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();

        ArrayStackOfStrings stack = new ArrayStackOfStrings(12);
        String outputString = "";
        while (!StdIn.isEmpty()) {

            String s = StdIn.readString();
            if (s.equals("-")) {
                outputString += " " + stack.pop();
            }else if(s.equals("quit")){
                System.out.println(outputString);
            }else {
                stack.push(s);
            }
        }

    }
}
