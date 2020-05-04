package week1.day1;

public class ArmStrongNumber {
	
	// Goal: To find whether a number is an Armstrong number or not
	public static void main(String[] args) {
		
		int i = 153, calculated = 0, remainder, original;
		original = i;
		
		while (i>0){
			
			remainder = i % 10;
			if (i!=0)	{
				
				//System.out.println(remainder);
				calculated = calculated + (remainder * remainder * remainder);
				
			}
			i = i / 10;
		}
		
		if (original == calculated) {
			System.out.printf("The Armstrong number of 153 is %d",calculated);
		}
		else 
			System.out.printf("The given number %d is not Armstrong number",calculated);
	
}


}
