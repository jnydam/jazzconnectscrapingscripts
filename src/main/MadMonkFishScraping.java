package main;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import pageObjects.MadMonkFishCalendarPage;
import utility.HttpHelper;

public class MadMonkFishScraping {
	
	
	public static void main(String[] args) {
		
		System.out.println("This will be th script that fetches data"
				+ "from the Sculler's site");
		
		WebDriver driver = InitializationHelper.initializeDriver();
		
		
		driver.get("https://www.themadmonkfish.com/jazz-schedule/");
		
		MadMonkFishCalendarPage madMonkFishCalendarPage = new MadMonkFishCalendarPage(driver);
		
		List<String> titles = madMonkFishCalendarPage.retrieveCalendarEntryTitles();
		List<String> images = madMonkFishCalendarPage.retrieveCalendarEntryImages();
		
		List<String> dates = new LinkedList<String>();
		
		for (int i = 0; i < titles.size(); i++) {
			
			dates.add("");
			
		}
		
		
		driver.close();
		
		HttpHelper.sendDataToServer(dates, titles, images, 3);
		
		
		
	}

	
	
}
