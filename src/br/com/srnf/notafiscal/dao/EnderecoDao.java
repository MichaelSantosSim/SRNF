package br.com.srnf.notafiscal.dao;

import br.com.srnf.notafiscal.bean.EnderecoBean;

public class EnderecoDao {
	public static void load(){
		try{
			java.sql.Connection dbc = DBConnection.getConnection();
			java.sql.Statement stmt = dbc.createStatement();
			try{
				java.sql.ResultSet rs = stmt.executeQuery("Select * FROM endereco");
				while(rs.next()){
					System.out.print("Logradouro: ");
					System.out.println(rs.getString(3));
				}
				
			}catch(Exception e){
				System.out.println("EnderecoDao.load: " + e.getMessage());
			}
			
		}catch(Exception e){
			System.out.println("EnderecoDao.load: " + e.getMessage());
		}
	}
}
