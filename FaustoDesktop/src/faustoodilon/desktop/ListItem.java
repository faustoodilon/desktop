package faustoodilon.desktop;

public class ListItem<T> {

	private String text;
	private T item;
	
	public ListItem(String text, T item) {
		this.item = item;
		this.text = text;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}

}
