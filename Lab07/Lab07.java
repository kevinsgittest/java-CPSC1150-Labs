import java.util.*;

/*Program Name: Arrays Lab
 *Author: Kevin
 *Date: June 30 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

public class Lab07 {
  public static void main(String[] args) {
    int[] arrItem1 = new int[10];
    int[] arrItem4 = new int[10];
    int[] newArrItem4 = new int[arrItem4.length];
    int[] arrItem5 = new int[50];
    char[] arrItem7 = new char[256];
 
    initialize(arrItem1);      // Item 1
    System.out.println("Initialized an array of length: " + arrItem1.length + " and filled it with random numbers from 1 to 10: ");
    printArray(arrItem1);      // Item 2
   
    System.out.println();
    arrItem1 = reverseArray(arrItem1);    // Item 3
    System.out.println("Array1 reversed: ");
    printArray(arrItem1);
 
    System.out.println();   
    sumArray(arrItem1, newArrItem4);  // Item 4
    System.out.println("The sum of Array1 reversed up to the digit in the loop: ");
    printArray(newArrItem4);

    int min = 10;
    int max = 20;
    arrItem5 = initialize(arrItem5, min, max);   // Item 5
    System.out.println("Initialized an array of length: " + arrItem5.length + " and filled it with random numbers from " + min + " to " + max + ": ");
    countArray(arrItem5);    // Ite m6
 
    arrItem7 = readArray(arrItem7);  // item 7
    System.out.println("Your array split based on spaces: ");
    printOneInLine(arrItem7);  // item 8
  }

  public static int[] initialize(int[] arr) {
    for (int i = 0; i < arr.length; i++)
      arr[i] = (int)(Math.random() * 10) + 1;
    return arr;
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++)
      System.out.println(arr[i]);
  }

  public static int[] reverseArray(int [] arr) {
    int[] rev = new int[arr.length];
    for (int i = 0; i < arr.length; i++)
      rev[(rev.length - 1) - i] = arr[i];
    return rev;
  }

  public static int[] sumArray(int[] arr, int[] newArr) {
    int sum;
    for (int i = 0; i < arr.length; i++) {
      sum = 0;
      for (int j = 0; j <= i; j++) {
        sum += arr[j];
      }
      newArr[i] = sum;
    }
    return newArr;
  }

  public static int[] initialize(int[] arr, int downLimit, int upLimit) {
    // NOTE: instructions say between but do not say wheather inclusive or exclusive,
    // so I am assuming inclusive. e.g. "choose a number between 1 and 10"
    int newArr[] = new int[arr.length];
    int addiplyer = upLimit - downLimit;
    int multiplyer = downLimit + 1;
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = (int)(Math.random() * multiplyer) + addiplyer;
    }
    return newArr;
  }

  public static void countArray(int[] arr) {
    int max = -((int)Math.pow(2, 31));    // min integer value
    int min = ((int)Math.pow(2, 31) - 1); // max integer value
    int count;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max)
        max = arr[i];
      if (arr[i] < min)
        min = arr[i];
    }

    for (int i = min; i <= max; i++) {
      count = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == i)
          count ++;
      }
      System.out.println("The number of occurrences of " + i + " is: " + count);
    }
  }

  public static char[] readArray(char[] arr) {
    String myMessage;
    System.out.print("Please enter a string to be put into an array: ");
    Scanner myIn = new Scanner(System.in);
    myMessage = myIn.nextLine();// Read a line of message

    if (myMessage.length() > 256)
      myMessage = myMessage.substring(0, 256);
    return myMessage.toCharArray();
  }

  public static void printOneInLine(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == ' ')
        System.out.println();
      else
        System.out.print(arr[i]);
    }
  }

}