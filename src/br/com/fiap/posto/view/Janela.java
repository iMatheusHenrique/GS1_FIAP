package br.com.fiap.posto.view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import br.com.fiap.posto.controller.BotaoListener;
import br.com.fiap.posto.controller.TableListener;
import br.com.fiap.posto.dao.PostoDao;
import br.com.fiap.posto.model.Posto;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTabbedPane abas = new JTabbedPane();
	private JPanel painelCadastro = new JPanel();

	private JTextField txtNome = new JTextField(50);
	private JTextField txtRua = new JTextField(50);
	private JTextField txtBairro = new JTextField(40);
	private JTextField txtCidade = new JTextField(30);
	private JTextField txtEstado = new JTextField(30);
	private JTextField txtPreco = new JTextField(20);
	private JTextField txtAvaliacao = new JTextField(20);
	private JButton btnSalvar = new JButton("Salvar");

	private String[] tiposPlug = { "Type1", "Type2", "css2", "CHAdeMO" };
	private List<String> plugsSelecionados = new ArrayList<String>();

	String[] colunas = { "id", "Nome", "Rua", "Bairro", "Cidade", "Estado", "Avaliação", "Tipo de Plug", "Preço kWh" };
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);

	public Janela() {
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void init() {
		this.setLayout(new FlowLayout());
		painelCadastro.add(new JLabel("Nome"));
		painelCadastro.add(txtNome);
		painelCadastro.add(new JLabel("Rua"));
		painelCadastro.add(txtRua);
		painelCadastro.add(new JLabel("Bairro"));
		painelCadastro.add(txtBairro);
		painelCadastro.add(new JLabel("Cidade"));
		painelCadastro.add(txtCidade);
		painelCadastro.add(new JLabel("Estado"));
		painelCadastro.add(txtEstado);
		painelCadastro.add(new JLabel("Preço kWh"));
		painelCadastro.add(txtPreco);
		painelCadastro.add(new JLabel("Avaliação"));
		painelCadastro.add(txtAvaliacao);

		for (int i = 0; i < tiposPlug.length; i++) {
			painelCadastro.add(new JCheckBox(tiposPlug[i]));
		}

		painelCadastro.add(btnSalvar);
		painelCadastro.setLayout(new BoxLayout(painelCadastro, BoxLayout.Y_AXIS));
		TableListener tableListener = new TableListener(this);
		tabela.addMouseListener(tableListener);
		tabela.setDefaultEditor(Object.class, null);
		setVisible(true);
		
		BotaoListener listener = new BotaoListener(this);
		btnSalvar.addActionListener(listener);
		
		abas.add(painelCadastro, "Cadastro");
		abas.add(new JScrollPane(tabela), "Lista");
		
		this.add(abas);
	}

	public void carregarDados() {
		tableModel.setRowCount(0);
		List<Posto> lista = new PostoDao().listarTodos();
		lista.forEach(posto -> tableModel.addRow(posto.getDados()));
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtRua() {
		return txtRua;
	}

	public void setTxtRua(JTextField txtRua) {
		this.txtRua = txtRua;
	}

	public JTextField getTxtBairro() {
		return txtBairro;
	}

	public void setTxtBairro(JTextField txtBairro) {
		this.txtBairro = txtBairro;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public void setTxtCidade(JTextField txtCidade) {
		this.txtCidade = txtCidade;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(JTextField txtEstado) {
		this.txtEstado = txtEstado;
	}

	public JTextField getTxtPreco() {
		return txtPreco;
	}

	public void setTxtPreco(JTextField txtPreco) {
		this.txtPreco = txtPreco;
	}

	public JTextField getTxtAvaliacao() {
		return txtAvaliacao;
	}

	public void setTxtAvaliacao(JTextField txtAvaliacao) {
		this.txtAvaliacao = txtAvaliacao;
	}

	public String[] getTiposPlug() {
		return tiposPlug;
	}

	public void setTiposPlug(String[] tiposPlug) {
		this.tiposPlug = tiposPlug;
	}

	public JPanel getPainelCadastro() {
		return painelCadastro;
	}

}
