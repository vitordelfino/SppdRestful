package br.com.sppd.retorno;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Retorno {

	public Retorno(){
		this.retorno = false;
		this.status = "vazio";
	}
	public Retorno(boolean retorno, String status){
		this.retorno = retorno;
		this.status = status;
	}
	private boolean retorno;
	private String status;
	
	
	public boolean isRetorno() {
		return retorno;
	}
	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Retorno [retorno=" + retorno + ", status=" + status + "]";
	}
	
	
	
}

