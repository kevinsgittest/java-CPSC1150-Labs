import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/** tests readWrite method   */
public class Lab11Test{
	public static void main (String[] args) throws FileNotFoundException {
		
		
        // test cases
        readWrite("input.txt", "output1.txt", "Java", "JAVA");
        readWrite("input.txt", "output2.txt", "is", "IS NOT");


        
    }

	/** Copies content of source file to destination file and changes all occurances of oldStr to new Str
        @param srcFileName: source file name
        @param dstFileName: destination file name
        @param oldStri : old string that will be replace by new String
        @param newStr :   new string that will be substituded for the oldstr in the destination file
        */
	public static void readWrite(String srcFileName, String dstFileName, String oldStr, String newStr) throws FileNotFoundException {
        // your code goes here
      Scanner in = new Scanner(new File(srcFileName));
      PrintWriter outPut = new PrintWriter(new File(dstFileName));
      String tmp = "";
      String[] tmpArr = new String[100];
      
      while (in.hasNextLine()) {
         tmp = in.nextLine();
         tmpArr = tmp.split(" ");
         for (int i = 0; i < tmpArr.length; i++) {
            if (tmpArr[i].contains(oldStr)) {
               tmpArr[i] = tmpArr[i].replaceAll(oldStr, newStr);
            }
         }
         for (int j = 0; j < tmpArr.length; j++) {
            outPut.print (tmpArr[j] + " ");
         }
         outPut.println();
      }
      outPut.close();
   }
}