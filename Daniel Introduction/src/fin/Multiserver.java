package fin;

import java.io.*;
import java.net.*;

import javax.swing.*; 
import java.util.*;


public class Multiserver extends JFrame {

    private static HashSet<String> names = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    
    public static void main(String[] args) throws Exception{
    	ServerSocket listener = new ServerSocket(6789);
    	try{
    		while(true){
    			new Handler(listener.accept()).start();
    			
    		}
    	}finally{
    		listener.close();
    	}
    	
    	
    }
    private static class Handler extends  Thread {

    	private Socket socket;
    	private String name;
    	private BufferedReader in;
    	private PrintWriter out;

    		public Handler(Socket accept) {
    			this.socket =socket;
    		}

    		public void run(){
    			try {
    				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    				out = new PrintWriter(socket.getOutputStream(),true);
    				out.println("enter name");
    				name = in.readLine();
    				writers.add(out);
    				while(true){
    					String input = in.readLine();
    					if(input == null){
    						return;
    					}
    					for(PrintWriter writer:writers){
    						writer.println(name + ": " + input);
    						
    					}
    				}
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}finally{
    				if(name!=null){
    					names.remove(name);
    				}
    				if(out!=null){
    					writers.remove(out);
    				}
    				try{
    					socket.close();
    				}catch(IOException e){
    					
    				}
    			}
    		}

    	}

	

	
}
