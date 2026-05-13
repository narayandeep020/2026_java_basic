package com.urlclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void main(String[] args) {
		
		        try {
		            // Step 1: Create URL
		            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

		            // Step 2: Open connection
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		            // Step 3: Set request method
		            conn.setRequestMethod("GET");

		            // Step 4: Get response code
		            int responseCode = conn.getResponseCode();
		            System.out.println("Response Code: " + responseCode);

		            // Step 5: Read response
		            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		            String inputLine;
		            StringBuilder response = new StringBuilder();

		            while ((inputLine = in.readLine()) != null) {
		                response.append(inputLine);
		            }
		            in.close();

		            // Step 6: Print result
		            System.out.println("Response: " + response.toString());

		            // Step 7: Disconnect
		            conn.disconnect();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		
	

}
