package test;

import main.BalancedBrackets;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBracketsTest {

    @Test
    public void emptyString(){
        assertTrue(BalancedBrackets.hasBalancedBrackets(""));
    }

    @Test
    public void onlyBracketsTrue(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]"));
    }

    @Test
    public void noBracketsNoQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("word"));
    }

    @Test
    public void singleBracketNoQuotes(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("["));
    }

    @Test
    public void manyBalancedBracketsNoQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("[[[word] ]][]    [sa]"));
    }

    @Test
    public void manyUnbalancedBracketsNoQuotes(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("[aa ][]aa [[]aa ]]"));
    }

    @Test
    public void bracketsInWrongOrderNoQuotes(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("]sdf ddd[[   d]"));
    }

    @Test
    public void noBracketsQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("Hello"));
    }

    @Test
    public void textWithBalancedBracketsInQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("hello '[]' world"));
    }

    @Test
    public void textWithUnbalancedBracketsInQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("hello '[[[' world"));
    }

    @Test
    public void balancedBracketsAlsoQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("hello [] 'other text' []"));
    }

    @Test
    public void unbalancedBracketsAlsoQuotes(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("hello []] 'other text' []"));
    }

    @Test
    public void balancedBracketsUnbalancedBracketsInQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("hello [] 'other [[[ text' []"));
    }

    @Test
    public void unbalancedBracketsBalancingInQuotes(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("hello [[[ ']]]'"));
    }

    @Test
    public void balancedBracketsMultipleQuotes(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("hello [[ '[[''[[' ]]"));
    }

    @Test
    public void unbalancedBracketsMultipleQuotes(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("hello [[[ '[[['']]' ']]]']"));
    }
}
