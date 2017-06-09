package fin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class Login extends JFrame implements ActionListener {
	JButton register;
	JButton login;
	JPanel panel;
	JLabel label1,label2;
	final JTextField  text1,text2;
	private ArrayList<String> user;
	private ArrayList<String> pass;
	private static final String saveFile = "resources/users";

	Login(){
		user = new ArrayList<String>();
		pass = new ArrayList<String>();
		try {
			loadUsers();
		} catch (FileNotFoundException e) {
			user.add("joe");
			pass.add("hello");
			try {
			    // Create the empty file with default permissions, etc.
			    Files.createFile(Paths.get(saveFile));
			} catch (FileAlreadyExistsException x) {
			    System.err.format("file named %s" +
			        " already exists%n", saveFile);
			} catch (IOException x) {
			    // Some other sort of failure, such as permissions.
			    System.err.format("createFile error: %s%n", x);
			}
			saveUsers();
			
		}
		//panel.setLayout(null);

		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);
		//text2.setPreferredSize(new Dimension(100, 30));

		register=new JButton("Register");
		login = new JButton("Login");

		
		//panel=new JPanel();
		panel=new JPanel(new GridLayout(5,1));

		//panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(10, 10)));		
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(register);
		panel.add(login);

		add(panel,BorderLayout.CENTER);
		register.setActionCommand("register");
		login.setActionCommand("login");
		register.addActionListener(this);
		login.addActionListener(this);


		setTitle("Register or Login");

//				  Insets insets = panel.getInsets();
//			        Dimension size = register.getPreferredSize();
//			        register.setBounds(25 + insets.left, 5 + insets.top,
//			                     size.width, size.height);

	}
	private void loadUsers() throws FileNotFoundException {
		FileReader fileReader = new FileReader(saveFile);
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(fileReader);
			int lineNumber = 0;
			while ((line = br.readLine()) != null) {

				//System.out.println("Line number "+lineNumber+": "+line);
				try{
					String[] row = line.split(",", -1);//split only a comma that has an even number of quotes ahead of it
					String username = row[0];
					String password = row[1];
					user.add(username);
					pass.add(password);
					lineNumber++;
				}catch(Exception e){




					//					presentOutdatedNotifcationAfterLoad=true;
				}

			}
			fileReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void saveUsers(){
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(saveFile);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			for(int i=0; i<user.size();i++){
				bufferedWriter.write(user.get(i) + "," + pass.get(i) + "\n");	

			}


			// Always close files.
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void actionPerformed(ActionEvent ae){

		
		if("register".equals(ae.getActionCommand())){
			String v1=text1.getText();
			String v2=text2.getText();
			boolean unique= true;
			if(v1.equals("") || v2.equals("")){
				NextPage page=new NextPage();
				page.setVisible(true);
				JLabel label = new JLabel("Fill in all fields");
				page.getContentPane().add(label);
			}else{
				if(v1.indexOf(",")<0){
					for (int i = 0; i<user.size();i++){
						if(v1.equals(user.get(i))){
							unique=false;
							NextPage page=new NextPage();
							page.setVisible(true);
							JLabel label = new JLabel("Username has been taken.");
							page.getContentPane().add(label);
							break;
						}
	
					}
					if(unique){
						user.add(v1);
						pass.add(v2);
						saveUsers();
						NextPage page=new NextPage();
						page.setVisible(true);
						JLabel label = new JLabel("Welcome to chat");
						page.getContentPane().add(label);
					}
				}else{//contains comma
					NextPage page=new NextPage();
					page.setVisible(true);
					JLabel label = new JLabel("Cannot contain comma.");
					page.getContentPane().add(label);
				}
			
			}
		}

		if("login".equals(ae.getActionCommand())){

			String value1=text1.getText();
			String value2=text2.getText();
			boolean works=false;
			if(value1.equals("") || value2.equals("")){
				NextPage page=new NextPage();
				page.setVisible(true);
				JLabel label = new JLabel("Fill in all fields");
				page.getContentPane().add(label);
			}else{
				for(int i=0; i<user.size();i++){
					if (value1.equals(user.get(i)) && value2.equals(pass.get(i))) {
						works=true;
						startClient(value1);
						
						dispose();
						break;
					
	
					}
				}if(!works){
						System.out.println("enter the valid username and password");
						JOptionPane.showMessageDialog(this,"Incorrect login or password",
						 "Error",JOptionPane.ERROR_MESSAGE);
						
					}
			}
		}
	}
	private void startClient(String value1) {
		// TODO Auto-generated method stub
		Client john;
		john = new Client("127.0.0.1",value1);
		john.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread go = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				john.startRunning();
				 
			}
		});
		go.start();
	}
}

class LoginRegister{
	public static void main(String arg[]){


		try{
			Login frame=new Login();
			frame.pack();
			frame.setVisible(true);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());}
	}
}