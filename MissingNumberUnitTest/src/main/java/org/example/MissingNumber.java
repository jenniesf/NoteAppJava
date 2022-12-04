package org.example;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        System.out.println( findMissingNum2( nums ,10 ));

    }

    public static int findMissingNum2(int[] numArr , int maxNum) {
        Arrays.sort(numArr);

        for (int i = 1; i < maxNum; i++) { // 1 and 10
            if( i != numArr[i-1] ) {
                return i;
            }
        }
        return maxNum;
    }
}

