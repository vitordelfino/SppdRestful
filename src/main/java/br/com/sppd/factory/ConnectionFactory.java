package br.com.sppd.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	
	private static ConnectionFactory instancia = null;
	
	private ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstance(){
		if(instancia == null)
			return new ConnectionFactory();
		
		return instancia;
	}
	
	
	
	private Connection conexao(){
		Connection con = null;
		/* uolhost
		   jdbc:mysql://bd-sppd.mysql.uhserver.com/bd_sppd
		   vitor_adm
		   224468.Delfino
		*/
		
		/*
		 * local
		 * jdbc:mysql://localhost/sppd_tg
		 * root
		 * 123456
		 * 
		 */
		try{
			String driveName = "com.mysql.jdbc.Driver";
			Class.forName(driveName);		
			String url = "jdbc:mysql://bd-sppd.mysql.uhserver.com/bd_sppd";
			String userName = "vitor_adm";
			String passWord = "sppd.Tg2017";
			
			con = DriverManager.getConnection(url,userName,passWord);
			
			if(con != null){
				System.out.println("Conectou...");
				return con;
			}else{
				return null;
			}	
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				return null;
			}catch(SQLException e ){
				e.printStackTrace();
				return null;
			}		
	}
	
	public Connection getConnection(){
		ConnectionFactory c = new ConnectionFactory();
		return c.conexao();
	}
}
