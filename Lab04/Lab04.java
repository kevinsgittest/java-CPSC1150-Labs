import java.util.*;
public class Lab04{
  public static void main (String[] args){
    int userInput = getInput();
    double surfaceArea = 0;
    if (userInput == 1) {
      surfaceArea = triangleInput();
    }
    else if (userInput == 2) {
      surfaceArea = circleInput();
    }
    System.out.println(surfaceArea);
  }

  public static int getInput(){
    int userOption;
    Scanner myInput=new Scanner(System.in);
    do {
      System.out.println("Select one of the following shapes, or exit:"); 
      System.out.println(" 1. Triangle"); 
      System.out.println(" 2. Circle"); 
      System.out.println(" 3. Exit"); 
      userOption= myInput.nextInt();
      // To read a number of type float, use : myInput.nextFloat();
      // To read a character use : (myInput.next()).charAt(0);
      if (userOption==3){
        System.out.println("Bye");
        System.exit(0);
      }
    } while (userOption !=1 && userOption !=2);
    return userOption;
  }     

  public static double triangleInput() {
    // get inputs
    Scanner myInput=new Scanner(System.in);
    System.out.print("Please enter the x-coordinate of point1: "); 
    double point1x= myInput.nextInt();  

    System.out.print("Please enter the y-coordinate of point1: "); 
    double point1y= myInput.nextInt();  

    System.out.print("Please enter the x-coordinate of point2: "); 
    double point2x= myInput.nextInt();  

    System.out.print("Please enter the y-coordinate of point2: "); 
    double point2y= myInput.nextInt();  

    System.out.print("Please enter the x-coordinate of point3: "); 
    double point3x= myInput.nextInt();  

    System.out.print("Please enter the y-coordinate of point3: "); 
    double point3y= myInput.nextInt();    

    // Check for straight line inputs
    if (Math.sqrt(Math.pow(Math.abs(point1y - point2y), 2) / Math.pow(Math.abs(point1x - point2x), 2)) &&
      Math.sqrt(Math.pow(Math.abs(point2y - point3y), 2) / Math.pow(Math.abs(point2x - point3x), 2)) &&
      Math.sqrt(Math.pow(Math.abs(point1y - point3y), 2) / Math.pow(Math.abs(point1x - point3x), 2))) 
    {
      double surfaceArea = (Math.sqrt(Math.pow((Math.max(Math.max(point1x, point2x), point3x) - Math.min(Math.min(point1x, point2x), point3x))), 2) + (Math.pow((Math.max(Math.max(point1y, point2y), point3y) - Math.min(Math.min(point1y, point2y), point3y))), 2));
      System.out.print("The surface area of a line with point1: (" + point1x + "," + point1y + "), point2: (" + point2x + "," + point2y + ") and point3: (" + point3x + "," + point3y + ") is: ");
    }
    else {
      // Calculate SA of triangle
      double line1 = Math.sqrt(Math.pow(Math.abs(point1x - point2x), 2) + Math.pow(Math.abs(point1y - point2y), 2));
      double line2 = Math.sqrt(Math.pow(Math.abs(point2x - point3x), 2) + Math.pow(Math.abs(point2y - point3y), 2));
      double line3 = Math.sqrt(Math.pow(Math.abs(point1x - point3x), 2) + Math.pow(Math.abs(point1y - point3y), 2));
    
      double surfaceArea = (line1 + line2 + line3);
      System.out.print("The surface area of a triangle with point1: (" + point1x + "," + point1y + "), point2: (" + point2x + "," + point2y + ") and point3: (" + point3x + "," + point3y + ") is: ");
      return surfaceArea;
      }
  }

  public static double circleInput(){
    // get inputs
    Scanner myInput=new Scanner(System.in);
    System.out.print("Please enter the radius of your circle: "); 
    double radius= myInput.nextInt();  

    if (radius <= 0) {
      System.out.println("Radius must me greater than 0!");
      System.exit(0);      
    }

    double surfaceArea = (2 * radius * Math.PI);
    System.out.print("A circle with radius: " + radius + " is: ");
    return surfaceArea;
  }
}
