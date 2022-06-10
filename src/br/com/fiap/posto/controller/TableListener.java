package br.com.fiap.posto.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.posto.dao.PostoDao;
import br.com.fiap.posto.model.Posto;
import br.com.fiap.posto.view.Janela;

public class TableListener implements MouseListener {
	
	private Janela view;
	PostoDao dao = new PostoDao();

	public TableListener(Janela view) {
		this.view = view;
	} 

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			int resposta = JOptionPane.showConfirmDialog(null, "Consultar por estado?");
			if (resposta == JOptionPane.YES_OPTION) {
				view.carregarDados();			
			}

		}
		if (e.getClickCount() == 2) {
			int response = JOptionPane.showConfirmDialog(null, "Deseja apagar esse posto?");
			if (response == JOptionPane.YES_OPTION) {
				JTable table = (JTable) e.getSource();
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				Posto Posto = dao.find(Long.parseLong(id));
				dao.delete(Posto);
				view.carregarDados();
				
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
