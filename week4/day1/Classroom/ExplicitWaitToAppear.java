package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitToAppear {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			ChromeDriver driver = new ChromeDriver(options);
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("http://www.leafground.com/pages/appear.html");
			
			driver.manage().window().maximize();
			
			
			//*************explicit wait for 10 seconds
			 
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			WebElement btnAppear = wait.until(ExpectedConditions.visibilityOf(driver.findElementById("btn")));
			
			String text = driver.findElementById("btn").getText();
			
			if (btnAppear.getText().contains("Voila")) 
				System.out.println("The button appeared after explicit wait 10 seconds and button text is "+text);
			
			else if (!text.contains("Voila"))
				System.out.println("The button didnt appear as expected");
				
			//**************
/*			
			
			//**************without explicit wait
			
			boolean displayed = driver.findElementById("btn").isDisplayed();
			
			String text = driver.findElementById("btn").getText();
			
			if (displayed==true)
				System.out.println("The button appeared after explicit wait 30 seconds");
			else if (!text.contains("Voila"))
				System.out.println("The button didnt appear as expected, we need to apply explicit/implicit wait");
		
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
