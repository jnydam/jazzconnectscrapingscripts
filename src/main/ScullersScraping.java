package main;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import pageObjects.ScullersCalendarPage;

public class ScullersScraping {
	
	public static void main(String[] args) {
		
		
		System.out.println("This will be th script that fetches data"
				+ "from the Sculler's site");
		
		WebDriver driver = InitializationHelper.initializeDriver();
		
		
		driver.get("https://scullersjazz.com/upcoming-events/");
		
		ScullersCalendarPage scullersCalendarPage = new ScullersCalendarPage(driver);
		
		List<String> dateList = scullersCalendarPage.retrieveCalendarDatesEvents();
		List<String> titleList = scullersCalendarPage.retrieveCalendarEventTitles();
		List<String> imageList = scullersCalendarPage.retrieveImageTitles();
		
		
		JSONArray arrayOfContent = new JSONArray();
		
		for (int i = 0; i < dateList.size(); i++) {
			
			JSONObject obj = new JSONObject();
			
			obj.put("date", dateList.get(i));
			obj.put("title", titleList.get(i));
			obj.put("image", imageList.get(i));
			
			arrayOfContent.put(obj);
		}
		
		
		for (int i = 0; i < arrayOfContent.length(); i++) {
			
			System.out.println(arrayOfContent.get(i));
		}
		
		
	
		
		
		driver.close();
		
		
	}

}
