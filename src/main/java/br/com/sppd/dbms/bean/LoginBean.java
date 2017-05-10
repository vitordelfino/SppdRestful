package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginBean {

	private Passageiro passageiro;
	private String usuario;
	private String senha;
	private boolean retorno;
	private String statusRetorno;
	
	public LoginBean(){
		
	}
	
	public LoginBean(boolean retorno, String statusRetorno) {
		super();
		this.retorno = retorno;
		this.statusRetorno = statusRetorno;
		this.passageiro = new Passageiro();
	}
	
	public LoginBean(Passageiro passageiro,boolean retorno, String statusRetorno) {
		super();
		this.passageiro = passageiro;
		this.retorno = retorno;
		this.statusRetorno = statusRetorno;
	}


	
	
	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isRetorno() {
		return retorno;
	}
	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}
	public String getStatusRetorno() {
		return statusRetorno;
	}
	public void setStatusRetorno(String statusRetorno) {
		this.statusRetorno = statusRetorno;
	}

	@Override
	public String toString() {
		return "LoginBean [retorno=" + retorno + ", statusRetorno=" + statusRetorno + "Passageiro=" + passageiro.toString() + "]";
	}
	
	
}
