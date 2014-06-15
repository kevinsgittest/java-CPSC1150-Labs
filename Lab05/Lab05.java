import java.util.*;

/*Program Name: PalindromePrimes
 *Author: Kevin
 *Date: June 16 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

public class Lab05 {
  // @preconditions: None (menu input later for a number.)
  // @postconditions: Prints all prime palindromes from 2 - input number.
  public static void main(String[] args) {
    int input = getInput();
    boolean prime = false, palindrome = false;
    for (int x = 2; x < input; x++) {
      if (isPrime(x) && isPalindrome(x)) {
        System.out.println(x + " is a palindrome prime!");
      }
    }
  }

  public static int getInput() {
    // Display menu to get an integer input.
    // returns: integer inputnumber.
    System.out.print("Please choose an integer to be checked for primeness and palindromeness: ");

    int inputNumber;
    Scanner myInput=new Scanner(System.in);
    inputNumber = myInput.nextInt();
    return inputNumber;
  }

  public static boolean isPrime(int number) {
    // Check for primeness.
    // returns: true if prime, or false if not.
    for (int x = 2; x <= number/2; x++) {
      if (number % x == 0)
        return false;
    }
    return true;
  }

  public static boolean isPalindrome(int number) {
    // Check for palindromeness.
    // returns: true if palindrome or false if not.
    if (number == reverseNum(number))
      return true;
    return false;
  }

  public static int reverseNum(int number) {
    // Reverses input int number.
    // returns: reversed number.
    int reverse = 0;
    while (number != 0) {
      reverse = reverse * 10;
      reverse = reverse + (number % 10);
      number = number/10;
    }
    return reverse;
  }
}


