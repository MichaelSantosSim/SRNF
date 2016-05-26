package br.com.srnf.notafiscal.dao;

import java.sql.SQLException;

import br.com.srnf.notafiscal.bean.NotaFiscal;

public class NotaFiscalDao {
	
	public static NotaFiscal getWithId(int id) throws SQLException{
		NotaFiscal nota = new NotaFiscal();
		java.sql.ResultSet rs = DBConnection.getStatement().executeQuery("SELECT * FROM nota_fiscal WHERE nota_fiscal_id = " + id);
		rs.next();
		
		nota.setId(id);
		nota.setTomador(TomadorDao.getWithId(rs.getInt(2)));
		nota.setTomadorEstrangeiro(rs.getBoolean(3));
		nota.setInformacoesAdicionais(rs.getString(4));
		nota.setAtividade(rs.getString(5));
		nota.setValor(rs.getFloat(6));
		nota.setValorIr(rs.getFloat(7));
		nota.setValorInss(rs.getFloat(8));
		nota.setValorCofins(rs.getFloat(9));
		nota.setValorPisPasep(rs.getFloat(10));
		nota.setCsll(rs.getFloat(11));
		nota.setValorOutrosImpostos(rs.getFloat(12));
		nota.setSubstituicaoTributaria(rs.getBoolean(13));
		nota.setNotificarTomadorPorEmail(rs.getBoolean(14));
		nota.setEnderecoPrestacaoServico(rs.getString(15));
		nota.setCidadePrestacaoServico(rs.getString(16));
		nota.setCepPrestacaoServico(rs.getString(17));
		nota.setEstadoPrestacaoServico(rs.getString(18));
		
		return nota;
	}
	
	public static void addNotaFiscal(NotaFiscal nota) throws SQLException{
		java.sql.Statement stmt = DBConnection.getStatement();
		
		String cmd = "INSERT INTO nota_fiscal(tomador_id,  tomador_estrangeiro_bl, informacoes_adicionais_tx, atividade_tx,"
      + "valor_fl, valor_ir_fl, valor_inss_fl, valor_cofins_fl, valor_pis_pasep_fl, csll_fl,"
      + "valor_outros_impostos_fl, substituicao_tributaria_bl, notificar_tomador_por_email_bl,"
      + "cidade_prestacao_servico_sn, endereco_prestacao_servico_tx, cep_prestacao_servico_sn,"
      + "estado_prestacao_servico_sn ) VALUES ("
      + nota.getTomador().getId() + ", "
      + getBoolStr(nota.isTomadorEstrangeiro()) + ", \""
      + nota.getInformacoesAdicionais() + "\", \""
      + nota.getAtividade() + "\", "
      + nota.getValor() + ", "
      + nota.getValorIr() + ", "
      + nota.getValorInss() + ", "
      + nota.getValorCofins() + ", "
      + nota.getValorPisPasep() + ", "
      + nota.getCsll() + ", "
      + nota.getValorOutrosImpostos() + ", "
      + getBoolStr(nota.isSubstituicaoTributaria()) + ", "
      + getBoolStr(nota.isNotificarTomadorPorEmail()) + ", \""
      + nota.getEnderecoPrestacaoServico() + "\", \""
      + nota.getCidadePrestacaoServico() + "\", \""
      + nota.getCepPrestacaoServico() + "\", \""
      + nota.getEstadoPrestacaoServico() + "\")";
		
		stmt.executeUpdate(cmd);
	}
	
	public static String getBoolStr(Boolean b){
		return b ? "True" : "False";
	}
}
