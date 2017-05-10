package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.sppd.dbms.bean.HistoricoSaldoCartaoBean;
import br.com.sppd.factory.ConnectionFactory;

/**
 * 
 * Classe responsável por realizar métodos de consulta ao BD relacionado a HistoricoSaldoCartao
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */
public class HistoricoSaldoCartaoDAO {

	/**
	 * 
	 * Método responsável por retornar o historico de saldo por id do cartao 
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 22 de mar de 2017
	 * @param getHistoricoCartao
	 * @return List<HistoricoSaldoCartaoBean>
	 *
	 */
	public List<HistoricoSaldoCartaoBean> getHistoricoCartao(int codCartao){		
		
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from historicoSaldoCartao h where h.codCartao = ? order by h.dataTransacao desc";
		List<HistoricoSaldoCartaoBean> retorno = new ArrayList<HistoricoSaldoCartaoBean>();
		 DateFormat format = new SimpleDateFormat("dd/MM/yy hh:MM");
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			pst.setInt(1, codCartao);
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				retorno.add(new HistoricoSaldoCartaoBean(codCartao, format.format(rs.getDate(3)), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getDouble(7)));
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
} 
