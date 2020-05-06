package week1.day2;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
		/*
		 * Pseudo code 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 * g)Displaying the String without duplicate words	
		 * h) print the each word
		 */
		
		String text = "We learn java basics as part of java sessions in java week1";
		
		int count = 0;
		String joined = "";
		
		//System.out.println(text);
				
		String[] splitArray = text.split(" "); 
				
		for (int i = 0; i < splitArray.length; i++) {
			
			for (int j = i+1; j < (splitArray.length); j++) {
				
				count=0;
				if (splitArray[i] != null) {
					if (splitArray[i].equalsIgnoreCase(splitArray[j]))
							count++;
					
					if (count>0) {
						splitArray[j]= null;
						continue;
					}	
				}
			}
		}
		
		for (int i = 0; i < splitArray.length; i++) {
			if(splitArray[i] != null)
				joined = joined + splitArray[i] + " ";
			}
		
		System.out.println(joined);
		
	}

}
