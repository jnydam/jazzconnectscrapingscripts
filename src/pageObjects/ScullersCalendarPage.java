package pageObjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScullersCalendarPage {
	
	private WebDriver driver;

	private By parentListContainerElement = By.xpath("//ul[contains(@class,'eventsList')]");
	private By dateItemReference = By.xpath(".//li //h3[contains(@class, 'date')]");
	private By titleItemReference = By.xpath(".//li //div[contains(@class, 'listingBody')] //h3[contains(@class, 'titleofevent')]");
	private By imageItemReference = By.xpath(".//li //div[contains(@class, 'eventPosterArea')] //a //img");
	
	
	public ScullersCalendarPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public List<String> retrieveCalendarDatesEvents() {
		
		
		WebElement parentContainer = this.driver.findElements(parentListContainerElement).get(0);
		
		List<WebElement> listOfCalendarEvents = parentContainer.findElements(dateItemReference);
		
		List<String> dateList = new LinkedList<String>();
		
		for (int i = 0; i < listOfCalendarEvents.size(); i++) {
			
			if (listOfCalendarEvents.get(i).getText().length() > 0) {			
				dateList.add(listOfCalendarEvents.get(i).getText());
			}
		}
		
		return dateList;
		
	}
	
	public List<String> retrieveCalendarEventTitles() {
		
		WebElement parentContainer = this.driver.findElements(parentListContainerElement).get(0);
		
		List<WebElement> listOfCalendarEventTitles = parentContainer.findElements(titleItemReference);
		
		List<String> eventList = new LinkedList<String>();
		
		for (int i = 0; i < listOfCalendarEventTitles.size(); i++) {
			
			eventList.add(listOfCalendarEventTitles.get(i).getText());
		}
		
		return eventList;
		
		
	}
	
	public List<String> retrieveImageTitles() {
		
		WebElement parentContainer = this.driver.findElements(parentListContainerElement).get(0);
		
		List<WebElement> listOfCalendarImageUrls = parentContainer.findElements(imageItemReference);
		
		List<String> imageList = new LinkedList<String>();
		
		for (int i = 0; i < listOfCalendarImageUrls.size(); i++) {
			
			imageList.add(listOfCalendarImageUrls.get(i).getAttribute("src"));
		}
		
		return imageList;
		
	}

}
