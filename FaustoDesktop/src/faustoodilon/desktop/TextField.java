package faustoodilon.desktop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextField extends Field {

	private java.awt.TextField textField;
	private int maxLength;

	public TextField(String name, String text, int maxLength) {

		textField = new java.awt.TextField();
		textField.setName(name);
		textField.setText(text);
		this.maxLength = maxLength;

		// Limita tamanho do texto ao maxLength com listeners.
		textField.addKeyListener(kl);
		textField.addTextListener(tl);
	}

	private KeyListener kl = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			if (textField.getText().length() >= maxLength) {
				e.consume();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	};

	private TextListener tl = new TextListener() {

		@Override
		public void textValueChanged(TextEvent e) {
			if (textField.getText().length() > maxLength) {
				textField.setText(textField.getText().substring(0, maxLength));
			}

		}
	};

	@Override
	public String getName() {
		return textField.getName();
	}

	public int getMaxLength() {
		return maxLength;
	}

	public java.awt.TextField getObject() {
		return textField;
	}

	@Override
	public String getText() {
		return textField.getText();
	}

	@Override
	public void setText(String text) {
		textField.setText(text);

	}

	@Override
	public void addChangeListener(ChangeListener listener) {
		textField.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				listener.onChange();

			}
		});

	}
}
