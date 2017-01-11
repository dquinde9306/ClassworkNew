package gui.whackAMole;

import gui.components.Action;
import gui.components.Clickable;

public interface MoleInterface extends Clickable {

	int getAppearanceTime();

	void setAppearanceTme(int screenTime);

	void setAction(sort.Action action);

	void setAction1(sort.Action action);

}
