package week1.day1;

public class SumOfDigits {

	//Goal: Find the sum of digits of a given number
	
	public static void main(String[] args) {
		
		int num = 567, sum = 0, reminder, i;
		i = num;
				
		while (num >0) {
			
			reminder = num % 10;
			System.out.println(reminder);
			sum = sum + reminder;
			num = num / 10;
		}
		
		System.out.printf("The Sum of numbers %d is %d", i, sum);
	
	}
	
}
