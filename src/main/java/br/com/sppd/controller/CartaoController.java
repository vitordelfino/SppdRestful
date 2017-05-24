/**
 * 
 */
package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.Cartao;
import br.com.sppd.dbms.dao.CartaoDAO;
import br.com.sppd.retorno.Retorno;

/**
 * Classe resposável por ser o controlador entre o resource e a camada DAO de Cartao
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 18 de fev de 2017
 */
public class CartaoController {
	
	public List<Cartao> getCartoes(int codPassageiro){		
		return CartaoDAO.getInstance().getCartoes(codPassageiro);	
	}
	
	public Retorno efetuarRecarga(Cartao cartao, double valor){
		return CartaoDAO.getInstance().efetuarRecarga(cartao, valor);
	}
	
	public Retorno ativarCartao(Cartao cartao){
		return CartaoDAO.getInstance().ativarCartao(cartao);
	}
	
	public Retorno desativarCartao(Cartao cartao){
		return CartaoDAO.getInstance().desativarCartao(cartao);
	}
}
