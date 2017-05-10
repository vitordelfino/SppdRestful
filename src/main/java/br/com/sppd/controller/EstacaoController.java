package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.dao.EstacaoDAO;

/**
 * 
 * Classe resposável por ser o controlador entre o resource e a camada DAO de Estacoes
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 2 de dez de 2016
 */
public class EstacaoController {
	
	public List<Estacao> getListaEstacao(){
		return new EstacaoDAO().getListaEstacao();
	}
}
