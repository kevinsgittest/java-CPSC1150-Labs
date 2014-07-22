import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/** tests readWrite method   */
public class Lab11{
	public static void main (String[] args) throws FileNotFoundException {
    File telephoneNumbers = new File("telephone.txt");
    File words = new File("samplewords.txt");
    
    String[] numbersArr = getPhoneNumberArray(telephoneNumbers);
    for (int i = 0; i < numbersArr.length; i++) {
      if (numbersArr[i] != null)
        System.out.println(numbersArr[i]);
    }
    //System.out.println(numbersArr[1]);
    printAllPermutations(numbersArr[0]);
  }
  
  public static char[][] getCharacters() {
    char[] _0 = {};
    char[] _1 = {};
    char[] _2 = {'A', 'B', 'C'};
    char[] _3 = {'D', 'E', 'F'};
    char[] _4 = {'G', 'H', 'I'};
    char[] _5 = {'J', 'K', 'L'};
    char[] _6 = {'M', 'N', 'O'};
    char[] _7 = {'P', 'Q', 'R', 'S'};
    char[] _8 = {'T', 'U', 'V'};
    char[] _9 = {'W', 'X', 'Y', 'Z'};

    char[][] characters = {_0, _1, _2, _3, _4, _5, _6, _7, _8, _9};
    return characters;
  }
 
  public static String[] getPhoneNumberArray(File inputFile) throws FileNotFoundException {
    Scanner in = new Scanner(inputFile);
    String tmp = "";
    String[] out = new String[1000]; //todo make size = file size
    int count = 0;
    while (in.hasNext()) {
      tmp = in.next();
      if (tmp.contains("604"))
        continue;
      else
        out[count] = tmp;
      count++;
    }
  return out;
  } 

  public static void printAllPermutations(String phoneNumber) {
    char[][] chars = getCharacters();
    int tmp = 0;
    System.out.println("\n" + phoneNumber);

    for (int i = 0; i < phoneNumber.length(); i++) {
      // Main loop. Should iterate 7 times. Once for each number
      tmp = Character.getNumericValue(phoneNumber.charAt(i));
      System.out.print(tmp);
      for (int j = 0; j < chars[tmp].length; j++) {
        System.out.print(chars[tmp][j]);
      }
      System.out.println();
    }
  }
}