/**
 * 
 */
package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe resposável por representar um cartao
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 18 de fev de 2017
 */
@XmlRootElement
public class Cartao {
	private int codCartao;
	private int categoria;
	private int codPassageiro;
	private int ativo;
	private double saldo;
	private double ultimoMovimento;
	
	public Cartao(){
		
	}
	
	public Cartao(int codCartao){
		this.setCodCartao(codCartao);
	}
	
	public Cartao(int codCartao, int categoria, int ativo, double saldo,
			double ultimoMovimento, int codPassageiro) {
		super();
		this.codCartao = codCartao;
		this.categoria = categoria;
		this.codPassageiro = codPassageiro;
		this.ativo = ativo;
		this.saldo = saldo;
		this.ultimoMovimento = ultimoMovimento;
	}
	
	public Cartao(int codCartao, int codPassageiro){
		this.codCartao = codCartao;
		this.codPassageiro = codPassageiro;
	}
	
	public Cartao(int codCartao, int codPassageiro, int categoria){
		this.codCartao = codCartao;
		this.codPassageiro = codPassageiro;
		this.categoria = categoria;
	}

	public int getCodCartao() {
		return codCartao;
	}

	public void setCodCartao(int codCartao) {
		this.codCartao = codCartao;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getCodPassageiro() {
		return codPassageiro;
	}

	public void setCodPassageiro(int codPassageiro) {
		this.codPassageiro = codPassageiro;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getUltimoMovimento() {
		return ultimoMovimento;
	}

	public void setUltimoMovimento(double ultimoMovimento) {
		this.ultimoMovimento = ultimoMovimento;
	}

	@Override
	public String toString() {
		return "Cartao [codCartao=" + codCartao + ", categoria=" + categoria + ", codPassageiro=" + codPassageiro
				+ ", ativo=" + ativo + ", saldo=" + saldo + ", ultimoMovimento=" + ultimoMovimento + "]";
	}
	
	
	
}
