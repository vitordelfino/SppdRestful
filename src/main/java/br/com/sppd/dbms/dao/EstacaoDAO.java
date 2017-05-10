/**
 * 
 */
package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.EscapeTokenizer;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.factory.ConnectionFactory;

/**
 * Classe responsável por realizar métodos de consulta ao BD relacionado a Estação
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 2 de dez de 2016
 */
public class EstacaoDAO {
	
	/**
	 * 
	 * Método responsável por acessar o Banco e retornar todas as Estacoes cadastradas
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 2 de dez de 2016
	 * @return List<Estacao>
	 */
	public List<Estacao> getListaEstacao(){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from estacao order by nome asc";
		List<Estacao> estacao = new ArrayList<Estacao>();
		
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				estacao.add(new Estacao(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
			return estacao;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return estacao;
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return estacao;
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
	
	public Estacao getEstacao(String nomeEstacao){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from estacao e where e.nome = ?";
		
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			pst.setString(1, nomeEstacao);
			rs = pst.executeQuery();
			Estacao e = new Estacao();
			while(rs.next()){
				e = new Estacao(rs.getInt(1), rs.getInt(2), rs.getString(3));
			}
			return e;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return new Estacao();
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return new Estacao();
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

}
