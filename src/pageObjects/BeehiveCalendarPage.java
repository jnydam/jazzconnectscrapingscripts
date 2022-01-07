package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BeehiveCalendarPage {
	
	private WebDriver driver;
	
	private By calendarCardElementLocation = By.xpath("//div[contains(@class, 'cardBoard__card')]");
	
	public BeehiveCalendarPage(WebDriver driver) {
		
		this.driver = driver;
	}


}
