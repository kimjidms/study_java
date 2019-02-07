package study_20190207;

import java.io.*;

public class study_04 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		/*
		 * 1
		 */
		InputStream in =  new ByteArrayInputStream("Hello, World!".getBytes("UTF-8")); 
		PushbackInputStream pis = new PushbackInputStream(in, 1020);
		
		int data = pis.read();
		System.out.println("Prefix: " + (char) data);
		
		pis.unread(data); 
		pis.unread("Greetings: ".getBytes("UTF-8"));
		
		byte[] b = new byte[1024];
		int len = pis.read(b);
		
		String str = new String(b, 0, len, "UTF-8");
		System.out.println(str + '\n');
		
		
		
		 /*
		  * 2
		  */
		 File home = new File(System.getProperty("user.home"));
		 System.out.println("Home: " + home);
		 System.out.println("Home directory name: " + home.getName() + '\n');
		 
		 File current = new File(System.getProperty("user.dir"));
		 System.out.println("Current: " + current + '\n');
		 
		 File file = new File("." + File.separator + "test.txt");
		 System.out.println("File: " + file);
		 System.out.println("File.canonical: " + file.getCanonicalPath());
		 System.out.println("File.exists: " + file.exists() + '\n');
		 
		 

		 /*
		  * 3
		  */
		 File dir = new File("." + File.separator + "tmp");
		 if (!dir.exists()) dir.mkdirs();
		 
		 new File(dir + File.separator + "test.txt").createNewFile();
		 
		 File tmpFile1 = File.createTempFile("test", ".tmp", dir);
		 System.out.println("tempFile1: " + tmpFile1);
		 
		 File tmpFile2 = File.createTempFile("test", ".tmp", dir);
		 System.out.println("tmpFile2: " + tmpFile2);
		 tmpFile2.deleteOnExit(); 
	}
}