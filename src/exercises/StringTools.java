package exercises;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/*******************************************************************************
 * Class containing various String manipulation tools.
 * 
 * @author reynoldsr
 ******************************************************************************/
public class StringTools {
    public static final Set<String> PUNCTUATION_MARKS = new HashSet<String>();
    static {
	PUNCTUATION_MARKS.add(" ");
	PUNCTUATION_MARKS.add(":");
	PUNCTUATION_MARKS.add(",");
	PUNCTUATION_MARKS.add(".");
	PUNCTUATION_MARKS.add("-");
	PUNCTUATION_MARKS.add(";");
	PUNCTUATION_MARKS.add("!");
	PUNCTUATION_MARKS.add("?");
	PUNCTUATION_MARKS.add("\'");
	PUNCTUATION_MARKS.add("\"");
    }

    private static final Logger LOG = Logger.getLogger(StringTools.class);

    public StringTools() {
	BasicConfigurator.configure();
    }

    /***************************************************************************
     * Method to insert a String into another String at a given location.
     * 
     * @param insertThis
     *            The string to insert.
     * @param intoThis
     *            The string to insert into.
     * @param atHere
     *            The position within intoThis to insert insertThis.
     * @return
     **************************************************************************/
    public String insertString(final String insertThis, final String intoThis,
	    final int atHere) {
	final StringBuilder original = new StringBuilder(intoThis);

	/***********************************************************************
	 * Make sure we don't go out-of-bounds
	 **********************************************************************/
	try {
	    /*******************************************************************
	     * If the string to insert is null, then the original string doesn't
	     * change.
	     ******************************************************************/
	    if (insertThis != null) {
		original.insert(atHere, insertThis);
	    }
	} catch (IndexOutOfBoundsException indexEx) {
	    /*******************************************************************
	     * If we are out-of-bounds due to an insertion beyond the size, just
	     * append.
	     ******************************************************************/
	    if (atHere >= intoThis.length()) {
		LOG.debug("Index out-of-bounds: Appending to the end.");
		original.append(insertThis);
	    }
	    /*******************************************************************
	     * If we are out-of-bounds due to a negative index, just insert at
	     * the beginning/
	     ******************************************************************/
	    else {
		LOG.debug("Index out-of-bounds: Inserting at beginning.");
		original.insert(0, insertThis);
	    }
	}

	return original.toString();
    }

    /***************************************************************************
     * Method to remove the punctuation and spaces from a given string.
     * 
     * @param theString
     *            The string to remove the punctuation from.
     * @return
     **************************************************************************/
    private String removePunctuation(final String theString) {
	final StringBuilder newString = new StringBuilder(theString);

	for (final String punctuation : PUNCTUATION_MARKS) {
	    int index = newString.indexOf(punctuation);
	    while (index != -1) {
		newString.deleteCharAt(index);
		index = newString.indexOf(punctuation);
	    }
	}

	return newString.toString();
    }

    /***************************************************************************
     * Method to test a String to determine if it is a palindrome.
     * 
     * @param theString
     *            String to test if is a palindrome.
     * @return true if String is a palindrome, false otherwise.
     **************************************************************************/
    public boolean isPalindrome(final String theString) {
	boolean result = true;

	/***********************************************************************
	 * Empty or null Strings are not considered palindromes.
	 **********************************************************************/
	if ("".equals(theString) || theString == null) {
	    result = false;
	} else {
	    final String noPunctuation = removePunctuation(theString)
		    .toLowerCase(Locale.US);
	    final StringBuilder reversedString = new StringBuilder(
		    noPunctuation);
	    reversedString.reverse();
	    result = noPunctuation.equals(reversedString.toString());
	}

	return result;
    }
}
