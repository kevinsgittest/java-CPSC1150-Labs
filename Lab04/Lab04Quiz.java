public class Lab04Quiz{
  public static void main (String[] args){
    int n = 99;
    double y=0;
            
    // Your code goes here
    for (double i = n; i >= 3; i = i - 2)
    {
      y = 0;
      for (double x = i; x >= 3; x-= 2) 
      {
        y = y + ((x-2) / x);
      }
      System.out.println(" n = "+ i + " , y =  " + y);
    }
  }
}    
