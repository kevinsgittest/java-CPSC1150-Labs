import java.util.*;
import java.io.*;

public class Lab10Test {
  public static void main(String[] args) throws FileNotFoundException {
    // Test cases
    readWrite("test1.txt", "out1.txt");
    readWrite("test2.txt", "out2.txt");	
	}

	/** copies the content of the srcFileName into dstFileName, and add the average of the number to the end of the dstFileName
        @param srcFileName :  souce file name contains double numbers
	@param dstFileName : destination file name 
        */
	public static void readWrite(String srcFileName, String dstFileName) throws FileNotFoundException {
    // Your code goes here
    File output = new File(dstFileName);
    PrintWriter outPut = new PrintWriter(output);
    
    double avg = 0;
    int count = 0;
    double tmp = 0;

    Scanner in = new Scanner(new File(srcFileName));
    while (in.hasNextDouble()) {
      tmp = in.nextDouble();
      avg += tmp;
      outPut.println(tmp);
      count ++;
    }
    avg = avg / count;
    outPut.println("Average = " + avg);
    outPut.close();
  }
}
