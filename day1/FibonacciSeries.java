package week1.day1;

public class FibonacciSeries {

	// Goal: To find Fibonacci Series for a given range
	
	public static void main(String[] args) {
		
		int range = 8, firstNum =0, secNum = 1, sum = 0;
		
		for (int i = 1; i <= range; ++i) {
			
			System.out.println(firstNum);
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;			
			
		}
		
	}
}
