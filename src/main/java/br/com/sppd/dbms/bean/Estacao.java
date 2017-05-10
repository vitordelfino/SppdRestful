package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe resposável por representar uma Estacao
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 2 de dez de 2016
 */
@XmlRootElement
public class Estacao {



	private int codEstacao;
	private int linha;
	private String nome;

	public Estacao() {

	}

	public Estacao(int codEstacao, int linha, String nome) {
		this.setCodEstacao(codEstacao);
		this.setLinha(linha);
		this.setNome(nome);
	}
	
	public Estacao(String nome, int linha){
		this.setLinha(linha);
		this.setNome(nome);
		this.setCodEstacao(0);
	}
	
	public Estacao(int codEstacao) {
		this.setCodEstacao(codEstacao);
	}

	/**
	 * @return the codEstacao
	 */
	public int getCodEstacao() {
		return codEstacao;
	}

	/**
	 * @param codEstacao
	 *            the codEstacao to set
	 */
	public void setCodEstacao(int codEstacao) {
		this.codEstacao = codEstacao;
	}

	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * @param linha
	 *            the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Estacao [codEstacao=" + codEstacao + ", linha=" + linha + ", Nome=" + nome + "]";
	}

}
