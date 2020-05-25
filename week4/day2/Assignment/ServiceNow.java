package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//1. Launch https://dev60453.service-now.com/
		driver.get("https://dev60453.service-now.com/");
		
		driver.manage().window().maximize();
		
		//2. Login with username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		Thread.sleep(3000);
		
		//3. Enter Change in filter navigator
		driver.findElementById("filter").sendKeys("Change");

		//4. Click Create New and click Normal change under What type of change is required?
		//driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		driver.findElementByXPath("(//div[text()='All'])[4]").click();
		Thread.sleep(2000);

		//switch to frame using WebElement
		//driver.switchTo().frame("gsft_main");
		WebElement frameElement = driver.findElementByXPath("//main[@class='navpage-main']//iframe");
		driver.switchTo().frame(frameElement);
		Thread.sleep(2000);

		//click on Create New with New button inside the Frame
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//button[text()='New']")).click().perform();

		//click on 'Normal Change' under 'What type of change is required?'
		driver.findElementByXPath("//form[@name='wizard']/div/a").click();
		
		//5. Capture the change request Number from the Number Filed
		String strAttributeValue = driver.findElementByXPath("//input[@id='change_request.number']").getAttribute("value");
		System.out.println("The new Change Request number is : "+strAttributeValue);
		
		
		//6. Create new normal Change by filling mandatory fields
		driver.findElementById("change_request.short_description").sendKeys("This is normal change created for testing");
		
		//7. Click submit button
		driver.findElementByXPath("//div/button[text()='Submit']").click();
		
		//8. Go to the search field and search the captured number
		WebElement searchElement = driver.findElementByXPath("//div[@class='input-group']/input[@placeholder='Search']");
		searchElement.sendKeys(strAttributeValue,Keys.ENTER);
		//searchElement.;
		
		//9. Verify the successful creation of change
		List<WebElement> rowElements = driver.findElementsByXPath("//table[@id='change_request_table']//tbody/tr");
				
		String strChangeNo = driver.findElementByXPath("//table[@id='change_request_table']//tbody/tr/td[3]").getText();
	
		if (strChangeNo.equalsIgnoreCase(strAttributeValue))
			System.out.println("The Change got created successfully");
		else
			System.out.println("The Change creation is NOT successful");

		Thread.sleep(2000);
		
		driver.close();
	}

}
