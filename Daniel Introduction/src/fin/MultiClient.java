package fin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MultiClient extends JFrame {
	private BufferedReader in;
	private PrintWriter out;
	private TextPrompt tp;
	private JTextArea chatWindow;


	public MultiClient()  {
		JTextField userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						out.println(userText.getText());
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
	
	void run() throws IOException {
		Socket server = new Socket("127.0.0.1",6789);
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		out = new PrintWriter(server.getOutputStream(),true);
		while(true){
			String line = in.readLine();
			chatWindow.append(line);
		}

		
	}
	
}


