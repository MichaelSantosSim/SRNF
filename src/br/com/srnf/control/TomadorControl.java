package br.com.srnf.control;

import b.com.srnf.exceptions.InvalidArgumentException;
import br.com.srnf.notafiscal.bean.Endereco;
import br.com.srnf.notafiscal.bean.Tomador;

public class TomadorControl extends AbstractControl {
	
	private int id;
	private String cnpj;					/* tem que ser valido ou cpf */
	private String cpf;						/* tem que ser valido ou o cpnj */
	private int ddd;
	private Endereco endereco;				/* tem que ser valido */
	private String inscricaoMunicipal;
	private String nome;					/* tem que ser valido */
	private String telefone;
	
	public TomadorControl(){}
	
	public Tomador build() throws InvalidArgumentException{
		

		checkString(nome, "O nome do tomador");
		/* TODO: 1.1 - O TomadorControl tem que checar o endereco */
		checkNumber(ddd, "O DDD");
		checkCpfCnpj(this.cpf, this.cnpj);					/* um dos dois deve ser valido */
		
		
		new EnderecoControl().checkEndereco(endereco);
		
		Tomador tomador = new Tomador();
		
		tomador.setCnpj(this.cnpj);
		tomador.setCpf(this.cpf);
		tomador.setDdd(this.ddd);
		tomador.setEndereco(this.endereco);
		tomador.setInscricaoMunicipal(this.inscricaoMunicipal);
		tomador.setNome(this.nome);
		tomador.setTelefone(this.telefone);
		
		return new Tomador();
	}
	
	
	public TomadorControl setId(int id){
		this.id = id;
		return this;
	}
	public TomadorControl setCnpj(String cnpj){
		this.cnpj = cnpj;
		return this;
	}
	
	public TomadorControl setCpf(String cpf){
		this.cpf = cpf;
		return this;
	}
	
	public TomadorControl setDdd(int ddd){
		this.ddd = ddd;
		return this;
	}
	
	public TomadorControl setEndereco(Endereco endereco){
		this.endereco = endereco;
		return this;
	}
	
	public TomadorControl setInscricaoMunicipal(String inscricaoMunicipal){
		this.inscricaoMunicipal = inscricaoMunicipal;
		return this;
	}
	
	public TomadorControl setNome(String nome){
		this.nome = nome;
		return this;
	}
	
	public TomadorControl setTelefone(String telefone){
		this.telefone = telefone;
		return this;
	}
}
