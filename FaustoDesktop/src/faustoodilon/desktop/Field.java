package faustoodilon.desktop;

public abstract class Field {

	public abstract String getName();

	public abstract String getText();

	public abstract void setText(String text);

	public abstract void addChangeListener(ChangeListener listener);
	

}
