package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class LinkedList {

    public static void main(String[] args) {

        java.util.LinkedList ll1 = new java.util.LinkedList();
        java.util.LinkedList ll2 = new java.util.LinkedList();

        ll1.add(3);
        ll1.add(2);
        ll1.add(1);

        ll2.add(6);
        ll2.add(5);
        ll2.add(4);
        System.out.println( addLinkedLists( ll1, ll2 ));
    }

    public static java.util.LinkedList addLinkedLists(java.util.LinkedList list1, java.util.LinkedList list2 ){
        String str1 = "";
        String str2 = "";

        // iterate through LL
        Iterator<Integer> l1 = list1.descendingIterator();
        Iterator<Integer> l2 = list2.descendingIterator();

        while(l1.hasNext()) {
            // System.out.println(l1.next().toString());
            String s = l1.next().toString();
            str1 = str1 + s;
        }

        while(l2.hasNext()) {
            String s = l2.next().toString();
            str2 = str2 + s;
        }

        // get sum and turn back to string
        String sumString =  String.valueOf(Integer.parseInt(str1) + Integer.parseInt(str2));

        // System.out.println(  (list1.size()) );
        System.out.println(  sumString );

        // create new LL
        java.util.LinkedList newLL = new java.util.LinkedList();

        for (int i = sumString.length()-1; i >= 0 ; i--) {
            newLL.add( Integer.parseInt( String.valueOf(   sumString.charAt(i)  ) ) );
        }
        return newLL;
    }
}

// You will be given two linked lists in “reverse-digit” format.
// For example, the number 123 would be represented in a linked list
// like this: 3 → 2 → 1 You should return the sum of these two numbers
// in the same “reverse-digit” format. For 123 + 456, this should return 579,
// in the form of a linked list like this: 9 → 7 → 5.
//
// What is the runtime of this function?