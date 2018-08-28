package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import faustoodilon.desktop.ChangeListener;
import faustoodilon.desktop.Checkbox;
import faustoodilon.desktop.Combobox;
import faustoodilon.desktop.Window;

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
		w.addCheckbox("chkAtiva", "Ativa", true);
		w.addLabel("lblModStatus", "");

		w.addLabel("lblGestor", "Gestor:");
		w.addTextField("gestor", "Nolido Otsuaf", 100);
		w.addLabel("", "");

		w.addLabel("lblSegmento", "Segmento:");

		Combobox<Segmento> cbo = new Combobox<Segmento>("cboSegmento");
		
		cbo.addItem(new Segmento("Imóveis", "Mercado Imobiliário", "IMOB"));
		cbo.addItem(new Segmento("Veículos", "Automóveis e Motocicletas", "AUTO"));
		cbo.addItem(new Segmento("Serviços", "Serviços não financeiros", "SERV"));
		
		w.addCombobox(cbo);

		w.addLabel("lblSegmentoSel", "");

		cbo.addChangeListener(new ChangeListener() {

			@Override
			public void onChange() {
				w.getField("lblSegmentoSel").setText(cbo.getItem().getDescricao());
			}
		});

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

		w.getField("chkAtiva").addChangeListener(new ChangeListener() {

			@Override
			public void onChange() {
				boolean blnStatus = ((Checkbox) w.getField("chkAtiva")).getValue();
				w.getField("lblModStatus").setText(blnStatus ? "Ativada" : "Desativada");
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
