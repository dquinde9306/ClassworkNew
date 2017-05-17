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
	private String username;

	public Server(String username){
		super("Yellow Submarine");
		 this.username = username;
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
		add(userText,BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		chatWindow.setEditable(false);
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
		showMessage("Waiting for someone to connect...");
		connection = server.accept();
		showMessage(" Now connected to " + connection.getInetAddress().getHostName());

	}
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup ");

	}
	
	private void whileChatting()  throws IOException {
		String message = " You are now connected! ";
		sendMessage(message);
		ableToType(true);
		do{
			
			try {
				message = (String) input.readObject();
				showMessage("\n " + message);
				
			} catch (ClassNotFoundException classNotFoundException) {
				showMessage("What?");
			
			}
			
		}while(!message.equals("CLLIENT - END"));
		
		
		
	}
	
	private void close() {
		showMessage("\n Closing connections \n");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException ioException) {
			
		
		}
	}




	private void sendMessage(String message) {
		try {
			output.writeObject("\n" + username + " - " + message);
			output.flush();
			showMessage("\n" + username + " - " + message); 
			
		} catch (IOException ioException) {
			chatWindow.append("Unable to send message");
			
		}
		
		
	}
	
	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(text);
					}
				}
					
				
		);
		
	}

	private void ableToType(final boolean b) {
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(b);
					}
				}
				);
				
				
		
	}
	
	

	
}
