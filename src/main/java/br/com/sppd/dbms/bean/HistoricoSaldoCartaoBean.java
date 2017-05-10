package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe responsável por representar um HistorioSaldoCartao 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */

@XmlRootElement
public class HistoricoSaldoCartaoBean {
	
	private int codCartao;
	private String dataTransacao;
	private double saldoAnterior;
	private double saldoAtual;
	private String descricao;
	private double valor;
	
	public HistoricoSaldoCartaoBean(int codCartao, String dataTransacao, double saldoAnterior, double saldoAtual, String descricao, double valor){
		this.setCodCartao(codCartao);
		this.setDataTransacao(dataTransacao);
		this.setSaldoAnterior(saldoAnterior);
		this.setSaldoAtual(saldoAtual);
		this.setDescricao(descricao);
		this.setValor(valor);
	}
	
	public HistoricoSaldoCartaoBean(){
		
	}
	
	public int getCodCartao() {
		return codCartao;
	}
	public void setCodCartao(int codCartao) {
		this.codCartao = codCartao;
	}
	public String getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public double getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	@Override
	public String toString() {
		return "HistoricoSaldoCartaoBean [codCartao=" + codCartao + ", dataTransacao=" + dataTransacao
				+ ", saldoAnterior=" + saldoAnterior + ", saldoAtual=" + saldoAtual + "]";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
