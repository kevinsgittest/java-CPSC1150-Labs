import java.util.*;
import java.io.*;

public class Lab10 {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.print("Please enter an input file: ");
    File in = new File(getInput());
    System.out.print("Please enter an output file: ");
    File output = new File(getInput());

    String data = readInputFileAsString(in);
    data = sanatizeInput(data);

    String[] dataArr = data.split(" ");
    dataArr = sortArray(dataArr);
    dataArr = removeDuplicates(dataArr);

    //printData(dataArr);
    printDataToFile(dataArr, output);
  }

  public static String getInput() {
    // Display menu to get String input
    // Input: none (from user)
    // Returns: String input
    String myMessage;
    Scanner myIn = new Scanner(System.in);
    myMessage = myIn.nextLine();

    return myMessage;
  }

  public static String readInputFileAsString(File in) throws FileNotFoundException {
    // read everything from the file as one long string.
    // Input: File input.
    // Returns: String of the entire file.
    String data = "";

    Scanner input = new Scanner(in);
    while (input.hasNext())
      data += input.nextLine();
    return data;
  }

  public static String sanatizeInput(String in) {
    // remove all un-allowed characters from the input string.
    // Input: String of an entire file of words.
    // Returns: Original string with certain characters removed.
    char cur;
    String output = "";
    boolean addChar;
    char[] removeChars = {'.', ',', ';', ':', '?', '!', '"', '\'', '(', ')', '+', '=', '-', '/'};
    for (int i = 0; i < in.length(); i++) {
      cur = in.charAt(i);
      addChar = true;
      for (int j = 0; j < removeChars.length; j++) {
        if (cur == removeChars[j])
          addChar = false;
      }
      if (addChar)
        output += cur;
    }
  return output;
  }

  public static String[] sortArray(String[] in) {
    // Bubble sort for array of strings.
    // Input: array of Strings.
    // Returns: the array sorted.
    String tmp = "";
    for (int i = 0; i < in.length - 1; i++) {
      for (int j = 0; j < in.length - 1; j++) {
        if (in[j].toLowerCase().compareTo(in[j+1].toLowerCase()) > 0) {
          tmp = in[j];
          in[j] = in[j+1];
          in[j+1] = tmp;
        }

      }
    }
    return in;
  }

  public static String[] removeDuplicates(String[] in) {
    // Remove duplicates from an array of strings (case insensative).
    // Input: array of Strings.
    // Output: the array with duplicates removed.
    for (int i = 0; i < in.length - 1; ) {
      if (in[i].toLowerCase().equals(in[i+1].toLowerCase()))
        in[i] = "-"; // - is safe to use because it is sanitized earlier..
      else
        i++;
    }
  return in;
  }

  public static void printData(String[] in) {
    // Print data to console.
    // Input: array of Strings.
    // Output: void.
    for (int i = 0; i < in.length; i++) {
      if (in[i] == "-")
        continue;
      else
        System.out.println(in[i]);
    }
  }

  public static void printDataToFile(String[] in, File file) throws FileNotFoundException {
    // Print data to file.
    // Input: array of Strings and File instance.
    // Output: void.
    PrintWriter outPut = new PrintWriter(file);

    for (int i = 0; i < in.length; i++) {
      if (in[i] == "-")
        continue;
      else
        outPut.println(in[i].toLowerCase());
    }
    outPut.close();
  }
}