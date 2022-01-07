package main;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import pageObjects.ScullersCalendarPage;
import utility.HttpHelper;

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

		driver.close();
		
		// reformat date code
		
		for (int i = 0; i < dateList.size(); i++) {
			
			String string = dateList.get(i);
			
			String newString = string.replaceAll("\n", " ");
			
			dateList.set(i, newString);
			
		}
		
		
		// reformat title code
		
		for (int i = 0; i < titleList.size(); i++) {
			
			String string = titleList.get(i);
			
			string = string.replaceAll("\n", " ");
			
			String titleLower = string.toLowerCase();
			
			String[] titleLowerSplit = titleLower.split(" ");
			String newTitle = "";
			
			for (int j = 0; j < titleLowerSplit.length; j++) {
				
				String word = titleLowerSplit[j];
				
				word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
				
				newTitle += word + " ";
			}
			
			newTitle = newTitle.substring(0, newTitle.length() - 1);
			
			titleList.set(i, newTitle);
			
			
			
			
			
		}
		
		
		HttpHelper.sendDataToServer(dateList, titleList, imageList, 1);
		
		
		
	}


}
