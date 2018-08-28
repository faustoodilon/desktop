package faustoodilon.desktop;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class Combobox<T> extends Field {

	private JComboBox<T> comboBox;

	public Combobox(String name) {
		comboBox = new JComboBox<T>();
		comboBox.setName(name);
	}

	public void addItem(T item) {

		try {
			item.getClass().getMethod("toString");
		} catch (NoSuchMethodException | SecurityException e) {
			throw new IllegalArgumentException("Required method \"toString\" not implemented.");
		}

		comboBox.addItem(item);
	}

	@Override
	public String getName() {
		return comboBox.getName();
	}

	@Override
	public String getText() {
		return comboBox.getSelectedItem().toString();
	}

	public void setSelectedItem(T item) {
		comboBox.setSelectedItem(item);
	}

	@Override
	public void setText(String text) {

	}

	@Override
	public void addChangeListener(ChangeListener listener) {
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				listener.onChange();
			}
		});

	}

	public JComboBox<T> getObject() {
		return comboBox;
	}
	
	@SuppressWarnings("unchecked")
	public T getItem() {
		return ((T)comboBox.getSelectedItem());
	}

}
