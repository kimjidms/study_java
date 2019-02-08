package study_20190208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class study_03 {
	 public static void main(String[] args) throws IOException  {
		 try (Socket socket = new Socket("google.com",80);
			 OutputStream os = socket.getOutputStream();
			 InputStream is = socket.getInputStream()) {
		 
			 BufferedWriter w = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			 
			 w.write("GET / HTTP/1.1\n");
			 w.write("Host: google.com\n");
			 w.write("Accept-Charset: UTF-8\n");
			 w.newLine();
			 w.flush();
			 
			 
			 BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			 String line;
			 while ((line = r.readLine()) != null) {
				 System.out.println(line);
			 } 
		 }
	 }
}