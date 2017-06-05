package fin;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import introUnit.Student; 


public class Server extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output; 
	private ObjectInputStream input;	
	private ServerSocket server;
	private Socket connection;
	private String username;
	private TextPrompt tp;
	private String[] imNames;

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
		tp = new TextPrompt("Type Here!",userText);
		tp.setForeground(Color.GRAY);
		tp.changeStyle(Font.BOLD + Font.ITALIC);
		add(userText,BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		chatWindow.setEditable(false);
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
		String[] imNames = {"HIP","HAPPY","SAD","SUB"};

	}

	public void startRunning() throws HeadlessException, AWTException{
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
		showMessage("Waiting for someone to connect... \n");
		connection = server.accept();
		showMessage(" Now connected to " + connection.getInetAddress().getHostName() + " ");

	}

	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup! \n");

	}

	private void whileChatting()  throws IOException, HeadlessException, AWTException {
		String message = " You are now connected! ";
		sendMessage(message);
		ableToType(true);
		String[] imNames = {"HIP","HAPPY","SAD","SUB"};
		String[] imPath = {"hip.png", "face.jpg","sad.jpg","sub.png"};
		String[] imType = {"png","jpg","jpg","png"};
		boolean doesExist = false;
		do{
			try {
				message = (String) input.readObject();
				if(message.contains("SEND")){
					for(int i = 0; i<imNames.length;i++){
						if(message.contains("SEND") && message.contains(imNames[i]) ){
							doesExist= true;
							BufferedImage screencapture = ImageIO.read(new FileInputStream("resources/sampleImages/" + imPath[i]));
							try (ServerSocket serv = new ServerSocket(25000,100)) {
								showMessage("\n waiting...");
								try (Socket socket = serv.accept()) {
									showMessage("\n client connected");
									ImageIO.write(screencapture, imType[i], socket.getOutputStream());
									showMessage("\n sent");
								}
							}
						}	
					}
					if(!doesExist){
						sendMessage(" Please select a valid image! type HELP for a list.");

					}
				}
				
				if(message.contains("GET")){
					try(Socket socket = new Socket("localhost", 25001)){
						BufferedImage image = ImageIO.read(socket.getInputStream());
						JLabel label = new JLabel(new ImageIcon(image));
						JFrame f = new JFrame("vnc");
						f.getContentPane().add(label);
						f.pack();
						f.setVisible(true);
					}

				}
				if(message.contains("HELP")){
					String pos  = "possible images are";
					for(int i = 0; i< imNames.length;i++){
						pos += " " + imNames[i] + " ";
					}
					sendMessage(pos);
				}
				else
					showMessage( message);
			}
			catch (ClassNotFoundException classNotFoundException) {
				showMessage("What?");
			}
		}while(!message.contains("END CHAT"));
	}

	private void close() {
		showMessage("\n Closing connections\n \n");
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
			chatWindow.append("\n Unable to send message");

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
