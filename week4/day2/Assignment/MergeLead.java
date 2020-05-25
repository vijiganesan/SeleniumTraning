package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");				
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
//2. Enter UserName and Password Using Id Locator			
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
		
//3. Click on Login Button using Class Locator
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		
//4. Click on CRM/SFA Link
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
//5. Click on contacts Button
		driver.findElementByLinkText("Contacts").click();
		
// 6. Click on Merge Contacts using Xpath Locator
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		
//7. Click on Widget of From Contact		
		//driver.findElementByXPath("//table[@class='twoColumnForm']//a").click();
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		
		//System.out.println(driver.getTitle());
		
		String firstWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listWindows = new ArrayList<String>(windowHandles);
		
		//switch to new/second window
		driver.switchTo().window(listWindows.get(1));
		
//8. Click on First Resulting Contact		
		//selecting 1st contact
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[3]").click();
		
		//switch to first window
		driver.switchTo().window(listWindows.get(0));
		
//9. Click on Widget of To Contact		
		//click on 2nd widget	
		//driver.findElementByXPath("(//table[@class='twoColumnForm']//a)[2]").click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> listWindows2 = new ArrayList<String>(windowHandles2);
		
		//switch to new/second window
		driver.switchTo().window(listWindows2.get(1));
		
//10. Click on Second Resulting Contact			
		//selecting 2nd contact
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[4]").click();
		
		//switch to parent window
		driver.switchTo().window(listWindows.get(0));
		
//11. Click on Merge button using Xpath Locator
		//driver.findElementByXPath("(//table[@class='twoColumnForm']//a)[3]").click();
		driver.findElementByLinkText("Merge").click();
		Thread.sleep(1000);
		
//12. Accept the Alert		
		//accept the confirmation alert
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
//13. Verify the title of the page		
		String title = driver.getTitle();
		
		if (title.contains("View Contact")) {
			System.out.println("title");
			System.out.println("The contacts merged successfully and can be viewed in this page");
		}
		else
			System.out.println("The contacts are NOT merged successfully");
		 
		driver.close();

	}

}
