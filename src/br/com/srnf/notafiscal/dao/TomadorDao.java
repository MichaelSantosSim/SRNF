package br.com.srnf.notafiscal.dao;

import java.sql.SQLException;

import br.com.srnf.notafiscal.bean.Tomador;

public class TomadorDao {
	public static Tomador getWithId(int id) throws SQLException{
		
		Tomador tomador = new Tomador();
		java.sql.ResultSet rs = DBConnection.getStatement().executeQuery("SELECT * FROM tomador WHERE tomador_id = " + id);	
		rs.next();
		
		tomador.setCnpj(rs.getString(1));
		tomador.setCpf(rs.getString(2));
		tomador.setInscricaoMunicipal(rs.getString(3));
		tomador.setNome(rs.getString(4));
		tomador.setEndereco(EnderecoDao.getWithId(rs.getInt(5)));
		tomador.setDdd(rs.getInt(6));
		tomador.setTelefone(rs.getString(7));
		
		
		return tomador;
	}
	
	public static void addTomador(Tomador tomador) throws SQLException{
		
		java.sql.Statement stmt = DBConnection.getStatement();
		
		String cmd = "INSERT INTO tomador( cnpj_sn, cpf_sn, inscricao_municipal_sn, nome_ln, endereco_id, DDD,  telefone) "
				+ "VALUES(\""
				+ tomador.getCnpj()+ "\", \""
				+ tomador.getCpf() + "\", \""
				+ tomador.getInscricaoMunicipal() + "\", \""
				+ tomador.getNome() + "\", "
				+ tomador.getEndereco().getId()+ ", \""
				+ tomador.getDdd() + "\", \""
				+ tomador.getTelefone()+ "\")";
		System.out.println(cmd);
		stmt.executeUpdate(cmd);
	}
}
