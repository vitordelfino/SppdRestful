package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.Passageiro;
import br.com.sppd.dbms.dao.PassageiroDAO;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe resposável por  ser o controlador entre o resource e a camada DAO de Passageiros
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 4 de dez de 2016
 */
public class PassageiroController {
	
	/**
	 * 
	 * Método resposável por chamar a classe DAO de Passageiros
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 4 de dez de 2016
	 * @param passageiro
	 * @return
	 */
	public List<Retorno> cadastraPassageiro(Passageiro passageiro){
		return new PassageiroDAO().cadastraPassageiro(passageiro);
	}

}
