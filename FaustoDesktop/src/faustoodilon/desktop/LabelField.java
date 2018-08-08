package faustoodilon.desktop;

import java.awt.Label;

public class LabelField extends Field {

	private Label label;
	
	public LabelField(String name, String text) {
		
		label = new Label();
		label.setName(name);
		label.setText(text);
		
	}
	
	@Override
	public String getText() {
		return label.getText();
	}
	
	@Override
	public void setText(String text) {
		label.setText(text);
	}
	
	public Label getObject() {
		return label;
	}

	@Override
	public String getName() {
		return label.getName();
	}

	@Override
	public void addChangeListener(ChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	
}
