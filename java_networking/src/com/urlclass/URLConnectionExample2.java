package com.urlclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectionExample2 {

	public static void main(String[] args) {

		try {
			URL u = new URL("https://www.geeksforgeeks.org/java");
			URLConnection uc = u.openConnection();

//			System.out.println(uc.getAllowUserInteraction());
//			System.out.println(uc.getContentType());
//			System.out.println(uc.getURL());
//			System.out.println(uc.getDoInput());
//			System.out.println(uc.getDoOutput());
//			System.out.println(uc.getContentEncoding());
//			System.out.println(new Date(uc.getLastModified()));

			Map<String, List<String>> header = uc.getHeaderFields();
			for (Map.Entry<String, List<String>> mp : header.entrySet()) {
				System.out.println(mp.getKey() + " : ");
				System.out.println(mp.getValue().toString());
			}
			System.out.println();
			System.out.println("Complete Source code of the url is- ");
			System.out.println("-----------------------------------------");

			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String i;
			while ((i = br.readLine()) != null) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
