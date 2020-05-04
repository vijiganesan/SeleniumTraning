package week1.day1;

public class Factorial {
	
	// Goal: Find the Factorial of a given number
	
	public static void main(String[] args) {
		
		// Declare your input number
		int i ;
		
		// Declare and initialise an integer variable by name: fact
		int fact = 1;
		
		// Iterate from 1 to your input (tip: using loop concept)
		
		for(i=1; i<=5; i++)
		{
			
			fact = fact*i;
		
		}
		
		// Print factorial (fact)
		System.out.println(fact);
		System.out.printf("The factorial of 5 is %d", fact);
	}
}
