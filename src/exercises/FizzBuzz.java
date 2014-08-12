package exercises;

/**
 * If the number is divisible by 3, print "fizz". If the number is divisible by 5, print "buzz". If
 * the number is divisible by 3 and 5, print "fizzbuzz". Else, print the number.
 * 
 * @author Rufus
 */
public class FizzBuzz {
  FizzBuzz() {
    for (int x = 1; x <= 100; x++) {
      boolean foundIt = false;
      
      if (x % 3 == 0) {
        System.out.print("fizz");
        foundIt = true;
      }

      if (x % 5 == 0) {
        System.out.print("buzz");
        foundIt = true;
      }

      if (foundIt) {
        System.out.println();
      } else {
        System.out.println(x);
      }
    }
  }

  /**
   * Main method to run FizzBuzz
   * 
   * @param args
   */
  public static void main(String[] args) {
    new FizzBuzz();
  }

}
