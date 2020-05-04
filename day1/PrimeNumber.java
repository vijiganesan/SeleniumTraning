package week1.day1;

public class PrimeNumber {
	
	// Goal: To find whether a number is a Prime number or not
	
	public static void main(String[] args) {
		
		int num = 13;
		boolean flag = false;
		
		for (int i = 2; i <= num/2; i++) {
			
			if (num % i == 0) {
				flag = true;
				System.out.printf("The number %d is NOT Prime Number",num);
				break;
			}
		}
		
		if (flag==false)
			System.out.printf("The number %d is a Prime Number",num);
		
		
	}

}
