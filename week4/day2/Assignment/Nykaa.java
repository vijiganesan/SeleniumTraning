package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();		

		//2) Mouseover on Brands 
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		builder.moveToElement(brands).click().perform();
		
		// Mouseover on Popular
		builder.moveToElement(driver.findElementByXPath("//a[text()='Popular']")).click().perform();
	
		//3) Click L'Oreal Paris
		driver.findElementByXPath("(//div[@id='brandCont_Popular']//li/a)[5]").click();
		
		//4) Go to the newly opened window
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listWindows = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(listWindows.get(1));
		
		//check the Page title contains L'Oreal Paris 
		System.out.println("Title : '" +driver.getTitle()+"'");
		
		//close the first window
		driver.switchTo().window(listWindows.get(0));
		driver.close();
		
		//5) Click sort By 
		driver.switchTo().window(listWindows.get(1));

		driver.findElementByXPath("//div[@class='sort-wrapper closed']").click();
		Thread.sleep(2000);
		
		//select customer top rated
		driver.findElementByXPath("//span[text()='customer top rated']//following-sibling::div").click();
		Thread.sleep(2000);
		
		//6) Click Category and click Shampoo
		driver.findElementByXPath("//div[text()='Category']").click();
		
		driver.findElementByXPath("//span[contains(text(),'Shampoo')]").click();
		
		//7) Click the first listed item
		driver.findElementByXPath("//div[@class='row clearfix']/div").click();
		
		//8) GO to the new window and click add to bag
		Set<String> multipleWindows = driver.getWindowHandles();
		List<String> listWindows2 = new ArrayList<String>(multipleWindows);
		
		driver.switchTo().window(listWindows2.get(1));
		
		//System.out.println(driver.getTitle());
		driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
		
		//9) Go to Shopping Bag and click Proceed
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		driver.findElementByXPath("//div[@class='second-col']").click();
		
		//10) Print the error message and Close the browser
		
		//String title = driver.getTitle();
		
		String alertText = driver.findElementByXPath("//div[@class='popup-header']").getText();
		
		if (alertText.contains("Error"))
				System.out.println(driver.findElementByXPath("//div[@class='popup-error']").getText());
		else
			System.out.println("Please Login or Register to Proceed");
		
		driver.quit();
		
				
		//driver.close();
	}

}
