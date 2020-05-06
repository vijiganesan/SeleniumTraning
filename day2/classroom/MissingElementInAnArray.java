package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {
	
	public static void main(String[] args) {
		
		// Here is the input
			int[] arr = {1,2,3,4,7,6,8};
			
		// sorting Array
			Arrays.sort(arr);
			
		//	loop through the array (start i from arr[0] till the length of the array)
			for (int i = 0; i < arr.length; i++) {
				if (i!=arr[i]) {
					//System.out.println(i);
					//System.out.println(arr[i]);
					System.out.printf("the array index  %d is NOT matching with array value %d", i, arr[i]);
					break;
				}
				else if(i!=arr[i]) {
					System.out.printf("the array index  %d is matching with array value %d", i, arr[i]);
				}
				
			}
	}

}
