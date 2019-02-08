package study_20190208;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class study_01 {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException  {

        	
    	 URL url = new URL("http://id:pass@host.com/sample/index.html?q=1#index");
    	 
    	 System.out.println("Authority : " + url.getAuthority()); 
    	 System.out.println("File : " + url.getFile()); 
    	 System.out.println("Protocol : " + url.getProtocol());
    	 System.out.println("Host : " + url.getHost());
    	 System.out.println("Port : " + url.getPort());
    	 System.out.println("DefaultPort: " + url.getDefaultPort());
    	 System.out.println("Path : " + url.getPath());
    	 System.out.println("Query : " + url.getQuery());
    	 System.out.println("Anchor : " + url.getRef());
    	 
    	 System.out.println("String : " + url.toExternalForm());
    	 System.out.println("URI : " + url.toURI());
    }
}