package week1.day2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		 /* * Pseudo Code
		 *Declare a String --> String text1 = "stops";
		 *Declare another String --> String text2 = "potss"; 
		 * a) Check length of the strings are same then (Use A Condition)
		 * b) Convert both Strings in to characters
		 * c) Sort Both the arrays
		 * d) Check both the arrays has same value
		 *  */
		
		String text1 = "stops";
		String text2 = "potss";
		int count = 0;
		
		if (text1.length()==text2.length()) {
			
			char[] chText1 = text1.toCharArray();
			char[] chText2 = text2.toCharArray();
			
			Arrays.sort(chText1);
			Arrays.sort(chText2);
			
			for (int i = 0; i < chText2.length; i++) {
				
				if (chText1[i]==(chText2[i]))
					count++;
				else count=0;
			}
		}
		
		if (count == 0)
			System.out.println("The given two words are NOT Anagram");
		else
			System.out.println("The given two words are Anagram");
	}

}
