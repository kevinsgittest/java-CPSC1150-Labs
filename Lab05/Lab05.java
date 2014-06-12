import java.util.*;

public class Lab05 {
  public static void main(String[] args) {
    int input = getInput();
    boolean prime = false, palindrome = false;
    for (int x = 2; x <= input; x++) {
      if (isPrime(x) && isPalindrome(x)) {
        System.out.println(x + " is a palindrome prime!");
      }
    }
  }

  public static int getInput() {
    System.out.print("Please choose an integer to be checked for primeness and palindromeness: ");

    int inputNumber;
    Scanner myInput=new Scanner(System.in);
    inputNumber = myInput.nextInt();
    return inputNumber;
  }

  public static boolean isPrime(int number) {
    for (int x = 2; x <= number/2; x++) {
      if (number % x == 0)
        return false;
    }
    return true;
  }

  public static boolean isPalindrome(int number) {
    if (number == reverseNum(number))
      return true;
    return false;
  }

/**
  public static int getNumberLength(int number) {
    int count = 0;
    while (number > 0) {
      number = number / 10;
      count ++;
    }
    return count;
  }
**/
  public static int reverseNum(int number) {
    int reverse = 0;
    while (number != 0) {
      reverse = reverse * 10;
      reverse = reverse + (number % 10);
      number = number/10;
    }
    return reverse;
  }
}


