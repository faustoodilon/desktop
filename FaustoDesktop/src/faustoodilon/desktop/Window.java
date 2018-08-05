package faustoodilon.desktop;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Utility class to facilitate creation of simple desktop interface for fast
 * applications.
 * The main objective is to provide a framework to help creation of simple desktop applications in java. 
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

	public void addLabel(String name, String caption) {

		Label L = new Label();
		L.setText(caption);
		if (!name.isEmpty() && fields.get(name) != null) {
			throw new IllegalArgumentException("Duplicate component name.");
		}

		Field field = new Field(name, L);
		fields.put(name, field);
		frame.add(L);

	}

	public void addTextField(String name, String text, int maxLength) {
		TextField txt = new TextField();
		txt.setName(name);
		txt.setText(text);

		// Limita digitação de texto ao maxLength.
		txt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (txt.getText().length() >= maxLength) {
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
		});

		// Limita colagem de texto ao maxLength.
		txt.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				if (txt.getText().length() > maxLength) {
					txt.setText(txt.getText().substring(0, maxLength));
				}

			}
		});

		Field field = new Field(name, txt);
		fields.put(name, field);
		frame.add(txt);

	}

	public void addButton(String name, String caption, ActionListener action) {
		Button b = new Button();
		b.setLabel(caption);

		Field field = new Field(name, b);
		fields.put(name, field);

		b.setActionCommand(name);
		b.addActionListener(action);

		frame.add(b);
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
