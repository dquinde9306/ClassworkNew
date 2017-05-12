package fin;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = " ";
	private String serverIP;
	private Socket connection;
	
	public Client(String host){
		super("Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						sendMessage(event.getActionCommand());
						userText.setText(" ");
						
					}					
				}
				);
		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300,150);
		setVisible(true);
	}
	
	public void startRunning(){
		
		try {
			connectToServer();
			setupStreams();
			whileChatting();
			
		} catch (EOFException eofException) {
			showMessage("\n Client ended connection");
			
			
		
		}catch(IOException ioException){
			
			ioException.printStackTrace();
		}finally{
			close();
		}
		
		
	}

	private void connectToServer() throws IOException {
		showMessage("Attempting to connect to server \n");
		connection = new Socket(InetAddress.getByName(serverIP),6789);
		showMessage("Connected to: " + connection.getInetAddress().getHostName() );
	}
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("Streams are setup!");
		
	}
	
	
	

}