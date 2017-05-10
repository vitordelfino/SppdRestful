package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sppd.dbms.bean.Passageiro;
import br.com.sppd.factory.ConnectionFactory;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe responsável por realizar métodos de consulta ao BD relacionado a Passageiros
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 4 de dez de 2016
 */
public class PassageiroDAO {
	
	/**
	 * 
	 * Método responsável por realizar o cadastro de um novo passageiro
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 4 de dez de 2016
	 * @param passageiro
	 * @return
	 */
	public List<Retorno> cadastraPassageiro(Passageiro passageiro){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query1 = "select count(*) from passageiro p where p.cpf = ?";
		String query2 = "INSERT INTO passageiro(nome,cpf,rg,logradouro,numero,"
				+ "complemento,cep,bairro,municipio,nascimento,deficiente)"
				+ "values"
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		List<Retorno> retorno = new ArrayList<Retorno>();
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query1);
			pst.setString(1, passageiro.getCpf());
			rs = pst.executeQuery();
			rs.next();
			if(rs.getInt(1) > 0){
				retorno.add(new Retorno(false, "CPF: "+passageiro.getCpf()+" já cadastrado."));
				return retorno;
			}else{
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
		}catch(SQLException e){
			retorno.add(new Retorno(false, "Error: " + e.getMessage()));
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
