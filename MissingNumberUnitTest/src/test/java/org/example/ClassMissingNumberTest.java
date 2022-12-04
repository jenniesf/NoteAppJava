package org.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassMissingNumberTest {

    @Test
    public void testMissingNumber_8(){
        int[] nums = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        // create object
        ClassMissingNumber findMissingNumber = new ClassMissingNumber();
        assertEquals( 8 , findMissingNumber.findMissingNum( nums , 10 ));
    }

    @Test
    public void testMissingNumber_5(){
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 9};
        ClassMissingNumber findMissingNumber = new ClassMissingNumber();
        assertEquals( 5 , findMissingNumber.findMissingNum( nums , 9 ));
    }

    @Test
    public void testMissingNumber_none(){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ClassMissingNumber findMissingNumber = new ClassMissingNumber();
        assertEquals( 0 , findMissingNumber.findMissingNum( nums , 10 ));
    }

    @Test
    public void testMissingNumber_max(){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ClassMissingNumber findMissingNumber = new ClassMissingNumber();
        assertEquals( 10 , findMissingNumber.findMissingNum( nums , 10 ));
    }
}