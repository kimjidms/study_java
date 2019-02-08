package 김은지_ch15;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
/**
 * 전송 프로그램: 명령어 인자로 '서버IP', 'Port', '파일명'를 받아서 해당 서버로 파일 전송
 *
 */
public class Client{
 
    public static void main(String[] args) throws IOException{
    	Client client = new Client();
   
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c1 = Calendar.getInstance();
        
	    String date = sdf.format(c1.getTime());
	    String host = "127.0.0.1";
	    int port = 9999;
	    
    	client.ClientRun(host, port, date);
    }
 
    public void ClientRun(String host, int port, String date){
        try{
        	Socket socket = new Socket(host, port);
        	
        	System.out.println("-------Client Start------\n");
        	 
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String dir = date + ".txt";
            bw.write(dir);
            bw.newLine();
            bw.flush();
            
        	System.out.println("--------Client End-------\n");
            
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
}
