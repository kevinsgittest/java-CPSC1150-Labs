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
    String myMessage;
    System.out.print("Please enter either a number or a date in mm/dd/yyyy format: ");
    Scanner myIn = new Scanner(System.in);
    myMessage = myIn.nextLine();// Read a line of message

    return myMessage;
  }

  public static void checkInputData(String input) {
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
    // mm/dd/yyyy
    String[] outputArr = input.split("/");
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "December"};
    
    System.out.printf("%s %s, %s", months[Integer.parseInt(outputArr[0]) - 1], outputArr[1], outputArr[2]);
  }

  public static void formatNumberOutput(String input) {
    String commafiedInput = commafy(input);
    String[] splitCommafiedInput = commafiedInput.split(",");
    //String[] decimalNames = {"trillion", "billion", "million", "thousand", "hundred", ""};
    String[] decimalNames = {"", "hundred", "thousand", "million", "billion", "trillion"};

    for (int i = 0; i < splitCommafiedInput.length; i++) {
      System.out.println(splitCommafiedInput[i] + " " + decimalNames[decimalNames.length - i - 1]);
    }

    System.out.print(commafiedInput + " is: ");
  
  }

  public static String commafy(String input) {
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
}