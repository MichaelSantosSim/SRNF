 package br.com.srnf.notafiscal.dao;

import java.sql.SQLException;

import br.com.srnf.notafiscal.bean.Endereco;

public class EnderecoDao {
	
	
	public static Endereco getWithId(int id) throws SQLException{
		
		try{
			Endereco endereco = new Endereco();
			java.sql.ResultSet rs = DBConnection.getStatement().executeQuery("SELECT * FROM endereco WHERE endereco_id = " + id);
			rs.next();
			endereco.setId(rs.getInt(1));
			endereco.setTipoLogradouro(rs.getString(2));
			endereco.setLogradouro(rs.getString(3));
			endereco.setNumero(rs.getInt(4));
			endereco.setComplemento(rs.getString(5));
			endereco.setBairro(rs.getString(6));
			endereco.setCidade(rs.getString(7));
			endereco.setCep(rs.getString(8));
			endereco.setEstado(rs.getString(9));
			endereco.setPais(rs.getString(10));
			
			return endereco;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.closeConnection();
		}
	}
	
	public static void addEndereco(Endereco endereco) throws SQLException{
		
		java.sql.Statement stmt = DBConnection.getStatement();
		
		String cmd = "INSERT INTO endereco( tipo_logradouro_sn, logradouro_ln, numero, complemento_ln,"
				   + " bairro_ln, cidade_ln, cep_sn, estado_sn, pais_sn) VALUES (\""
				   + endereco.getTipoLogradouro() + "\", \""
				   + endereco.getLogradouro() + "\", "
				   + endereco.getNumero() + ", \""
				   + endereco.getComplemento() + "\", \""
				   + endereco.getBairro() + "\", \""
				   + endereco.getCidade() + "\", \""
				   + endereco.getCep() + "\", \""
				   + endereco.getEstado() + "\", \""
				   + endereco.getPais()
				   + "\")";
		stmt.executeUpdate(cmd);
		
	}
}
