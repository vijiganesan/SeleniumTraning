package week1.day2;

import java.util.Arrays;

public class FindSecondLargest {

	// To find second largest number in an Array
	
	public static void main(String[] args) {
		
		// Here is the input
		int[] data = {3,2,11,4,6,7};
		
		// sorting Array
		Arrays.sort(data);
		
		System.out.println("sorted array values");
		
		for (int temp : data) {
			System.out.println(temp);
		}
		
		//to print the second largest number
		System.out.printf("the second largest number in the array is %d", data[data.length - 2]);

	}
}
