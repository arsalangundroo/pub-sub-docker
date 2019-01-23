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

public class Client {
	
	public static void main(String[] args) {	

		try{      
	         Socket s=new Socket("localhost",25000);  
	         DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	         dout.writeUTF("Hello Server");  
	         dout.flush();  
	         dout.close();  
	         s.close();  
	      }catch(Exception e){System.out.println(e);} 
	}

}