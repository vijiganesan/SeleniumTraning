package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting path for the Chrome driver 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();
		
		//url
		driver.get("http://www.leafground.com/pages/Button.html");
		
		//to maximize the browser opened
		driver.manage().window().maximize();	
		
		//wait 30 Seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		//click Button to travel to homepage
		driver.findElementById("home").click();
		//back to the previous page
		driver.navigate().back();
		
		Thread.sleep(1000);
		//Find position of button (x,y)
/*		Point positionLoc = driver.findElementById("position").getLocation();
		int xcord = positionLoc.x;
		int ycord = positionLoc.y;
		System.out.println(xcord+":"+ycord);*/
		
		System.out.println(driver.findElementById("position").getLocation());
		
		Thread.sleep(1000);
		//Find button color
		String colorValue = driver.findElementById("color").getCssValue("background-color");
		System.out.println(colorValue);
		
		Thread.sleep(1000);
		//Find the height and width
		System.out.println(driver.findElementById("size").getSize());
		 
		driver.close();
		
		//driver.quit();

	}

}
