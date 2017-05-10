package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.HistoricoSaldoCartaoBean;
import br.com.sppd.dbms.dao.HistoricoSaldoCartaoDAO;

/**
 * 
 * Classe responsável por ser o controlador entre o resource e a camada DAO de HistoricoSaldoCartao 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */
public class HistoricoSaldoCartaoController {
	
	public List<HistoricoSaldoCartaoBean> getHistoricoCartao(int codCartao){
		return new HistoricoSaldoCartaoDAO().getHistoricoCartao(codCartao);
	}

}
