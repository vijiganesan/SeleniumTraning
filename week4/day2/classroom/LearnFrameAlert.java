package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnFrameAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElementByXPath("//button[text()='Try it']").click();
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		System.out.println("The text inside the alert is '"+alert.getText()+"'");
		alert.sendKeys("Viji Ganesan");
		
		alert.accept();
		
		String textMsg = driver.findElementByXPath("//p[@id='demo']").getText();
		
		if (textMsg.contains("Viji Ganesan")) {
			System.out.println("The alert msg contains the given name 'Viji Ganesan' to it");
			System.out.println("Msg is : '"+textMsg+"'");
		}
		else
			System.out.println("'Viji Ganesan' is not captured inside the alert");
		
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
