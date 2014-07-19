import java.util.*;
import java.io.*;

public class Lab10 {
  public static void main(String[] args) throws FileNotFoundException {
    String in, out;
    System.out.print("Please enter an input file: ");
    //File in = new File(getInput());
    System.out.print("Please enter an output file: ");
    File output = new File(getInput());

    Scanner input = new Scanner(new File(getInput()));
    while (input.hasNext()) {
      System.out.println(input.next());
    }
  }

  public static String getInput() {
    // Display menu to get String input
    // Input: none (from user)
    // Returns: String input
    String myMessage;
    Scanner myIn = new Scanner(System.in);
    myMessage = myIn.nextLine();// Read a line of message

    return myMessage;
  }
}