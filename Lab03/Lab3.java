/*Program Name: Hello
 *Author: Kevin
 *Date: May 25 2014
 *Course: CPSC1150-1
 *Instructor: H.Darbandi
 *Compiler: JDK 1.7
 *Hardware: Intel(R) Celeron(R) 2955U @ 1.40GHz
 */


public class Lab3
{
  // precondition: a, b, and c need to be filled in
  // postcondition: returns x1 and x2 if possible, or the problem with the initial polynomial 
  public static void main (String[] args)
  {
    // Constants
    int MONTHSINYEAR = 12;
    double INTEREST = 0.05;
    double INTERESTMODIFIER = 1 + INTEREST;

    double MONTHLYDEDUCTION = 500;
    double INFINITEMONEY = 10000;
    // /Constants

    int months = 0;
    int years = 0;
    double iBalance = 0; 
    double balance = 0;

    // Read system args
    if (args.length < 1) {
      System.out.println("You need an arg (eg. java Lab3 550)");
      System.exit(0);
    }
    else {
      iBalance = Double.parseDouble(args[0]);
      balance = iBalance;
    }

    if (balance >= INFINITEMONEY) {
      System.out.println("You get infinite money! Congrats!");
      System.exit(0);
    }
    while (balance > 0) {
      balance *= INTERESTMODIFIER;
      balance -= MONTHLYDEDUCTION;
      months ++;
    }

    if (months < MONTHSINYEAR) {
      if (months == 1)
        System.out.println(months + " month");
      else
        System.out.println(months + " months");    
    }
    else if (months < 24) {
      years = months / 12;
      months = months - (12 * years);

      if (months == 1)
        System.out.println(years + " year and " + months + " month");
      else if (months == 0)
        System.out.println(years + " year");
      else
        System.out.println(years + " year and " + months + " months");
    }
    else {
      years = months / 12;
      months = months - (12 * years);      

      if (months == 1)
        System.out.println(years + " years and " + months + " month");
      else if (months == 0)
        System.out.println(years + " years");
      else
        System.out.println(years + " years and " + months + " months");
    }
    
  }
}
