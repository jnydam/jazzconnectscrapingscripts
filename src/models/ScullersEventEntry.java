package models;

public class ScullersEventEntry {
	
	private String eventTitle;
	private String date;
	private String imagePosterUrl;
	private String showTimes;
	
	public ScullersEventEntry(String eventTitle,
			String date,
			String imagePosterUrl,
			String showTimes) {
		
		
		this.eventTitle = eventTitle;
		this.date = date;
		this.imagePosterUrl = imagePosterUrl;
		this.showTimes = showTimes;
	}


}
