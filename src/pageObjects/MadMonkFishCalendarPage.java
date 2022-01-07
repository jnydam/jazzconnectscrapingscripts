package pageObjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.MadMonkFishHelper;

public class MadMonkFishCalendarPage {
	
	private WebDriver driver;
	
	private List<WebElement> calendarEntries;
	
	private By calendarEntryLocation = By.xpath("//li[contains(@class, 'card')]");
	private By titleEntryLocationRelative = By.xpath(".//a //h2");
	private By imageEntryLocationRelative = By.xpath(".//div[contains(@class, 'card__media')]");
	
	public MadMonkFishCalendarPage(WebDriver driver) {
		
		this.driver = driver;
		this.calendarEntries = retrieveCalendarEntryObjects();
	}
	
	private List<WebElement> retrieveCalendarEntryObjects() {
		
		
		List<WebElement> calendarEntries = this.driver.findElements(calendarEntryLocation);
		
		
		return calendarEntries;
	}

	
	public List<String> retrieveCalendarEntryTitles() {
		
		List<String> calendarEntryTitles = new LinkedList<String>();
		
		for (int i = 0; i < this.calendarEntries.size(); i++) {
			
			
			WebElement entry = this.calendarEntries.get(i);
			
			String titleString = entry.findElement(titleEntryLocationRelative).getAttribute("textContent");
			
			calendarEntryTitles.add(titleString);
			
			
		}
		
		return calendarEntryTitles;
	}
	
	
	public List<String> retrieveCalendarEntryImages() {
		
		List<String> calendarEntryImageStrings = new LinkedList<String>();
		
		for (int i = 0; i < this.calendarEntries.size(); i++) {
			
			WebElement entry = this.calendarEntries.get(i);
			
			String imageString = entry.findElement(imageEntryLocationRelative).getAttribute("outerHTML");
			
			String imageUrl = MadMonkFishHelper.processImageUrl(imageString);
			
			calendarEntryImageStrings.add(imageUrl);
			
		}
		
		return calendarEntryImageStrings;
	}
	
}
