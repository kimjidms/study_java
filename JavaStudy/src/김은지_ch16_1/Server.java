package 김은지_ch16_1;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
 
/**
 * 수신 프로그램: 명령언 인자로 '서버Port', '디렉토리경로'를 받아서 전송 프로그램이 보내는 파일을 해당 디렉토리에 저장
 *
 */
public class Server {
 
    public static void main(String[] args) throws IOException{
    	Server server = new Server();
    	int port = 9999;
    	
    	ExecutorService executorService = Executors.newFixedThreadPool(2);
    	executorService.execute(server.ServerRun(port));
    	executorService.shutdown();
    }
 
    public Runnable ServerRun(int port) throws IOException{     
        try{
        	ServerSocket server = new ServerSocket(port);
        	File dir = new File(System.getProperty("user.dir") + File.separator + "tmp");
        			
            while(true){
            	
                System.out.println("-------wait------\n");
                Socket socket = server.accept(); 
                System.out.println("Client : " + socket.getInetAddress().getHostAddress());
  
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String data=br.readLine();
                System.out.println("Directory + fileName : " + dir + data);
                
                if (!dir.exists()) dir.mkdirs(); 
                new File(dir + File.separator + data).createNewFile();
                System.out.println("Create New File!");
                
                System.out.println("\n------- End ------");
                
            }
        }catch (Exception e) {
                e.printStackTrace();
            }
		return null;
        }
}
