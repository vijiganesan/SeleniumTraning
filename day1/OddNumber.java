package week1.day1;

public class OddNumber {
	
	//* Goal: Find the odd numbers in the specific range of numbers
	
	public static void main(String[] args) {
		
		int i;
		
		System.out.println("Printing only the odd numbers from 1 to 20");
		
		for(i=1; i<=20; i++) {
			if (i % 2 == 1)	{
				System.out.println(i);
			}
		}
	}

}
