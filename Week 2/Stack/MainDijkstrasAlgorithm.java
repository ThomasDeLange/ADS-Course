package Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MainDijkstrasAlgorithm {

    public static void main(String[] args) {

        //Create two stacks, one for the values one for the operators

        LinkedStack<String> operators = new LinkedStack<String>();
        LinkedStack<Double> values = new LinkedStack<Double>();

        while(true){

            //Get the string
            String s = StdIn.readString();

            //If EXIT then stop
            if (s.equals("EXIT")) break;

            //Skip the (
            //If there is a + or * add it to the operators
            //If there is a ) pop the two values and operator and operate it with the operator
            //Push this value to the value stack
            if (s.equals("(")) { }
            else if (s.equals("+")){ operators.push(s); }
            else if (s.equals("*")){ operators.push(s);}
            else if (s.equals(")")){
                String operator = operators.pop();
                    if (operator.equals("+")) {values.push(values.pop() + values.pop());}
                    else if (operator.equals("*")) {values.push(values.pop() * values.pop());}

                }
                else { values.push(Double.parseDouble(s));}
        }
        StdOut.println(values.pop());
    }
}

//     ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) EXIT