import java.util.*;

/*Program Name: EncryptionProgram
 *Author: Kevin
 *Date: June 23 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

public class Lab06 {
  public static void main(String[] args) {
    char[] input; 
    int operation;
    int coding;
    operation = getMenu(); 
    System.out.println("You chose... wisely.");

    input = getInputString();
    coding = getInputCoding();
    if (operation == 1) // Encoding a message
      encodeMessage(input, coding);
    else if (operation == 2) // Decoding a message
      decodeMessage(input, coding);
  }

  public static void encodeMessage(char[] message, int coding) {
    for (int x = 0; x < message.length; x++) {
      System.out.print(encodeChar(message[x], coding));
    }    
  }

  public static void decodeMessage(char[] message, int coding) {
    String currentChar;
    int count;

    if (message.length % 8 != 0)
      System.out.println("Error with message (length should be a multiple of 8!");
    for (int x = 8; x <= message.length; x+=8) {
      count = 0;
      currentChar = "";
      for (int y = x - 8; y < x; y++) {
        currentChar = currentChar + message[y];
        count ++;
      }
      System.out.print(decodeChar(currentChar, coding));
      //System.out.println((int)decodeChar(currentChar, coding));
      //decodeChar(currentChar);
    }
  }


  public static String encodeChar(char c, int coding) {
    char rotatedChar = rotateChar(c, coding); 
    String encoded;
    encoded = Integer.toBinaryString((int)rotatedChar);
    while (encoded.length() < 8)
      encoded = "0" + encoded;
    return encoded;
  }

  public static char decodeChar(String c, int coding) {
    int intBinary = Integer.parseInt(c, 2);
    char charAsChar = (char)intBinary;
    charAsChar = rotateChar(charAsChar, -coding);
    return charAsChar;
  }

  public static char rotateChar(char x, int coding) {
    int c = (int)x;
    int leftbound, rightbound;
    if (c >= '0' && c <= '9') {
      // Numbers
      leftbound = '0';
      rightbound = '9';
    }
    else if (c >= 'A' && c <= 'Z') {
      // Uppercase letters
      leftbound = 'A';
      rightbound = 'Z';
    }
    else if (c >= 'a' && c <= 'z') {
      // Lowercase letters
      leftbound = 'a';
      rightbound = 'z';
    }
    else {
      // Not a number or letter, so do nothing to encrypt it.
      return (char)c;
    }

    if (c + coding > rightbound && coding > 0) {
      // Encoding case
      c = leftbound + (c + coding) % (rightbound - 1);
    }
    else if (c + coding < leftbound && coding < 0) {
      // Decoding case
      c = rightbound - (leftbound % (c + coding - 1));
    }
    else {
      c = (int)c + coding;
    }
    return (char)c;
  }

  public static int getMenu() {
    int operation = 0;
    Scanner myInput = new Scanner(System.in);
    do {
      System.out.println("Would you like to: ");
      System.out.println("1. Encode a message?");
      System.out.println("2. Decode a message?");
      operation = myInput.nextInt();
    } while (operation !=1 && operation !=2);
    return operation;
  }

  public static char[] getInputString(){
     String myMessage;
     System.out.print("Please enter a string to be encoded or decoded: ");
     Scanner myIn = new Scanner(System.in);
     myMessage = myIn.nextLine();// Read a line of message
     return myMessage.toCharArray();
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
  }
}