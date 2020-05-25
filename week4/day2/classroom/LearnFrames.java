package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev60453.service-now.com/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		
		Thread.sleep(2000);
		
		System.out.println("The tile of the page is : '"+driver.getTitle()+"'");
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
