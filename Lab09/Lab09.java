import java.util.*;

/*Program Name: Formatting large numbers and dates
 *Author: Kevin
 *Date: July 14 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

public class Lab09 {
  public static void main(String[] args) {
    boolean isDate;

    String input = getInput();
    checkInputData(input);
    isDate = isDateFormat(input);
    if (isDate)
      formatDateOutput(input);
    else
      formatNumberOutput(input);
  }

  public static String getInput() {
    // Display menu to get String input
    // Input: none (from user)
    // Returns: String input
    String myMessage;
    System.out.print("Please enter either a number or a date in mm/dd/yyyy format: ");
    Scanner myIn = new Scanner(System.in);
    myMessage = myIn.nextLine();// Read a line of message

    return myMessage;
  }

  public static void checkInputData(String input) {
    // Check the input data for legality
    // Input: String input (from earlier)
    // Returns: none
    if (input.length() > 15) {
      System.out.println("Too long input, exiting");
      System.exit(0);
    }
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) == '/')
        continue;
      else {
        System.out.println("Illegal character (only numbers and slashes are allowed!: " + input.charAt(i));
        System.exit(0);
      }
    }
  }

  public static boolean isDateFormat(String input) {
    // Check the input data to see if it is in date format
    // Input: String input (from earlier)
    // Returns: boolean isDate
    int slashCount = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '/')
        slashCount++;
    }
    if (slashCount == 2)
      return true;
    else if (slashCount != 0) {
      System.out.println("Not the right amount of slashes (should be 2 or 0 and you had: " + slashCount);
      System.exit(0);
    }
    return false;
  }

  public static void formatDateOutput(String input) {
    // Prints output for date inputs
    // Input: String input (from earlier)
    // Returns: none (prints to console)
    String[] outputArr = input.split("/");
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "December"};
    
    System.out.printf("%s %s, %s", months[Integer.parseInt(outputArr[0]) - 1], outputArr[1], outputArr[2]);
  }

  public static void formatNumberOutput(String input) {
    // Prints output for number inputs
    // Input: String input (from earlier)
    // Returns: none (prints to console)
    String commafiedInput = commafy(input);
    String[] splitCommafiedInput = commafiedInput.split(",");
    //String[] decimalNames = {"trillion", "billion", "million", "thousand", "hundred", ""};
    String[] decimalNames = {"", "", "thousand", "million", "billion", "trillion"};

    System.out.print(commafiedInput + " is:");

    for (int i = 0; i < splitCommafiedInput.length; i++) {
      System.out.print(numbersToWords(splitCommafiedInput[i]) + decimalNames[input.length() / 3 - i]);
      if (i != splitCommafiedInput.length - 1)
        System.out.print(", ");
    }
  }

  public static String commafy(String input) {
    // Adds commas to long numbers where needed
    // eg. 123456 -> 123,456 etc...
    // Input: String input (from earlier)
    // Returns: String output (input with commas)
    int count = 0; 
    String output = "";

    //output += input.substring(0, 3);
    for (int i = input.length() - 1; i >= 0; i--) {
      if (count == 2 && i != 0) {
        count = 0;
        output = "," + input.charAt(i) + output;
      }
      else {
        count ++;
        output = input.charAt(i) + output;
      }
    }
    return output;
  }

  public static String numbersToWords(String input) {
    // Converts a 3 digit number to words
    // Input: String num. Number from 0 - 999
    // Returns: String number as words.
    final int CHAR_TO_INT = 48; // Constant for converting char to int values
    //String[] suffixes = {"", "ty", " hundred"};
    String[] suffixes = {" hundred", "ty", ""};

    String[] numbersPl = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] numbersSl = {"", "one", "twen", "thir", "four", "fif", "six", "seven", "eigh", "nine"};
    String[][] numbersArr = {numbersPl, numbersSl, numbersPl};

    String[] tens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    String output = "";
    for (int i = input.length() -1 ; i >= 0; i--) {
      if (i == 1 && input.charAt(i) == '1') {
        output = output + suffixes[0] + " " + tens[input.charAt(input.length() - 1) - CHAR_TO_INT];
        break;
      }
      else if (input.charAt(i) != '0')
        output = " " + numbersArr[i][input.charAt(i) - CHAR_TO_INT] + suffixes[i] + output;
    }
    output += " ";
    return output;
  }
}