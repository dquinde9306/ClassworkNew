package fin;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 


public class Server extends JFrame {
	
	private JTextField userText;
	private JTextArea chatWidow;
	private ObjectOutputStream output; 
	private ObjectInputStream input;	
	private ServerSocket server;
	private Socket connection;

	public Server(){
		super("Apollo");
		userText = new JTextField();
		userText.setEditable(false);
		
	}
	
	
	
	
	
	
	
}
