package week1.day1;

public class SwitchOperator {
	
	// Goal: Perform calculation based on the user input operations
	
	public static void main(String[] args) {
		
		int x = 2;
		int y = 3;
		int sum = 0;
		char Operations = '+';
		
		switch (Operations) {
		case '+':{
			sum = x + y;
			System.out.printf("Case1: The value of %d %c %d is %d",x,Operations,y,sum);
			break;
		}
		case '-':{
			sum = x - y;
			System.out.printf("Case2: The value of %d %c %d is %d",x,Operations,y,sum);
			break;
		}
		case '*':{
			sum = x * y;
			System.out.printf("Case3: The value of %d %c %d is %d",x,Operations,y,sum);
			break;
		}
		case '/':{
			sum = x / y;
			System.out.printf("Case: The value of %d %c %d is %d",x,Operations,y,sum);
			break;
		}
		default:{
			System.out.println("Case Default: You have entered wrong operator");
			break;
		}
		}
		
	}

}
