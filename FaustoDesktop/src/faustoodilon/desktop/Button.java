package faustoodilon.desktop;

import java.awt.event.ActionListener;

public class Button extends Field {

	private java.awt.Button button;

	public Button(String name, String text, ActionListener action) {
		button = new java.awt.Button();
		button.setLabel(text);
		button.setActionCommand(name);
		button.addActionListener(action);

	}

	@Override
	public String getName() {
		return button.getName();
	}

	@Override
	public String getText() {
		return button.getLabel();
	}

	@Override
	public void setText(String text) {
		button.setLabel(text);

	}

	@Override
	public void addChangeListener(ChangeListener listener) {
		// TODO Auto-generated method stub

	}
	
	public java.awt.Button getObject() {
		return button;
	}

}
