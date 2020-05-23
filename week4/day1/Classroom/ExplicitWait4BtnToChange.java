package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait4BtnToChange {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.leafground.com/pages/TextChange.html");
		
		driver.manage().window().maximize();
		
		//*************explicit wait for 30 seconds
		 
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		Boolean btnText = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("btn"), "Click ME!"));
		
		String text = driver.findElementById("btn").getText();
		
		if (btnText==true) 
			System.out.println("The button changed as expected and the text on button is '"+text+"'");
		
		else if(!text.equalsIgnoreCase("Click ME!"))
			System.out.println("The button didnt change as expected");
			
		//**************
/*
		//**************without explicit wait
		
		String btnText = driver.findElementById("btn").getText();
		
		String text = driver.findElementById("btn").getText();
		
		if (btnText.contains("Click ME"))
			System.out.println("The button is changed without explicit wait");
		else if(!text.equalsIgnoreCase("Click ME!"))
			System.out.println("The button not yet changed, we need to apply explicit wait");
	
		System.out.println("after few seconds");
		Thread.sleep(10000);
		String text1 = driver.findElementById("btn").getText();
		System.out.println(text1);
		System.out.println("The button text printed");
		
		//**************
		
*/		
		driver.close();

	}

}
