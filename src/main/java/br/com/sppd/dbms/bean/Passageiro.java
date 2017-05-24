package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe resposável por representar um passageiro
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 4 de dez de 2016
 */

@XmlRootElement
public class Passageiro {

	private int codPassageiro = 0;
	private String nome = "";
	private String cpf = "";
	private String rg = "";
	private String logradouro = "";
	private String numero = "";
	private String complemento = "";
	private String cep = "";
	private String bairro = "";
	private String municipio = "";
	private String nascimento = "";
	private boolean deficiente = false;
	private String facebookId = "";
	private String urlPicture = "";

	public Passageiro() {

	}

	public Passageiro(int codPasssageiro) {
		this.setCodPassageiro(codPasssageiro);
	}

	public Passageiro(int codPassageiro, String nome, String cpf, String rg, String logradouro, String numero,
			String complemento, String cep, String bairro, String municipio, String nascimento, boolean deficiente, String facebookId, String urlPicture) {
		super();
		this.codPassageiro = codPassageiro;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.municipio = municipio;
		this.nascimento = nascimento;
		this.deficiente = deficiente;
		this.facebookId = facebookId;
		this.urlPicture = urlPicture;
	}

	public Passageiro(int codPassageiro, String nome, String cpf, String rg, String logradouro, String numero,
			String cep, String bairro, String municipio, String nascimento, boolean deficiente) {
		super();
		this.codPassageiro = codPassageiro;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.municipio = municipio;
		this.nascimento = nascimento;
		this.deficiente = deficiente;
		this.complemento = " ";
	}

	public int getCodPassageiro() {
		return codPassageiro;
	}

	public void setCodPassageiro(int codPassageiro) {
		this.codPassageiro = codPassageiro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public boolean isDeficiente() {
		return deficiente;
	}

	public void setDeficiente(boolean deficiente) {
		this.deficiente = deficiente;
	}	

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getUrlPicture() {
		return urlPicture;
	}

	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}

	@Override
	public String toString() {
		return "Passageiro [codPassageiro=" + codPassageiro + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg
				+ ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep
				+ ", bairro=" + bairro + ", municipio=" + municipio + ", nascimento=" + nascimento + ", deficiente="
				+ deficiente + "]";
	}
	
	

}
