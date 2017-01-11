package gui.simon;

import gui.components.Action;
import gui.components.Clickable;
import java.awt.Color;

public interface ButtonInterfaceDaniel extends Clickable {

	void setAction(Action a);

	void highlight();

	void setColor(Color color);

	void dim();

	void setX(int i);

	void setY(int i);

	//hello
}