package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassBalancedBracketsTest {

    private String str = "(){}[]<>";
    private String str1 = "({[<>]})";
    private String str2 = "(){[]}[]<>";
    private String str3 = "(){[}[]<>";

    String balancedParens = "(1)";
    String tooManyOpenParens = "((1";
    String tooManyOpenParens1 = "(1)(";
    String tooManyClosedParens = "(1))";
    String startClosedParens = ")(";
    String emptyString = "";
    String balancedAngleBrackets = "<<>>";
    String balancedComboBrackets = "<({})>";
    String mismatchedBrackets = "<({)}>";

    private ClassBalancedBrackets bb = new ClassBalancedBrackets();

    @Test
    public void testBB_true1(){
        assertTrue(bb.checkBrackets(str));
    }
    @Test
    public void testBB_true2(){
        assertTrue(bb.checkBrackets(str1));
    }
    @Test
    public void testBB_true3(){
        assertTrue(bb.checkBrackets(str2));
    }
    @Test
    public void testBB_false1(){
        assertFalse(bb.checkBrackets(str3));
    }
    @Test
    public void testBalancedBrackets_balancedParens() {
        assertTrue(bb.checkBrackets("(1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyOpenParens() {
        assertFalse(bb.checkBrackets("({1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyClosedParens() {
        assertTrue(bb.checkBrackets("({})>"));
    }

    @Test
    public void testBalancedBrackets_startWithClosedParens() {
        assertFalse(bb.checkBrackets(")("));
    }

    @Test
    public void testBalancedBrackets_emptyString() {
        assertTrue(bb.checkBrackets(""));
    }

    @Test
    public void testBalancedBrackets_balancedComboBrackets() {
        assertTrue(bb.checkBrackets("<({})>"));
    }

    @Test
    public void testBalancedBrackets_mismatchedBrackets() {
        assertFalse(bb.checkBrackets("<({)}>"));
    }

}