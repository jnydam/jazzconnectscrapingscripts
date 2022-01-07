package utility;

public class MadMonkFishHelper {
	
	public static String processImageUrl(String input) {
		
		
		int beginningIndex = input.indexOf("background");
		
		int endingIndex = input.indexOf(";\">");
		
		String middleChunk = input.substring(beginningIndex, endingIndex);
		
		String url = middleChunk.substring(23, middleChunk.length() - 2);
		

		return url;
		
	}

}
