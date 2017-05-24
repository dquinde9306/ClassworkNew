package fin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonDemo extends JPanel 
//implements ActionListener
{
 private static JButton b1, b2;

public ButtonDemo() {
	b1 = new JButton("Register");
	b1.setMargin(null);
	b1.setHorizontalAlignment(AbstractButton.CENTER); //aka LEFT, for left-to-right locales

	b2 = new JButton("Login");
	b2.setVerticalAlignment(AbstractButton.BOTTOM);
	b2.setHorizontalAlignment(AbstractButton.CENTER);


//b3 = new JButton("3");
//Use the default text position of CENTER, TRAILING (RIGHT).
//b3.setActionCommand("enable");
//b3.setEnabled(false);

//Listen for actions on buttons 1 and 3.
//b1.addActionListener(this);
//b3.addActionListener(this);

//b1.setToolTipText("Click this button to disable the middle button.");
//b2.setToolTipText("This middle button does nothing when you click it.");
//b3.setToolTipText("Click this button to enable the middle button.");

//Add Components to this container, using the default FlowLayout.
add(b1);
add(b2);
}

//public void actionPerformed1(ActionEvent e) {
//
//}



/**
* Create the GUI and show it.  For thread safety, 
* this method should be invoked from the 
* event-dispatching thread.
*/
private static void createAndShowGUI() {

//Create and set up the window.
JFrame frame = new JFrame("ButtonDemo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Create and set up the content pane.
ButtonDemo newContentPane = new ButtonDemo();
newContentPane.setOpaque(true); //content panes must be opaque
frame.setContentPane(newContentPane);

//Display the window.
frame.pack();
frame.setVisible(true);
}

public static void main(String[] args) {
//Schedule a job for the event-dispatching thread:
//creating and showing this application's GUI.
javax.swing.SwingUtilities.invokeLater(new Runnable() {
public void run() {
createAndShowGUI(); 
}
});
}

//@Override
//public void actionPerformed(ActionEvent e) {
//	// TODO Auto-generated method stub
//	if ("disable".equals(e.getActionCommand())) {
//		b2.setEnabled(false);
//		b1.setEnabled(false);
//		b3.setEnabled(true);
//		} else {
//		b2.setEnabled(true);
//		b1.setEnabled(true);
//		b3.setEnabled(false);
//		}
//}
}