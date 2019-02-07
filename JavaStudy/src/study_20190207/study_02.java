package study_20190207;

import java.io.*;

public class study_02 {
    public static void main(String[] args) throws IOException{
  
	/*
	 * 1
	 */
	 byte[] src = "Hello, World".getBytes("UTF-8");
	 
	 InputStream in = new ByteArrayInputStream(src);
	 ByteArrayOutputStream out = new ByteArrayOutputStream();
	 
	 byte[] buff = new byte[2048];
	 int len;
	 
	 while ((len = in.read(buff)) != -1) {
		 out.write(buff, 0, len);
	 }
	 byte[] dest = out.toByteArray(); 
	 System.out.println(new String(dest, "UTF-8"));
    
	 
	 /*
 	 * 2
 	 */
//	 try (InputStream is = new FileInputStream(args[0]);
//		  OutputStream os =new FileOutputStream(args[1])) {
//		 
//		 int data;
//		
//		 while ((data = is.read()) != -1) {
//			 System.out.print((char) data);
//			 os.write(data); 
//		 }
//	 }
//	 
	 
	 /*
 	  * 3
 	  */
	 try(OutputStream fos = new FileOutputStream("test1.txt")) {
		 OutputStream bos = new BufferedOutputStream(fos);
		 bos.write("Hello, ".getBytes("UTF-8"));
		 bos.flush();
		 bos.write("World!".getBytes("UTF-8"));
	 }
	 
	 try (OutputStream bos = new BufferedOutputStream(new FileOutputStream("test2.txt"))) {
		bos.write("Hello, World!".getBytes("UTF-8"));
	 }
    
  }
}