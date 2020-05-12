package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	public static void main(String[] args) {
		
		//adding the key for the chromedriver along with the path
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");				
		ChromeDriver driver = new ChromeDriver();
						
		//to open the urls
		driver.get("http://leafground.com/pages/radio.html");
						
		//to maximize the browser opened
		//driver.manage().window().maximize();
		
		//Are you enjoying the call
		boolean selected = driver.findElementByXPath("//input[@id='yes']").isSelected();
		boolean selected2 = driver.findElementByXPath("//input[@id='no']").isSelected();
		if (selected==true)
			System.out.println("The Students are enjoying the class");
		else if (selected2==true)
			System.out.println("The Students are NOT enjoying the class");
		else 
			System.out.println("Please select any value");
		
		//Find default selected radio button
		String defSelValue = driver.findElementByXPath("(//input[@name='news'])[2]").getAttribute("checked");
		if (defSelValue.equalsIgnoreCase("true"))
			System.out.println("The default radio button selected is 'Checked'");
		else
			System.out.println("The default raido button selected is 'UnChecked'");
		
		//Select your age group (Only if choice wasn't selected)
		boolean ageSelection1 = driver.findElementByXPath("//input[@name='age']").isSelected();
		boolean ageSelection2 = driver.findElementByXPath("(//input[@name='age'])[2]").isSelected();
		boolean ageSelection3 = driver.findElementByXPath("(//input[@name='age'])[3]").isSelected();
		if ((ageSelection1==false) && (ageSelection2==false) && (ageSelection3==false))
			System.out.println("Please select your age group");
		else if ((ageSelection1==true) || (ageSelection2==true) || (ageSelection3==true))
			System.out.println("The age group is already selected");
		
		//driver.close();
		
		//driver.quit();
		
		
	}

}
