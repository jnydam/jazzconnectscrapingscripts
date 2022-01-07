package main;

import org.openqa.selenium.WebDriver;

public class BeehiveScraping {
	
	public static void main(String[] args) {
		
		System.out.println("This will be the beehive scraping");
		
		WebDriver driver = InitializationHelper.initializeDriver();
		driver.get("https://www.beehiveboston.com/calendar");
		
		
		driver.close();
		
		
		
	}
	
	

}
