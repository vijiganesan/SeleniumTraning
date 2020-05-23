package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.snapdeal.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		WebElement mens = driver.findElementByXPath("//li//span[@class='catText' and contains(text(),'Men')]");
		
		builder.moveToElement(mens).click().perform();
		driver.findElementByXPath("(//span[contains(text(),'Shirts')])[3]").click();
		
		builder.moveToElement(driver.findElementByXPath("//img[@class='product-image ']")).perform();
		driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
