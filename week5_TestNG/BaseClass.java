package testcase;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public ChromeDriver driver;
	
	public String workBookName;
	
	@Parameters ({"url", "uName", "pswd"})
	@BeforeMethod
	public void login(String url, String userName, String password) {
				
		//adding the key for the chromedriver along with the path
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");		
		driver = new ChromeDriver();
		
		//to open the url
		driver.get(url);
		
		//to maximize the browser opened
		driver.manage().window().maximize();	
		
		driver.findElementById("username").sendKeys(userName);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();

	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();	

	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {

		return LearnExcel.readData(workBookName);

	}

}
