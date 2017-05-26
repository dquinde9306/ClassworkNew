package fin;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Login extends JPanel implements ActionListener {
	protected static JButton b1;
	protected static JButton b2;

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		createAndShowGUI(); 
		}
		});
	}
	
	/**
	* Create the GUI and show it.  For thread safety, 
	* this method should be invoked from the 
	* event-dispatching thread.
	*/
	private static void createAndShowGUI() { 
	
		//Create and set up the window.
		JFrame frame = new JFrame("Register or Login?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Create and set up the content pane.
		Login newContentPane = new Login();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);
	
	
		//Display the window.
		frame.setSize(800,800);
		frame.setVisible(true);
	
	
	}
	
	public Login() {
	
		b1 = new JButton("Register");
		b1.setActionCommand("disable");
		
		b2 = new JButton("Login");
		b2.setActionCommand("disable");
		
		
		//Listen for actions on buttons 1 and 3.
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		//Add Components to this container, using the default FlowLayout.
		add(b1);
		add(b2);
	
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("disable".equals(e.getActionCommand())) {
			b2.setEnabled(false);
			b1.setEnabled(false);
		} else {
			b2.setEnabled(true);
			b1.setEnabled(true);
		}
	}

}