package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sppd.dbms.bean.LoginBean;
import br.com.sppd.dbms.bean.Passageiro;
import br.com.sppd.factory.ConnectionFactory;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe responsável por implementar login no sistema
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 4 de dez de 2016
 */
public class Login {
	
private static Login instancia = null;
	
	private Login(){
		
	}
	
	public static Login getInstance(){
		if(instancia == null)
			return new Login();
		return instancia;
	}
	
	public List<LoginBean> logar(String usuario, String senha){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select count(*) from login l where l.username = ? and l.password = ?";
		String sql2 = "select * from passageiro p where p.cpf = ?";
		List<LoginBean> l = new ArrayList<>();
		try{
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			rs = pst.executeQuery();
			
			rs.next();
			if(rs.getInt(1) > 0){
				pst = c.prepareStatement(sql2);
				pst.setString(1, usuario);
				rs = pst.executeQuery();
				rs.next();
				Passageiro p = new Passageiro(
						rs.getInt(1),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getBoolean(13),
						rs.getString(2),
						rs.getString(14));
				l.add(new LoginBean(p,true, "Sucess"));
				return l;
			}else{
				l.add(new LoginBean(false, "usuário ou Senha não encontrado"));
				return l;
			}
		}catch(SQLException e){
			l.add(new LoginBean(false, e.getMessage()));
			return l;
		}finally{
			try {
				rs.close();
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	/**
	 * 
	 * Método responsável por alterar a senha de acesso
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 19 de fev de 2017
	 * @param cpf
	 * @param senhaAtual
	 * @param NovaSenha
	 * @return
	 */
	public Retorno alterarSenha(String cpf, String senhaAtual, String novaSenha){
			
		if(!validarSenha(cpf, senhaAtual))
			return new Retorno(false, "Senha atual incorreta !");
		System.out.println("Senha atual validada");
		Connection c = null;
		PreparedStatement pst = null;
		String sql = "update login l " +
				"set l.password = ? " +
				"where l.username = ? ";		
		try{
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, novaSenha);
			pst.setString(2, cpf);
			pst.execute();
			System.out.println("Senha alterada");
			return new Retorno(true, "Sucess");
		}catch (SQLException e) {
			return new Retorno(false, "Error: " + e.getMessage());
		}finally {
			try {
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * Método responsável por alterar senha do usuário ao logar pela primeira vez
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 19 de fev de 2017
	 * @param cpf
	 * @param senhaAtual
	 * @param NovaSenha
	 * @return
	 */
	public Retorno alterarSenha(String cpf, String novaSenha){
		System.out.println("Alterando senha do usuário: " + cpf);
		System.out.println("Nova Senha = " + novaSenha);
		Connection c = null;
		PreparedStatement pst = null;
		String sql = "update login l " +
				"set l.password = ? " +
				"where l.username = ? ";
		
		try{
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(sql);			
			pst.setString(1, novaSenha);
			pst.setString(2, cpf);
			pst.execute();
			System.out.println("Senha alterada");
			return new Retorno(true, "Sucess");
		}catch (SQLException e) {
			return new Retorno(false, "Error: " + e.getMessage());
		}finally {
			try {
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * Método responsável por validar se as senhas enviadas são iguais
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 19 de fev de 2017
	 * @param cpf
	 * @param senha
	 * @return
	 */
	public boolean validarSenha(String cpf, String senha){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select l.password from login l where l.username = ? ";
		try{
			System.out.println("Buscando usuário: " + cpf);
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, cpf);
			rs = pst.executeQuery();
			
			rs.next();			
			if(senha.equals(rs.getString(1))){
				System.out.println("Senha confere: true" );
				return true;
			}else{
				System.out.println("Senha confere: false" );
				return false;
			}
		}catch (SQLException e) {
			System.out.println("Error: " + e.getMessage() );
			return false;
		}finally {
			try {
				pst.close();
				c.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
