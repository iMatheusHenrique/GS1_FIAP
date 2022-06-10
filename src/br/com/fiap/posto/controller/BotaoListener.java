package br.com.fiap.posto.controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import br.com.fiap.posto.dao.PostoDao;
import br.com.fiap.posto.model.Posto;
import br.com.fiap.posto.view.Janela;

public class BotaoListener implements ActionListener {
	private Janela view;
	PostoDao dao = new PostoDao();

	public BotaoListener(Janela view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			Posto Posto = new Posto();
			Posto.setNome(view.getTxtNome().getText());
			Posto.setRua(view.getTxtRua().getText());
			Posto.setBairro(view.getTxtBairro().getText());
			Posto.setCidade(view.getTxtCidade().getText());
			Posto.setEstado(view.getTxtEstado().getText());
			Posto.setAvaliacao(Integer.parseInt(view.getTxtAvaliacao().getText()));
			Posto.setPlugs(manageCheckedCheckboxes(view.getPainelCadastro()));
			Posto.setPreco(Float.valueOf(view.getTxtPreco().getText().toString()));
			
			dao.insert(Posto);
			
			view.carregarDados();

	}

	public static List<String> manageCheckedCheckboxes(final Container c) {
		Component[] comps = c.getComponents();
		List<String> checkedTexts = new ArrayList<String>();

		for (Component comp : comps) {

			if (comp instanceof JCheckBox) {
				JCheckBox box = (JCheckBox) comp;
				if (box.isSelected()) {

					String text = box.getText();
					checkedTexts.add(text);
				}
			}
		}

		return checkedTexts;

	}

}
