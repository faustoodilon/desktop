package faustoodilon.desktop;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Utility class to facilitate creation of simple desktop interface for fast
 * applications. The main objective is to provide a framework to help creation
 * of simple desktop applications in java.
 * 
 * @author Fausto Odilon - 08/2018
 * @version 0.1
 * 
 */
public class Window {

	private JFrame frame;
	private Map<String, Field> fields = new HashMap<>();

	/*
	 * Construtor padrão, com tamanho e posição.
	 */
	public Window(String caption, int width, int height, int x, int y) {
		init(caption, width, height, x, y);
	}

	/*
	 * Construtor sem posição centraliza janela.
	 */
	public Window(String caption, int width, int height) {

		int sw = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int sh = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int x = (sw - width) / 2;
		int y = (sh - height) / 2;
		init(caption, width, height, x, y);
	}

	private void init(String caption, int width, int height, int x, int y) {

		frame = new JFrame(caption);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocation(x, y);
		frame.setLayout(new GridLayout(0, 2)); // Default 2 colunas de
												// controles.

	}

	public void show() {
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setResizable(boolean resizable) {
		frame.setResizable(resizable);
	}

	public void setClosable(boolean closable) {
		if (closable) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}

	}

	public void setCols(int cols) {
		frame.setLayout(new GridLayout(0, cols));
	}

	public void addLabel(String name, String text) {
		LabelField L = new LabelField(name, text);
		fields.put(name, L);
		frame.add(L.getObject());
	}

	public void addTextField(String name, String text, int maxLength) {
		TextField txt = new TextField(name, text, maxLength);
		fields.put(name, txt);
		frame.add(txt.getObject());
	}

	public void addButton(String name, String caption, ActionListener action) {
		Button btn = new Button(name, caption, action);
		fields.put(name, btn);
		frame.add(btn.getObject());
	}

	public void addCheckbox(String name, String text, boolean value) {
		Checkbox chk = new Checkbox(name, text, value);
		fields.put(name, chk);
		frame.add(chk.getObject());
	}

	public void messageBox(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
		// TODO: Abrir opção de tipos de mensagem.
		// TODO: Criar diálogos de confirmação.
	}

	public Field getField(String name) {
		return (Field) fields.get(name);
	}
}
