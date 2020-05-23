package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class jqueryui {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		driver.findElementByXPath("//a[text()='Sortable']").click();
		
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		
		Point item4Loc = driver.findElementByXPath("//li[text()='Item 4']").getLocation();
			
		System.out.println(item4Loc);
		int cordX = item4Loc.x;
		int cordY = item4Loc.y;
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, cordX, cordY).perform();
		
		WebElement item5 = driver.findElementByXPath("//li[text()='Item 5']");
		WebElement item6 = driver.findElementByXPath("//li[text()='Item 6']");
		Point item6Loc = driver.findElementByXPath("//li[text()='Item 6']").getLocation();
		
		//builder.click(item5).clickAndHold().moveToElement(item6).release().perform();
		//builder.clickAndHold(item5).moveToElement(item6).release(item5).perform();
		builder.clickAndHold(item5).moveToElement(item6,item6Loc.x,item6Loc.x).release(item5).perform();
		System.out.println("moved");
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
