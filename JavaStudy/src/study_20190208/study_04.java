package study_20190208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class study_04 {
	public static void main(String[] args) throws IOException  {
		try (ServerSocket serverSocket = new ServerSocket(8888)) {
			 while (true) { 
				 try (Socket socket = serverSocket.accept();
					 BufferedReader r = new BufferedReader(
					 new InputStreamReader(socket.getInputStream()));
					 BufferedWriter w = new BufferedWriter(
					 new OutputStreamWriter(socket.getOutputStream()));) {
					 
						 System.out.println("Client Host: " + socket.getInetAddress());
						 System.out.println("Client Port: " + socket.getPort());
						 String line;
						 
						 while ((line = r.readLine()) != null) {
							 System.out.println(line);
							 if (line.isEmpty()) break;
						 }
			
						 w.write("HTTP/1.1 404 Not Found\n");
						 w.write("Connection: close\n\n");
				 }
			 }
		}
	}
}
