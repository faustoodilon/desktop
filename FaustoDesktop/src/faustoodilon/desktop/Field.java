package faustoodilon.desktop;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Field {

	private Object obj;

	private static enum FieldType {
		LABEL_FIELD, TEXT_FIELD, BUTTON_FIELD
	}

	private FieldType type;
	private String name;

	protected Field(String name, Object obj) {
		this.name = name;
		this.obj = obj;
		if (obj instanceof Label) {
			type = FieldType.LABEL_FIELD;
		}
		if (obj instanceof TextField) {
			type = FieldType.TEXT_FIELD;
		}
		if (obj instanceof Button) {
			type = FieldType.BUTTON_FIELD;
		}
	}

	public String getText() {
		switch (type) {
		case LABEL_FIELD:
			return ((Label) obj).getText();
		case TEXT_FIELD:
			return ((TextField) obj).getText();
		case BUTTON_FIELD:
			return ((Button) obj).getLabel();
		default:
			return null;
		}
	}

	public void setText(String text) {
		switch (type) {
		case LABEL_FIELD:
			((Label) obj).setText(text);
			break;
		case TEXT_FIELD:
			((TextField) obj).setText(text);
			break;
		case BUTTON_FIELD:
			((Button) obj).setLabel(text);
			break;
		}

	}

	public String getName() {
		return name;
	}

	public void addChangeListener(ChangeListener listener) {
		((TextField) obj).addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				listener.onChange();
			}
		});
	}

}
