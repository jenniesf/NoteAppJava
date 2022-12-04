package org.example;

import java.util.HashMap;
import java.util.Stack;

public class ClassBalancedBrackets {
    public static boolean checkBrackets(String str) {

        Stack<Character> stack = new Stack<>();  // stack is last in first out

        HashMap<Character, Character> pairMap = new HashMap<>(); // add key value pairs
        pairMap.put(')' , '(');
        pairMap.put('}' , '{');
        pairMap.put(']' , '[');
        pairMap.put('>' , '<');

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            System.out.println("currChar: " + currChar);
            // check if open pair, add to stack
            if ( pairMap.containsValue(currChar)) {
                stack.push(currChar);
            } else if ( pairMap.containsKey(currChar) ) { // if a closing item
                if(stack.isEmpty() && i==str.length()-1) return true;
                if(stack.isEmpty() && i!=str.length()-1) return false;
                char popped = stack.pop();
                System.out.println(popped);
                char matchingPair = pairMap.get(currChar);
                System.out.println(stack);
                if ( popped != matchingPair ) {
                    return false;
                }
            }
        }
        // System.out.println(stack);
        return stack.isEmpty();
    }
}

//  < ( { ) } >
// ( { } ) >
//  ( { } ) >
// ) (