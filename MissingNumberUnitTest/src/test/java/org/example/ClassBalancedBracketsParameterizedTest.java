package org.example;

import org.junit.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class ClassBalancedBracketsParameterizedTest {

    private String input;
    private boolean expectedOutput;
    ClassBalancedBrackets bb = new ClassBalancedBrackets();

    public ClassBalancedBracketsParameterizedTest(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        String balancedParens = "(1)";
        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String emptyString = "";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String mismatchedBrackets = "<({)}>";

        Object[][] expectedOutputs = {
                { balancedParens, true },
                { balancedAngleBrackets, true },
                { balancedComboBrackets, true },
                { emptyString, true },
                { tooManyOpenParens, false },
                { tooManyOpenParens1, false },
                { tooManyClosedParens, true },
                { startClosedParens, false },
                { mismatchedBrackets, false }
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testBB(){
        assertEquals( expectedOutput , bb.checkBrackets(input));
    }
}