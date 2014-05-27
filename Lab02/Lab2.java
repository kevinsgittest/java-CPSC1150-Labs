/*Program Name: Hello
 *Author: Kevin
 *Date: May 25 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */

/*
 *This program checks for factors of a polynomial
 */

public class Lab2
{
  // precondition: a, b, and c need to be filled in
  // postcondition: returns x1 and x2 if possible, or the problem with the initial polynomial 
  public static void main (String[] args)
  {
      double a, b, c;
      double x1, x2;
      
      a = 1;
      b = 4;
      c = 4;
      System.out.println("Attempting to solve the Quadratic Equation: " + a + "x^2 + " + b + "x + " + c + " = 0");
      // Condition1: a = 0
      if (a == 0) {
        x1 = -c / b;
        System.out.println("Binomial, so answer = -c / b: " + x1);
      }
      // Condition2: b^2 < 4ac
      else if (b*b < 4*a*c) {
        System.out.println("Cannot get square of negative number. No real answer");
      }
      // Condition3: b^2 = 4ac
      // Should work fine with no extra code.

      // Condition4: Standard polynomial
      else {
        x1 = (-b + Math.sqrt((b*b) - (4*a*c))) / (2*a);
        x2 = (-b - Math.sqrt((b*b) - (4*a*c))) / (2*a);
        System.out.println("Roots: " + x1 + ", " + x2);
      }
  }
}
