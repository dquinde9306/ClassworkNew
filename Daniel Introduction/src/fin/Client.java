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
	private String username;


	public Client(String host,String username){
		super("Client");
		serverIP = host;
		username = this.username;
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
		add(userText,BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		chatWindow.setEditable(false);
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

	private void whileChatting() throws IOException{
		ableToType(true);
		do{

			try {
				message = (String) input.readObject();	
				showMessage("\n " + message);


			} catch (ClassNotFoundException classNotFoundException) {
				showMessage("Unknown object ");
			}


		}while(!message.equals("SERVER - END"));

	}

	private void close() {
		showMessage("Shutting down... ");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}

	private void ableToType(boolean b) {
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(b);
						
					}
				}
				
				
				
				);
		
	}

	private void sendMessage(String message){
		try {
			output.writeObject("CLIENT - " + message);
			output.flush();
			showMessage("\n " + username + " - " + message); 
		} catch (IOException ioException) {
			chatWindow.append("\n Error sending message!");
		}
	}

	private void showMessage(final String m){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(m);
					}

				});



	}


}

