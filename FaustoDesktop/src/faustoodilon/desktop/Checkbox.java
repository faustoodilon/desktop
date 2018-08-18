package faustoodilon.desktop;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Checkbox extends Field {

	private java.awt.Checkbox checkbox;
	private ChangeListener listener;

	public Checkbox(String name, String text, boolean value) {
		checkbox = new java.awt.Checkbox();
		checkbox.setName(name);
		checkbox.setLabel(text);
		checkbox.setState(value);
	}

	@Override
	public String getName() {
		return checkbox.getName();
	}

	@Override
	public String getText() {
		return checkbox.getLabel();
	}

	@Override
	public void setText(String text) {
		checkbox.setLabel(text);
	}

	@Override
	public void addChangeListener(ChangeListener listener) {
		this.listener = listener;
		checkbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				listenerAction();
			}
		});
	}

	public boolean getValue() {
		return checkbox.getState();
	}

	public void setValue(boolean value) {
		checkbox.setState(value);
		// Força execução do listener em caso de alteração de valor via código,
		// o que não é feito pelo controle original.
		listenerAction();
	}

	private void listenerAction() {
		if (listener != null) {
			listener.onChange();
		}
	}

	public java.awt.Checkbox getObject() {
		return checkbox;
	}
}
