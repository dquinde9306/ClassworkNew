package fin;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 


public class Server extends JFrame {
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output; 
	private ObjectInputStream input;	
	private ServerSocket server;
	private Socket connection;

	public Server(){
		super("Apollo");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent event){
							sendMessage(event.getActionCommand());
							userText.setText("");
						}
					}				
				);
		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	
	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100);
			while(true){
				try {
					waitForConnection();
					setupStreams();
					whileChatting();
					
				} catch (EOFException eofException) {
					showMessage("\n Server ended the connection.");
				}
				finally{
					close();
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
			
		}
	}

	private void waitForConnection() throws IOException {
		showMessage("Waiting for someone to connect");
		connection = server.accept();
		
	}
	
	
	
	
	
	
	
}
