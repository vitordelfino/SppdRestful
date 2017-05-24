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
 * Classe responsável por realizar métodos de consulta ao BD relacionado a
 * Passageiros
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 4 de dez de 2016
 */
public class PassageiroDAO {

	private static PassageiroDAO instancia = null;

	private PassageiroDAO() {

	}

	public static PassageiroDAO getInstance() {
		if (instancia == null)
			return new PassageiroDAO();
		return instancia;
	}

	/**
	 * 
	 * Método responsável por realizar o cadastro de um novo passageiro
	 * 
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 4 de dez de 2016
	 * @param passageiro
	 * @return
	 */
	public List<Retorno> cadastraPassageiro(Passageiro passageiro) {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query1 = "select count(*) from passageiro p where p.cpf = ?";
		String query2 = "INSERT INTO passageiro(nome,cpf,rg,logradouro,numero,"
				+ "complemento,cep,bairro,municipio,nascimento,deficiente)" + "values" + "(?,?,?,?,?,?,?,?,?,?,?)";
		List<Retorno> retorno = new ArrayList<Retorno>();
		try {
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(query1);
			pst.setString(1, passageiro.getCpf());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {
				retorno.add(new Retorno(false, "CPF: " + passageiro.getCpf() + " já cadastrado."));
				return retorno;
			} else {
				pst = c.prepareStatement(query2);
				pst.setString(1, passageiro.getNome());
				pst.setString(2, passageiro.getCpf());
				pst.setString(3, passageiro.getRg());
				pst.setString(4, passageiro.getLogradouro());
				pst.setString(5, passageiro.getNumero());
				pst.setString(6, passageiro.getComplemento());
				pst.setString(7, passageiro.getCep());
				pst.setString(8, passageiro.getBairro());
				pst.setString(9, passageiro.getMunicipio());
				pst.setString(10, passageiro.getNascimento());
				pst.setBoolean(11, passageiro.isDeficiente());
				pst.execute();

				retorno.add(new Retorno(true, "Sucess"));
				return retorno;
			}
		} catch (SQLException e) {
			retorno.add(new Retorno(false, "Error: " + e.getMessage()));
			return retorno;
		} finally {
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

	public Retorno vincularFacebook(String facebookId, String urlPicture, int codPassageiro) {

		Connection c = null;
		PreparedStatement pst = null;
		String sql = "update passageiro set facebookId = ?, urlPicture = ? where codPassageiro = ?";
		try {
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, facebookId);
			pst.setString(2, urlPicture);
			pst.setInt(3, codPassageiro);

			pst.execute();
			return new Retorno(true, "Conta Vinculada");

		} catch (SQLException e) {
			e.printStackTrace();
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

	public Passageiro getPassageiroFacebookId(String facebookId) {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from passageiro where facebookId = ?";
		try {
			c = ConnectionFactory.getInstance().getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, facebookId);

			rs = pst.executeQuery();
			Passageiro p = new Passageiro();
			while (rs.next()) {

				p.setCodPassageiro(rs.getInt(1));
				p.setFacebookId(rs.getString(2));
				p.setNome(rs.getString(3));
				p.setCpf(rs.getString(4));
				p.setRg(rs.getString(5));
				p.setLogradouro(rs.getString(6));
				p.setNumero(rs.getString(7));
				p.setComplemento(rs.getString(8));
				p.setCep(rs.getString(9));
				p.setBairro(rs.getString(10));
				p.setMunicipio(rs.getString(11));
				p.setNascimento(rs.getString(12));

				if (rs.getInt(13) > 0)
					p.setDeficiente(true);
				p.setDeficiente(false);

				p.setUrlPicture(rs.getString(14));

			}
			return p;

		} catch (SQLException e) {
			e.printStackTrace();
			return new Passageiro();
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
	
	public LoginBean cadastrarComFacebook(String facebookId, String urlPicture, String nome) {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into passageiro(facebookId, urlPicture, nome)values(?,?,?)";
		String sql2 = "select count(*) from passageiro where facebookId = ? ";
		
		LoginBean retorno = new LoginBean();
		retorno.setStatusRetorno("Usuario já cadastrado");
		
		
		try {
			c = ConnectionFactory.getInstance().getConnection();
			
			
			pst = c.prepareStatement(sql2);
			pst.setString(1, facebookId);
			rs = pst.executeQuery();
			
			rs.next();
			
			if(rs.getInt(1) == 0){
				pst = c.prepareStatement(sql);
				pst.setString(1, facebookId);
				pst.setString(2, urlPicture);
				pst.setString(3, nome.toUpperCase());
				pst.execute();
				
				retorno.setStatusRetorno("Cadastrado realizado");
				
			}
			
			Passageiro passageiro = getPassageiroFacebookId(facebookId);
			
			retorno.setPassageiro(passageiro);
			retorno.setRetorno(true);
			
			return retorno;

		} catch (SQLException e) {
			e.printStackTrace();
			retorno.setRetorno(false);
			retorno.setStatusRetorno(e.getMessage());
			return retorno;
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
