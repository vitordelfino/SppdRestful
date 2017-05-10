package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.LoginBean;
import br.com.sppd.dbms.dao.Login;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe resposável por ser o controlador entre o resource e a camada DAO de Login
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 19 de fev de 2017
 */
public class LoginController {
	
	public List<LoginBean> logar(String usuario, String senha){
		return new Login().logar(usuario, senha); 
	}
	public Retorno alterarSenha(String cpf, String novaSenha){
		return new Login().alterarSenha(cpf, novaSenha);
	}
	
	public Retorno alterarSenha(String cpf, String senhaAtual, String novaSenha){
		return new Login().alterarSenha(cpf, senhaAtual, novaSenha);
	}
}
