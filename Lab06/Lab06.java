import java.util.*;

/*Program Name: EncryptionProgram
 *Author: Kevin
 *Date: June 16 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

public class Lab06 {
  public static void main(String[] args) {
    String input = getInputString();
    int coding = getInputCoding();

    for (int x = 0; x < input.length(); x++) {
      System.out.println(input.charAt(x));

    }
    System.out.println(coding);
  }

  public static String getInputString() {
    // Display menu to get a String input.
    // returns: String input.
    System.out.print("Please enter a string to be encoded: ");

    String input;
    Scanner myInput=new Scanner(System.in);
    input = myInput.nextLine();
    return input;
  }

  public static int getInputCoding() {
    // Display menu to get an integer input for the CODING value.
    // returns: integer inputnumber.
    System.out.print("Please choose an integer used as the CODING value: ");

    int inputNumber = 0;
    Scanner myInput = new Scanner(System.in);
    inputNumber = myInput.nextInt();
    while (true) {
      if (inputNumber > 0 && inputNumber < 11)
        return inputNumber;
      else
        System.out.print("Please choose an integer value between 1 and 10 (inclusive): ");
        inputNumber = myInput.nextInt();
    }
    //return inputNumber;
  }
}