import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


//"publish" class is pubsub class; ignore the name

public class Server {
	
	public static void main(String[] args) {	
		try{  
	           ServerSocket ss=new ServerSocket(25000);  
	           Socket s=ss.accept();//establishes connection   
	           DataInputStream dis=new DataInputStream(s.getInputStream());  
	           String  str=(String)dis.readUTF();  
	           System.out.println("message= "+str);  
	           ss.close();  
	       }catch(Exception e){System.out.println(e);}  

	}

}