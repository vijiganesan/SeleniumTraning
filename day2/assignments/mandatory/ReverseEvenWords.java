package week1.day2;

public class ReverseEvenWords {
	
	public static void main(String[] args) {
		
		//Build a logic to reverse the even position words (output: I ma a erawtfos tester)
		/* Pseudo Code:
		 
		 * Declare the input as Follow
	      String test="I am a software tester"; 
		a) split the words and have it in an array
		b) Traverse through each word (using loop)
		c) find the odd index within the loop (use mod operator)
		
		d)split the words and have it in an array
		
		e)print the even position words in reverse order using another loop (nested loop)
		f) Convert words to character array if the position is even else print the word as it is(concatenate space at the end).
		*/
		
		String text = "I am a software tester";
		String[] txtArray = text.split(" ");
		String revString ="";
		
		for (int i = 0; i < txtArray.length; i++) {
			
			if ((txtArray[i].length() % 2 ) == 0) {
				
				String word = txtArray[i];
				String revWord = "";
				
				for (int j = (word.length()-1); j >= 0 ; j--) {
					
					revWord = revWord + word.charAt(j);
				}
				
				txtArray[i] = revWord;
				
			}	
			
			revString = revString +txtArray[i] + " " ;
		}
		
		System.out.println(text);
		System.out.println(revString);
	}
}
