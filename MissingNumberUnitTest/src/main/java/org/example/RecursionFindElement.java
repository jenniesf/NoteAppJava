package org.example;

public class RecursionFindElement {
    public static void main(String[] args) {
        int[] oneToTen = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // String[] str = {"hello" , "how" , "are" , "you"};
        System.out.println(recursiveIndex(oneToTen, 5));

        // Example where it is not found
        System.out.println(recursiveIndex(oneToTen, 0));
    }

    public static int recursiveIndex(int[] arr , int num ){
        return recursiveIndexFunction(arr, num, 0);
    }

    public static int recursiveIndexFunction(int[] arr, int num, int idx) {
        // base case
        if ( idx == arr.length ) return -1;

        // logic
        if ( arr[idx] == num ) return idx;
        idx++;

        // recursive call
        return recursiveIndexFunction(  arr , num, idx );
    }
}

//Find the index of an item in a list using recursion.
//
//Implement a function that takes in an item and an array of items,
// and returns the 0-based index of a sought item: >>> recursive_search
// (“hey”, [“hey”, “there”, “you”]) 0
//
//If the item isn’t in the list, return -1: >>>
// recursive_search(“porcupine”, [“hey”, “there”, “you”]) -1
//
//Important: Solve this problem only with recursion—you cannot
// use a for or while loop in your solution!
//
//What is the runtime of this function?