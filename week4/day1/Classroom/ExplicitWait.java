package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.leafground.com/pages/disapper.html");
		
		driver.manage().window().maximize();
		
		//Thread.sleep(500);
		
		//*************explicit wait for 10 seconds
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		Boolean waitBtn = wait.until(ExpectedConditions.invisibilityOf(driver.findElementById("btn")));
		
		if (waitBtn==true)
			System.out.println("The button disappeared after explicit wait 10 seconds");
		else 
			System.out.println("The button didnt disappear as expected");
		
/*		
		//**************without explicit wait
		boolean displayed = driver.findElementById("btn").isDisplayed();
		
		if (displayed==true)
			System.out.println("The button still visible, we need to apply explicit wait");
		else
			System.out.println("The button disappeared as expected");
		
		System.out.println("after few seconds");
		Thread.sleep(10000);
		String text = driver.findElementById("show").getText();
		System.out.println(text);
		System.out.println("The button disappread and text printed");
*/		
		driver.close();
	}

}
