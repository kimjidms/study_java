package study_20190208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class study_02 {
	 public static void main(String[] args) throws IOException  {
		 
		 URL url = new URL("https://google.com");
		 
		 try (InputStream is = url.openStream()) {
			 BufferedReader r = new BufferedReader(
			 new InputStreamReader(is, "UTF-8"));
					
			String lint;
			while ((lint = r.readLine()) != null) {
				System.out.println(lint); 
			 }
		 
		 }
	 }
}