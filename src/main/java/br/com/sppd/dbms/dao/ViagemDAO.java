package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.bean.Viagem;
import br.com.sppd.factory.ConnectionFactory;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe respons�vel por realizar m�todos ao BD 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */
public class ViagemDAO {
	
	/*
	public Retorno setNovaViagem(Viagem viagem){
		Connection c = null;
		PreparedStatement pst = null;
		String query = "insert into Viagem"+
						"(codPassageiro, codCartao, origem)values(?,?,?)";
		
		
		Retorno retorno = new Retorno();
		retorno.setRetorno(false);
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			pst.setInt(1, viagem.getPassageiro().getCodPassageiro());
			pst.setInt(2, viagem.getCartao().getCodCartao());
			pst.setInt(3, viagem.getOrigem().getCodEstacao());
			
			System.out.println(query);
			
			pst.execute();
			retorno = new Retorno(true, "Sucess");
			
			return retorno;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			retorno.setStatus(sql.getMessage());
			return retorno;
			
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			retorno.setStatus(sql.getMessage());
			return retorno;
		}finally{
			try {
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}*/
	
	
	/*
	public Retorno setViagemCompleta(Viagem viagem){
		Connection c = null;
		PreparedStatement pst = null;
		String query = "insert into Viagem"+
			"(codPassageiro, codCartao,dataEntrada, dataSaida, origem, destino,"+
			"entrandoSaindo, valor)"+
			"values"+
			"(?,?,NOW(),NOW(),?,?,?,?,0,?)";
		Retorno retorno = new Retorno(false,"");
		
		try{
			pst = c.prepareStatement(query);
			pst.setInt(1, viagem.getPassageiro().getCodPassageiro());
			pst.setInt(2, viagem.getCartao().getCodCartao());
			pst.setInt(3, viagem.getOrigem().getCodEstacao());
			pst.setInt(4, viagem.getDestino().getCodEstacao());
			pst.setDouble(7, viagem.getValor());
			pst.execute();
			
			return retorno = new Retorno(true, "Sucess");
			
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			retorno.setStatus(sql.getMessage());
			return retorno;
			
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			retorno.setStatus(sql.getMessage());
			return retorno;
		}finally{
			try {
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
	}
	*/
	
	/**
	 * 
	 * M�todo respons�vel por retornar uma lista com as viagens feitas
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 18 de abr de 2017
	 * @param getHistoricoViagens
	 * @return List<Viagem>
	 *
	 */
	public List<Viagem> getHistoricoViagens(int codPassageiro){
		
		
		Connection c = null;
		PreparedStatement pst = null;
		String query = 	"select v.codPassageiro, v.codCartao, v.dataEntrada, v.dataSaida, "+
						"origem.codEstacao,origem.linha,origem.nome, " +
						"destino.codEstacao, destino.linha, destino.nome,v.entrandoSaindo,v.valor " +
						"from viagem v, estacao origem, estacao destino " +
						"where v.entrandoSaindo = 0 " +
						"and v.origem = origem.codEstacao " +
						"and v.destino = destino.codEstacao " +
						"and codPassageiro = ? order by dataEntrada desc";
		
		ResultSet rs = null;
		List<Viagem> viagens = new ArrayList<Viagem>();
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			pst.setInt(1, codPassageiro);
			rs = pst.executeQuery();
			
			while(rs.next()){
				viagens.add(new Viagem(
							rs.getInt(1),
							rs.getInt(2),
							rs.getString(3),
							rs.getString(4),
							new Estacao(rs.getInt(5),
										rs.getInt(6),
										rs.getString(7)),
							new Estacao(rs.getInt(8),
										rs.getInt(9),
										rs.getString(10)),
							rs.getInt(11),
							rs.getDouble(12))
						);
			}
			return viagens;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return viagens;
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return viagens;
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
	
	public List<Viagem> getHistoricoViagensSite(int codCartao){
		
		
		Connection c = null;
		PreparedStatement pst = null;
		String query = 	"select v.codPassageiro, v.codCartao, v.dataEntrada, v.dataSaida, "+
						"origem.codEstacao,origem.linha,origem.nome, " +
						"destino.codEstacao, destino.linha, destino.nome,v.entrandoSaindo,v.valor " +
						"from viagem v, estacao origem, estacao destino " +
						"where v.entrandoSaindo = 0 " +
						"and v.origem = origem.codEstacao " +
						"and v.destino = destino.codEstacao " +
						"and codCartao = ? order by dataEntrada desc";
		
		ResultSet rs = null;
		List<Viagem> viagens = new ArrayList<Viagem>();
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			pst.setInt(1, codCartao);
			rs = pst.executeQuery();
			
			while(rs.next()){
				viagens.add(new Viagem(
							rs.getInt(1),
							rs.getInt(2),
							rs.getString(3),
							rs.getString(4),
							new Estacao(rs.getInt(5),
										rs.getInt(6),
										rs.getString(7)),
							new Estacao(rs.getInt(8),
										rs.getInt(9),
										rs.getString(10)),
							rs.getInt(11),
							rs.getDouble(12))
						);
			}
			return viagens;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return viagens;
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return viagens;
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
