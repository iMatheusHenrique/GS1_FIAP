package br.com.fiap.posto.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer avaliacao;
	@ElementCollection
	private List<String> plugs; // { "Type1", "Type2", "css2", "CHAdeMO" };
	private Float preco;

	public Posto() {

	}

	public Posto(String nome, String rua, String bairro, String cidade, String estado, Integer avaliacao,
			List<String> plugs, Float preco) {
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.avaliacao = avaliacao;
		this.plugs = plugs;
		this.preco = preco;
	}
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<String> getPlugs() {
		return plugs;
	}

	public void setPlugs(List<String> plugs) {
		this.plugs = plugs;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return nome + "-" + rua + "-" + bairro + "-" + cidade + "-" + estado + " - " + avaliacao + " - " + plugs + " - "
				+ preco;
	}

	public Vector<String> getDados() {

		Vector<String> dados = new Vector<String>();
		dados.add(id.toString());
		dados.add(nome);
		dados.add(rua);
		dados.add(bairro);
		dados.add(cidade);
		dados.add(estado.toString());
		dados.add(avaliacao.toString());
		dados.add(plugs.toString());
		dados.add(preco.toString());

		return dados;
	}

}
