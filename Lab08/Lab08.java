import java.util.*;

/*Program Name: Adding Big Integers
 *Author: Kevin
 *Date: July 7 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

public class Lab08 {
  public static void main(String[] args) {
    int input1[], input2[], addedNumber[];
    input1 = getInputInt();
    input2 = getInputInt();

    addedNumber = addIntArrays(input1, input2);

    formatOutput(input1, input2, addedNumber);

  }

  public static int[] getInputInt() {
    // Display menu to get an integer input.
    // returns: integer inputnumber.
    System.out.print("Please enter an integer to be added: ");

    String input;
    Scanner myInput = new Scanner(System.in);
    input = myInput.nextLine();
    return intToArray(input.toCharArray());
  }

  public static int[] intToArray(char[] i) {
    // input: array of characters
    // returns: array of single digit integers
    int count = 0;
    int arrLength = 30;
    final int CHAR_TO_INT = 48; // Constant for converting char to int values
    int[] out = new int[arrLength];

    for (int x = 0; x < i.length; x++) {
      if (i[x] < '0' || i[x] > '9'){
        System.out.println("Invalid character '" + i[x] + "'.");
        System.exit(0);
      }
      out[out.length - x - 1] = (int)i[i.length - x - 1] - CHAR_TO_INT;
    }
    return out;
  }

  public static int[] addIntArrays(int[] i1, int[] i2) {
    // input: two arrays of integers
    // returns: array of integers (two inputs added together)
    int carry = 0;
    int arrLength = 31;
    int[] out = new int[arrLength];

    
    for (int x = arrLength - 2; x >= 0; x--) {
      out[x + 1] = (i1[x] + i2[x] + carry) % 10;
      
      if ((i1[x] + i2[x]) + carry >= 10) {
        carry = 1;
      }
      else {
        carry = 0;
      }
    }

    if (i1[0] + i2[0] + carry >= 10)
      out[0] = 1;
    return out;
  }

  public static void formatOutput(int[] i1, int[] i2, int[] ans) {
    // input: three arrays of integers
    // returns: none. Prints to console though.

    // Line 0 (makes space between inputs and the nice formatted output.)
    System.out.println();

    // Line 1
    System.out.print(' ');
    printOutput(i1);

    // Line 2
    System.out.print('+');
    printOutput(i2);


    // Line 3
    System.out.println("-------------------------------");

    // Line 4
    printOutput(ans);
  }

  public static void printOutput(int[] i) {
    // input: array of integers
    // returns: none. Prints to console though.
    boolean leadingZeroes = true;
    for (int x = 0; x < i.length; x++) {
      
      if (leadingZeroes && i[x] == 0) {
        System.out.print(' ');
      }
      else {
        leadingZeroes = false;
        System.out.print(i[x]);
      }
    }
    System.out.println();
  }

}