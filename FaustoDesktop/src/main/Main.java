package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.text.ChangedCharSetException;

import faustoodilon.desktop.*;

/**
 * Demonstration class for usage of faustoodilon.desktop framework.
 * 
 * @author Fausto - 08/2018.
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciou.");

		// Creating instance of the window.
		Window w = new Window("Inicio", 500, 250, 400, 200);
		w.setResizable(false);
		w.setClosable(false);

		// Initally based on grid layout. Just need number of columns, the rows
		// are dynamically inserted.
		w.setCols(3);

		w.addLabel("lblEmpresa", "Empresa:");
		w.addTextField("txtEmpresa", "Doméstica S.A.", 100);
		w.addLabel("lblControle", "..."); // Test label, receives dynamic value
											// from event.

		w.addLabel("lblTipo", "Tipo:");
		w.addTextField("txtTipo", "Micro empresa", 100);
		w.addLabel("", ""); // Placeholder for third column.

		w.addLabel("lblCnpj", "CNPJ:");
		w.addTextField("txtCnpj", "123456", 25);
		w.addLabel("", "");

		w.addLabel("lblEspec", "Especialidade:");
		w.addTextField("txtEspec", "Testes de Software", 100);
		w.addLabel("", "");

		w.addLabel("lblStatus", "Status:");
		w.addTextField("txtStatus", "Ativa", 100);
		w.addLabel("", "");

		w.addLabel("lblGestor", "Gestor:");
		w.addTextField("gestor", "Nolido Otsuaf", 100);
		w.addLabel("", "");

		w.addLabel("lblSegmento", "Segmento:");
		w.addTextField("segmento", "Blablabla", 100);
		w.addLabel("", "");

		w.addLabel("", ""); // Placeholder to start buttons on 2nd col.
		w.addButton("btnOk", "OK", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// You can place action code directly here, or make a call, as
				// sugested below.
				btnOk(w);

			}
		});
		w.addButton("btnCancelar", "Cancelar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelar();
			}
		});

		w.getField("txtEmpresa").addChangeListener(new ChangeListener() {

			@Override
			public void onChange() {
				w.getField("lblControle").setText(w.getField("txtEmpresa").getText());
			}
		});

		w.show();

		// Some prints for test of getting fields values.
		System.out.println(w.getField("lblEspec").getText());
		System.out.println(w.getField("txtEspec").getText());
		System.out.println(w.getField("btnOk").getText());

	}

	private static void btnOk(Window w) {
		w.messageBox("Você clicou no OK!", "AVISO"); // Teste of simplified
														// messageBox.
	}

	private static void btnCancelar() {
		System.exit(0);
	}

}
