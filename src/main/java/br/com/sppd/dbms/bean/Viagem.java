package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe responsável por representar o uma Viagem
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */

@XmlRootElement
public class Viagem {

	private int id;
	private int passageiro;
	private int cartao;
	private String dataEntrada;
	private String dataSaida;
	private Estacao origem;
	private Estacao destino;
	private int entrandoSaindo;
	private double valor;
	public Viagem() {

	}

	public Viagem(int passageiro, int cartao, String dataEntrada, Estacao origem,
			double saldoAnterior, double saldoAtual) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setDataEntrada(dataEntrada);
		this.setOrigem(origem);
		this.setEntrandoSaindo(entrandoSaindo);
		
	}
	
	public Viagem(int passageiro, int cartao, String dataEntrada, Estacao origem, Estacao destino,
			double saldoAnterior, double saldoAtual, double valor) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setDataEntrada(dataEntrada);
		this.setOrigem(origem);
		this.setDestino(destino);
		this.setValor(valor);
		
	}

	public Viagem(int passageiro, int cartao, Estacao origem, Estacao destino,
			double saldoAnterior, double saldoAtual) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setOrigem(origem);
		this.setDestino(destino);
	}
	
	public Viagem(int passageiro, int cartao,String dataEntrada, String dataSaida, Estacao origem, Estacao destino,
			int entrandoSaindo, double valor) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setOrigem(origem);
		this.setDestino(destino);
		this.setDataEntrada(dataEntrada);
		this.setDataSaida(dataSaida);
		this.setValor(valor);
		this.setEntrandoSaindo(entrandoSaindo);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(int passageiro) {
		this.passageiro = passageiro;
	}

	public int getCartao() {
		return cartao;
	}

	public void setCartao(int cartao) {
		this.cartao = cartao;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Estacao getOrigem() {
		return origem;
	}

	public void setOrigem(Estacao origem) {
		this.origem = origem;
	}

	public Estacao getDestino() {
		return destino;
	}

	public void setDestino(Estacao destino) {
		this.destino = destino;
	}

	public int getEntrandoSaindo() {
		return entrandoSaindo;
	}

	public void setEntrandoSaindo(int entrandoSaindo) {
		this.entrandoSaindo = entrandoSaindo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
	
	

}
