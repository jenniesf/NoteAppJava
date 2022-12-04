package org.example;

import java.util.Arrays;

public class ClassMissingNumber {

    public int findMissingNum(int[] numArr , int maxNum) {

        Arrays.sort(numArr);

        if ( numArr[numArr.length-1] != maxNum) return maxNum;

        for (int i = 1; i <= maxNum; i++) {
            if( i != numArr[i-1] ) {
                return i;
            }
        }

        return 0;
    }
}

// 1 2 3 4 5 6 7 8 9 null
// int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
// 10
