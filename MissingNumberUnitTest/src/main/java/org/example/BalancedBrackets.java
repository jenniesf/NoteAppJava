package org.example;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "(){}[]<>";
        String str1 = "({[<>]})";
        String str2 = "(){[]}[]<>";
        String str3 = "(){[}[]<>";
        String str4 = ")(";
        System.out.println( checkBrackets(str)); // true
        System.out.println( checkBrackets(str1)); // true
        System.out.println( checkBrackets(str2)); // true
        System.out.println( checkBrackets(str3)); // false
        System.out.println( checkBrackets(str4)); // false
    }

    public static boolean checkBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairMap = new HashMap<>(); // add key value pairs
        pairMap.put(')' , '(');
        pairMap.put('}' , '{');
        pairMap.put(']' , '[');
        pairMap.put('>' , '<');

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            // check if open pair, add to stack
            if ( pairMap.containsValue(currChar)) {
                stack.push(currChar);
            } else if ( pairMap.containsKey(currChar) ) { // if a closing item
                if(stack.isEmpty()) return false;
                char popped = stack.pop();
                char matchingPair = pairMap.get(currChar);
                if ( popped != matchingPair ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
