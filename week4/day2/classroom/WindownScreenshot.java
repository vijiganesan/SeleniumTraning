package week4.day2;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WindownScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HH_mm_ss");
		
		//get current date time with Date()
		Date date = new Date();
		
		// Now format the date
		String date1= dateFormat.format(date)+ ".png";
		
		System.out.println(date);
		System.out.println(date1);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//1. Load https://www.irctc.co.in/nget/train-search		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
//2. Click Ok for the alert		
		driver.findElementByXPath("//button[text()='Ok']").click();
		
//3. Click on FLIGHTS link		
		driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		
		Thread.sleep(2000);
		
//4. Go to the Flights window

		Set<String> multipleWindows = driver.getWindowHandles();

		List<String> listWindows = new ArrayList<String>(multipleWindows);
		
		driver.switchTo().window(listWindows.get(1));

//5. Select the "I have read the guidelines"		
		Actions builder = new Actions(driver);
		WebElement fligtsalert = driver.findElementByXPath("//input[@id='agree']");
		builder.moveToElement(fligtsalert).click().perform();
		
//6. Click on Continue		
		driver.findElementByXPath("//button[text()='Continue ']").click();
		
		
		
//7. take screenShot of Flights window
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/FlightPage_"+date1);
				
		FileUtils.copyFile(source, target);
		
//8. Close the first window (Train eTicketing) alone
		
		driver.switchTo().window(listWindows.get(0));
		
		driver.close();
		
	}

}
