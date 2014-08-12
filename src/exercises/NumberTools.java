package exercises;

/**
 * A generic class to hold exercises related to numbers.
 * 
 * @author Rufus
 */
public class NumberTools {

  /**
   * Given a three digit number, determine if the sum of the cubes of each digit is equal to the
   * number itself.
   * 
   * @param theNumber Three digit number.
   * @return foundIt True if sum of cubes is the number, false otherwise.
   */
  public boolean isSumCubes(final int theNumber) {
    boolean foundIt = false;

    if (theNumber >= 0 && theNumber <= 999) {
      final int firstDigit = theNumber / 100;
      final int secondDigit = (theNumber % 100) / 10;
      final int thirdDigit = theNumber % 10;

      final int theSum =
          (int) ((Math.pow(firstDigit, 3)) + (Math.pow(secondDigit, 3)) + (Math.pow(thirdDigit, 3)));

      if (theNumber == theSum) {
        foundIt = true;
      }
    }

    return foundIt;
  }

  /**
   * Main method to print out the three digit numbers where the sum of the cubes of each digit is
   * equal to the number itself.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    final NumberTools theTest = new NumberTools();

    for (int x = 1; x < 1000; x++) {
      if (theTest.isSumCubes(x)) {
        System.out.println(x);
      }
    }
  }

}
