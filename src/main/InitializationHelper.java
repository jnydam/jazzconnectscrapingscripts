package main;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitializationHelper {
	
	public static WebDriver initializeDriver() {
		
		WebDriver driver;
		
		String basePath = System.getProperty("user.dir");
		
		System.out.println(basePath);
		
		System.setProperty("webdriver.chrome.driver", basePath + "/chromedriver");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().setSize(new Dimension(1400, 900));
		
		return driver;
		
	}

}
