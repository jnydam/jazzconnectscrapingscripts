package utility;

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

public class HttpHelper {
	
	public static void sendDataToServer(List<String> dates, 
			List<String> titles, 
			List<String> images,
			int venueId) {
		
		JSONArray arrayOfContent = new JSONArray();
		
		for (int i = 0; i < dates.size(); i++) {
			
			JSONObject obj = new JSONObject();
			
			obj.put("date", dates.get(i));
			obj.put("title", titles.get(i));
			obj.put("image", images.get(i));
			
			arrayOfContent.put(obj);
		}
		
		
		for (int i = 0; i < arrayOfContent.length(); i++) {
			
			System.out.println(arrayOfContent.get(i));
		}
		
		
		HttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost("http://localhost:3000/events/" + venueId);
		
		
		String jsonArrayToString = arrayOfContent.toString();
		
		
		StringEntity requestEntity = new StringEntity(jsonArrayToString, ContentType.APPLICATION_JSON);
		
		
		httpPost.setEntity(requestEntity);
		
		HttpResponse response = null;
		
		try {
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String responseString = null;
		try {
			responseString = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}