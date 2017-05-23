package fin;

import java.applet.Applet; 
import java.awt.*; 
import java.awt.event.*; 

public class Thing extends Applet 
{
  Thread thread; 
  Dimension dim; 
  Image img; 
  Graphics g; 
  Color red = null;
  Color blue = null;
  Font fnt16P = null;


  public void init()
  { 
    resize(800,500);    


    Button b_Up = new Button("Up"); 
    b_Up.setSize(100, 25);
    b_Up.setLocation(450,450+ 90);
    b_Up.setBackground(red); 
    b_Up.setForeground(blue);
    b_Up.setFont(fnt16P);
    b_Up.setVisible(true);
    b_Up.addActionListener((ActionListener) this);
    add(b_Up);


  }

  public void paint(Graphics gfx)
  {
    g.setColor(Color.green);
    g.fillRect(0,0,800,500);
  }
  public void actionPerformed(ActionEvent event)
  {
    int value, total;;
    Object cause = event.getSource();

    //if (cause == b_Up) 

  }

}