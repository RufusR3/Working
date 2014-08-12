package exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringToolsTest {
    private static final String ORIGINAL_STRING = "This is the original string.";

    private static final String INSERT_THIS = " not";

    private static final String NEW_STRING = "This is" + INSERT_THIS
	    + " the original string.";

    private static final String BEYOND_STRING = ORIGINAL_STRING + INSERT_THIS;

    private static final String NEGATIVE_STRING = INSERT_THIS + ORIGINAL_STRING;

    private static final int AT_HERE = 7;

    private static final int BEYOND_END = 47;

    private static final int NEGATIVE_INDEX = -10;

    private static final String EASY_PALINDROME = "never odd or even";

    private static final String COMPLEX_PALINDROME = "Doc Note: I dissent!  A fast never prevents a fatness.  I diet on cod?";

    private static final String NOT_PALINDROME = ORIGINAL_STRING;

    @Test
    public void insertStringTest() {
	final StringTools theTools = new StringTools();
	final String newString = theTools.insertString(INSERT_THIS,
		ORIGINAL_STRING, AT_HERE);

	assertEquals("Insert failed.", NEW_STRING, newString);
    }

    @Test
    public void insertStringAppendTest() {
	final StringTools theTools = new StringTools();
	final String newString = theTools.insertString(INSERT_THIS,
		ORIGINAL_STRING, BEYOND_END);

	assertEquals("Insert failed.", BEYOND_STRING, newString);
    }

    @Test
    public void insertStringNegativeTest() {
	final StringTools theTools = new StringTools();
	final String newString = theTools.insertString(INSERT_THIS,
		ORIGINAL_STRING, NEGATIVE_INDEX);

	assertEquals("Insert failed.", NEGATIVE_STRING, newString);
    }

    @Test
    public void insertNullTest1() {
	final StringTools theTools = new StringTools();
	final String newString = theTools.insertString(null, ORIGINAL_STRING,
		AT_HERE);

	assertEquals("Insert failed.", ORIGINAL_STRING, newString);
    }

    @Test
    public void insertNullTest2() {
	final StringTools theTools = new StringTools();
	final String newString = theTools.insertString(null, ORIGINAL_STRING,
		BEYOND_END);

	assertEquals("Insert failed.", ORIGINAL_STRING, newString);
    }

    @Test
    public void insertNullTest3() {
	final StringTools theTools = new StringTools();
	final String newString = theTools.insertString(null, ORIGINAL_STRING,
		NEGATIVE_INDEX);

	assertEquals("Insert failed.", ORIGINAL_STRING, newString);
    }

    @Test
    public void isPalindromeTest1() {
	final StringTools theTools = new StringTools();
	final boolean theTest = theTools.isPalindrome(EASY_PALINDROME);

	assertTrue("Not a palindrome!", theTest);

    }

    @Test
    public void isPalindromeTest2() {
	final StringTools theTools = new StringTools();
	final boolean theTest = theTools.isPalindrome(COMPLEX_PALINDROME);

	assertTrue("Not a palindrome!", theTest);

    }

    @Test
    public void isPalindromeTest3() {
	final StringTools theTools = new StringTools();
	final boolean theTest = theTools.isPalindrome(NOT_PALINDROME);

	assertFalse("Palindrome!", theTest);

    }

    @Test
    public void emptyPalindromeTest() {
	final StringTools theTools = new StringTools();
	final boolean theTest = theTools.isPalindrome("");

	assertFalse("Palindrome!", theTest);

    }

    @Test
    public void nullPalindromeTest() {
	final StringTools theTools = new StringTools();
	final boolean theTest = theTools.isPalindrome(null);

	assertFalse("Palindrome!", theTest);

    }
}
