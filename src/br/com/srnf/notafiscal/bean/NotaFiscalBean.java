package br.com.srnf.notafiscal.bean;

public class NotaFiscalBean {
	
	private TomadorBean tomador;
	private boolean tomadorEstrangeiro;
	private String informacoesAdicionais;
	private String atividade;
	private float valor;
	private float valorIr;
	private float valorInss;
	private float valorCofins;
	private float valorPisPasep;
	private float Csll;
	private float valorOutrosImpostos;
	private boolean substituicaoTributaria;
	private boolean notificarTomadorPorEmail;
	private String enderecoPrestacaoServico;
	private String cidadePrestacaoServico;
	private String cepPrestacaoServico;
	private String estadoPrestacaoServico;
	
	public TomadorBean getTomador() {
		return tomador;
	}
	public void setTomador(TomadorBean tomador) {
		this.tomador = tomador;
	}
	public boolean isTomadorEstrangeiro() {
		return tomadorEstrangeiro;
	}
	public void setTomadorEstrangeiro(boolean tomadorEstrangeiro) {
		this.tomadorEstrangeiro = tomadorEstrangeiro;
	}
	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}
	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getValorIr() {
		return valorIr;
	}
	public void setValorIr(float valorIr) {
		this.valorIr = valorIr;
	}
	public float getValorInss() {
		return valorInss;
	}
	public void setValorInss(float valorInss) {
		this.valorInss = valorInss;
	}
	public float getValorCofins() {
		return valorCofins;
	}
	public void setValorCofins(float valorCofins) {
		this.valorCofins = valorCofins;
	}
	public float getValorPisPasep() {
		return valorPisPasep;
	}
	public void setValorPisPasep(float valorPisPasep) {
		this.valorPisPasep = valorPisPasep;
	}
	public float getCsll() {
		return Csll;
	}
	public void setCsll(float csll) {
		Csll = csll;
	}
	public float getValorOutrosImpostos() {
		return valorOutrosImpostos;
	}
	public void setValorOutrosImpostos(float valorOutrosImpostos) {
		this.valorOutrosImpostos = valorOutrosImpostos;
	}
	public boolean isSubstituicaoTributaria() {
		return substituicaoTributaria;
	}
	public void setSubstituicaoTributaria(boolean substituicaoTributaria) {
		this.substituicaoTributaria = substituicaoTributaria;
	}
	public boolean isNotificarTomadorPorEmail() {
		return notificarTomadorPorEmail;
	}
	public void setNotificarTomadorPorEmail(boolean notificarTomadorPorEmail) {
		this.notificarTomadorPorEmail = notificarTomadorPorEmail;
	}
	public String getEnderecoPrestacaoServico() {
		return enderecoPrestacaoServico;
	}
	public void setEnderecoPrestacaoServico(String enderecoPrestacaoServico) {
		this.enderecoPrestacaoServico = enderecoPrestacaoServico;
	}
	public String getCidadePrestacaoServico() {
		return cidadePrestacaoServico;
	}
	public void setCidadePrestacaoServico(String cidadePrestacaoServico) {
		this.cidadePrestacaoServico = cidadePrestacaoServico;
	}
	public String getCepPrestacaoServico() {
		return cepPrestacaoServico;
	}
	public void setCepPrestacaoServico(String cepPrestacaoServico) {
		this.cepPrestacaoServico = cepPrestacaoServico;
	}
	public String getEstadoPrestacaoServico() {
		return estadoPrestacaoServico;
	}
	public void setEstadoPrestacaoServico(String estadoPrestacaoServico) {
		this.estadoPrestacaoServico = estadoPrestacaoServico;
	}
	
	
}
