package org.example;

public class BalancedParentheses {
    public static void main(String[] args) {

        String[] str = { "(" , "(" , "(", ")" , ")" , ")"}; // true
        String[] str2 = { "(" , "(" , ")" , "(" , ")", ")"};     // false
        String[] str3 = { "(" , "(" , ")" , ")" , ")"};    // false
        System.out.println( checkBalance(str) );
        System.out.println( checkBalance(str2) );
        System.out.println( checkBalance(str3) );
    }

    public static boolean checkBalance(String[] str){
        // stacks are LIFO last in first out
        // ( ( ( ) ) )   true
        // (( ))) false

        String[] stack = new String[str.length]; // create empty stack
        int stackCounter = 0;
        // System.out.println(Arrays.toString(stack));

        for (int i = 0; i < str.length ; i++) {
            var curr = str[i];
            if ( curr == "(") {
                stackCounter++;
            } else {
                // pop it off
                stackCounter--;
            }
        }
        // System.out.println( stackCounter );
        return stackCounter == 0 ? true : false;  // if zero its true, if more than or neg, its false
    }
}
// Write a function that takes in a string and returns true or false
// depending on whether that string has balanced parentheses.
// A string has balanced parantheses if every opening paranthesis “(“ has
// a matching closing paranthesis “)” that closes the corresponding opening paranthesis.
//
// For the purposes of this problem, you only need to worry about
// parentheses “(“and “)”, not other opening-and-closing marks, like
// curly brackets, square brackets, or angle brackets.