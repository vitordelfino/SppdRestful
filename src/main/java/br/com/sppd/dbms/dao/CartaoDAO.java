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

import br.com.sppd.dbms.bean.Cartao;
import br.com.sppd.factory.ConnectionFactory;
import br.com.sppd.retorno.Retorno;

/**
 * Classe resposável por realizar interação com BD sonbre o Cartao
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 18 de fev de 2017
 */
public class CartaoDAO {

	/**
	 * 
	 * Método resposável por ativar o cartao
	 * 
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 18 de fev de 2017
	 * @param cartao
	 * @return
	 */
	public Retorno ativarCartao(Cartao cartao) {

		int aux = buscaCartao(cartao.getCodCartao());
		System.out.println("Resultado da busca: " + aux);

		if (aux == 1) {
			return new Retorno(false, "Cartão " + cartao.getCodCartao() + " ja ativo.");
		} else if (aux == 2) {
			return new Retorno(false, "Cartão " + cartao.getCodCartao() + " não encontrado.");
		} else if (aux == 3) {
			return new Retorno(false, "No momento nnãoo foi possível ativar o cartão.");
		} else {
			Connection c = null;
			PreparedStatement pst = null;
			String query1 = "update cartao c " + "set c.ativo = 1" + " where c.codCartao = ? and c.codPassageiro = ? ";
			try {
				c = new ConnectionFactory().getConnection();
				pst = c.prepareStatement(query1);
				pst.setInt(1, cartao.getCodCartao());
				pst.setInt(2, cartao.getCodPassageiro());
				pst.execute();
				return new Retorno(true, "Sucess");
			} catch (SQLException e) {
				return new Retorno(false, "Error: " + e.getMessage());
			} finally {
				try {
					System.out.println("** Finalizando Conexão **");
					pst.close();
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	/**
	 * 
	 * Método responsável por desativar o cartao
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 21 de mar de 2017
	 * @param desativarCartao
	 * @return Retorno
	 *
	 */
	public Retorno desativarCartao(Cartao cartao) {

		int aux = buscaCartao(cartao.getCodCartao());
		System.out.println("Resultado da busca: " + aux);

		if (aux == 0) {
			return new Retorno(false, "Cartão " + cartao.getCodCartao() + " ja desativado.");
		} else if (aux == 2) {
			return new Retorno(false, "Cartão " + cartao.getCodCartao() + " não encontrado.");
		} else if (aux == 3) {
			return new Retorno(false, "No momento nnãoo foi possível desativar o cartão.");
		} else {
			Connection c = null;
			PreparedStatement pst = null;
			String query1 = "update cartao c " + "set c.ativo = 0" + " where c.codCartao = ? and c.codPassageiro = ? ";
			try {
				c = new ConnectionFactory().getConnection();
				pst = c.prepareStatement(query1);
				pst.setInt(1, cartao.getCodCartao());
				pst.setInt(2, cartao.getCodPassageiro());
				pst.execute();
				return new Retorno(true, "Sucess");
			} catch (SQLException e) {
				return new Retorno(false, "Error: " + e.getMessage());
			} finally {
				try {
					System.out.println("** Finalizando Conexão **");
					pst.close();
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	

	/**
	 * 
	 * Método resposável por efetuar recarga do cartao
	 * 
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 18 de fev de 2017
	 * @param cartao
	 * @param valor
	 */
	public Retorno efetuarRecarga(Cartao cartao, double valor) {
		int aux = buscaCartao(cartao.getCodCartao());
		System.out.println("Resultado da busca: " + aux);

		if (aux == 0) {
			return new Retorno(false, "Cartão " + cartao.getCodCartao() + " inativo.");
		
		} else {
		
			Connection c = null;
			PreparedStatement pst = null;
			String query = "update cartao c " + "set c.saldo =  c.saldo + ? " + "where c.codCartao = ? and c.codPassageiro = ?";
		
			try {
				c = new ConnectionFactory().getConnection();
				pst = c.prepareStatement(query);
				pst.setDouble(1, valor);
				pst.setInt(2, cartao.getCodCartao());
				pst.setInt(3, cartao.getCodPassageiro());
				pst.execute();
		
				return new Retorno(true, "Recarga no valor de R$ " + valor + " efetuada.");
		
			} catch (SQLException e) {
				return new Retorno(false, "Error: " + e.getMessage());
			} finally {
				try {
					System.out.println("** Finalizando Conexões **");
					pst.close();
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public List<Cartao> getCartoes(int codPassageiro) {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from cartao c where c.codPassageiro = ?";
		List<Cartao> retorno = new ArrayList<Cartao>();
		try {
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(sql);
			pst.setInt(1, codPassageiro);
			rs = pst.executeQuery();

			while (rs.next()) {
				retorno.add(new Cartao(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4),
						rs.getDouble(5),  rs.getInt(6)));
			}
			return retorno;

		} catch (SQLException e) {
			return retorno;
		} finally {
			try {
				System.out.println("** Finalizando Coneção **");
				rs.close();
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private int buscaCartao(int codCartao) {
		System.out.println("**Buscando Cartao: " + codCartao);
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query1 = "select c.ativo from cartao c where c.codCartao = ?";

		try {
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query1);
			pst.setInt(1, codCartao);
			rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return 2;
		} catch (SQLException e) {
			return 3;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (c != null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
