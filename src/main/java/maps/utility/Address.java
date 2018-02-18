package maps.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Address {
	private static final String URL_PREFIX = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";
	private static final String URL_SUFFIX = "&key=";
	private static final String KEY = "AIzaSyCko_LIZsWiRrEjLdKLDpFkxzy4hHaT780";
	private static final String USER_AGENT = "Mozilla/5.0";

	public String getAddress(String latitude, String longitude) {
		URL url;
		StringBuffer response = new StringBuffer();
		try {
			url = new URL(URL_PREFIX + latitude.trim() + "," + longitude.trim() + URL_SUFFIX + KEY);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				//Handle error for response code other than 200
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return extractAddress(response.toString());
	}
	
	private String extractAddress(String jsonaddresss)
    {
        try
        {
            JSONParser jasonparser = new JSONParser();
            Object obj = jasonparser.parse(jsonaddresss);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray msg = (JSONArray) jsonObject.get("results");
            JSONObject jobj = (JSONObject) jasonparser.parse(msg.get(1).toString()); // Parsse it 
            String perfect_address = jobj.get("formatted_address").toString();
            jsonaddresss = perfect_address;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return jsonaddresss;
    }
}