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


	

	
}
