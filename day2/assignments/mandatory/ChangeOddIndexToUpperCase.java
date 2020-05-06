package week1.day2;

public class ChangeOddIndexToUpperCase {
	/*
	 Pseudo Code
	 * Declare String Input as Follow
	 * String test = "changeme";
	 * a) Convert the String to character array
	 * b) Traverse through each character (using loop)
	 * c)find the odd index within the loop (use mod operator)
	 * d)within the loop, change the character to uppercase, if the index is odd else don't change
	 */
	
	public static void main(String[] args) {
		
		String test = "changeme";
		char[] chArr = test.toCharArray();
		
		for (int i = 0; i < chArr.length; i++) {
			
			if(i%2==1)
				//System.out.printf("odd index %d character value is %c",i,chArr[i]);
				//System.out.println(chArr[i]);
				System.out.print(Character.toUpperCase(chArr[i]) );
				else 
					System.out.print(chArr[i]);
		}
		
	}

}
