package fin;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
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
	private TextPrompt tp;
	private BufferedImage image;
	private ByteArrayOutputStream imgOut;


	public Client(String host,String username){
		super("Client");
		serverIP = host;
		 this.username = username;
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
		tp = new TextPrompt("Type Here!",userText);
		tp.setForeground(Color.GRAY);
		tp.changeStyle(Font.BOLD + Font.ITALIC);
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
		showMessage("Attempting to connect to server... \n");
		connection = new Socket(InetAddress.getByName(serverIP),6789);
		showMessage("Connected to: " + connection.getInetAddress().getHostName() + " " );
	}

	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are setup! \n");

	}

	private void whileChatting() throws IOException{
		ableToType(true);
		do{

			try {
				message = (String) input.readObject();
				if(message.contains("GET")){
					try(Socket socket = new Socket("localhost", 25000)){
					      BufferedImage image = ImageIO.read(socket.getInputStream());
					      JLabel label = new JLabel(new ImageIcon(image));
					      JFrame f = new JFrame("vnc");
					      f.getContentPane().add(label);
					      f.pack();
					      f.setVisible(true);
					    }
				}
				else
				showMessage( message);

			} catch (ClassNotFoundException classNotFoundException) {
				showMessage("Unknown object ");
			}


		}while(!message.contains("END CHAT"));

	}

	private void receiveImage() throws IOException {
		byte[] sizeAr = new byte[4];
		input.read(sizeAr);
		int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
		byte[] imageAr = new byte[size];
		input.read(imageAr);
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
		ImageIO.write(image, "jpg",(new File ("resources/sampleImages/mole.jpg")));
		showMessage("Image received");
	}

	private void close() {
		showMessage("\n Shutting down... ");
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
			output.writeObject("\n" + username + " - " + message);
			output.flush();
			showMessage("\n" + username + " - " + message); 
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

