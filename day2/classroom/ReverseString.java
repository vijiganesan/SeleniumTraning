package week1.day2;

public class ReverseString {
	
	public static void main(String[] args) {
		
		// Here is the input
				String test = "feeling good";

				// Build the logic to find the count of each
				/* Pseudo Code: 1
					a) Convert the String to character array
					b) Traverse through each character (using loop in reverse direction)
					c) Print the character (without newline -> like below
					   System.out.print(ch);
				*/
				
				char[] charArray = test.toCharArray();
				
				//System.out.println(charArray.length-1);
				
				for (int i = (charArray.length-1); i >= 0 ; i--) {
					
					System.out.print(charArray[i]);
										
				}
				
				/* Pseudo Code: 2
				a) Find the length of the string
				b) Traverse through each index from length-1 -> 0 (using loop in reverse direction)
				c) Find the character of the String using its index
				*/
				
				System.out.print("\n");
				
				int stringLength = test.length();
				for (int i = (charArray.length-1); i >= 0 ; i--) {
					
					System.out.print(test.charAt(i));
										
				}

	}

}
