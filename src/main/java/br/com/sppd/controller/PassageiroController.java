package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.LoginBean;
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
		return PassageiroDAO.getInstance().cadastraPassageiro(passageiro);
	}
	
	/**
	 * 
	 * Método responsável por atualizar cadastro do usuário com dados do facebook
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 21 de mai de 2017
	 * @param vincularFacebook
	 * @return Retorno
	 *
	 */
	public Retorno vincularFacebook(String facebookId, String urlPicture, int codPassageiro){
		return PassageiroDAO.getInstance().vincularFacebook(facebookId, urlPicture, codPassageiro);
	}
	
	/**
	 * 
	 * Método responsável por retornar passageiro pelo facebookId
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 21 de mai de 2017
	 * @param getPassageiroFacebookId
	 * @return Passageiro
	 *
	 */
	public Passageiro getPassageiroFacebookId(String facebookId){
		return PassageiroDAO.getInstance().getPassageiroFacebookId(facebookId);
	}
	
	
	public LoginBean cadastrarComFacebook(String facebookId, String urlPicture, String nome){
		return PassageiroDAO.getInstance().cadastrarComFacebook(facebookId, urlPicture, nome);
	}

}
