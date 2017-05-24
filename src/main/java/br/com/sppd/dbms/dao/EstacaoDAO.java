package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dijkstra.Vertice;
import br.com.sppd.factory.ConnectionFactory;

public class EstacaoDAO {
	
	private static EstacaoDAO instancia = null;
	
	private EstacaoDAO() {
	}
	
	public static EstacaoDAO getInstance() {
		
		if ( instancia == null ) {
			instancia = new EstacaoDAO();
		}
		
		return instancia;
	}
	
	public List<Estacao> getEstacao(List<Vertice> lv) {
		return buscaEstacoes(lv);
	}
	
	
	/**
	 * 
	 * Método responsável por buscar uma lista de estações
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 12 de mai de 2017
	 * @param buscaEstacoes
	 * @return List<Estacao>
	 *
	 */
	private List<Estacao> buscaEstacoes(List<Vertice> lv) {

		List<Estacao> retorno = new ArrayList<Estacao>();
		String query = "select e.codEstacao, e.nome, e.linha from estacao e where e.codEstacao in ("+ monstarQuery(lv)+")";
		System.out.println(query);
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			
			
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(query);
			rs = pst.executeQuery();
			
			
			
			while(rs.next()){
				
				retorno.add(new Estacao(rs.getInt(1), rs.getInt(3), rs.getString(2)));
			}
			
			return retorno;
			
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return retorno;
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return retorno;
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
	
	
	private String monstarQuery(List<Vertice> lv){
		
		
		String codEstacoes = "";
		
		for(Vertice vertice : lv){
			codEstacoes += vertice.getDescricao()+" ";
		}
		return codEstacoes.substring(0, (codEstacoes.length()-1)).replaceAll(" ", ",");
		
	}
	
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
			c = ConnectionFactory.getInstance().getConnection();
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
			c = ConnectionFactory.getInstance().getConnection();
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
