package week1.day2;

public class Palindrome {
	
	public static void main(String[] args) {
		
		//Build a logic to find the given string is palinDrome or not
	    /*
		 * Pseudo Code
		 * a) Declare A String value as"madam"
		 * b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order
		 * d) Add the char into rev
		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		 */
		
		String word = "madam";
		String reverse = "";
		String rev = "";
		
		char[] chAr = word.toCharArray();
		
		for (int i = (chAr.length - 1); i >= 0; i--) {
		
		
		rev = rev + word.charAt(i);
		reverse = reverse + chAr[i];
		
		}
		
		System.out.println(word);
		System.out.println(rev);
		System.out.println(reverse);
	
		if (reverse.equalsIgnoreCase(word))
			System.out.printf("the string %s is a palindrome word", word);
		else
			System.out.printf("the string %s is NOT a palindrome word", word);
		
	}

}
