package br.com.srnf.control;

import java.sql.SQLException;

import b.com.srnf.exceptions.DataBaseException;
import b.com.srnf.exceptions.InvalidArgumentException;
import br.com.srnf.notafiscal.bean.Endereco;
import br.com.srnf.notafiscal.dao.EnderecoDao;

public class EnderecoControl extends AbstractControl {
	
	private int id = 0;
	private String bairro;
	private String cep;
	private String cidade;
	private String complemento = ""; /* pode estar vazio */
	private String estado;
	private int numero;
	private String pais;
	private String logradouro;
	private String tipoLogradouro;
	
	public EnderecoControl(){}
	
	/**
	 * Verifica os campos e retorna um objeto Endereco
	 * 
	 * @return Retorna um objeto endereco
	 * @throws InvalidArgumentException com a mensagem de erro
	 */
	public Endereco build() throws InvalidArgumentException {
		
		
		/* esta parte verifica se os campos estão corretos e
		   atira uma InvalidArgumentException caso nao esteja
		   de acordo */
		
		checkString(tipoLogradouro, "O Tipo de Logradouro");
		checkString(logradouro, "O Logradouro");
		checkString(cidade, "A Cidade");
		checkString(estado, "O Estado");
		checkString(cep, "O Cep");
		checkString(bairro, "O Bairro");
		checkNumber(numero, "O Número da residência");
		
		/* Se não houver exceções, então montamos e devolvemos
		   o endereco montado */
			
		Endereco endereco = new Endereco();
		endereco.setId(id);
		endereco.setBairro(this.bairro);
		endereco.setCep(this.cep);
		endereco.setCidade(this.cidade);
		endereco.setComplemento(this.complemento);
		endereco.setEstado(this.estado);
		endereco.setNumero(this.numero);
		endereco.setPais(this.pais);
		endereco.setLogradouro(this.logradouro);
		endereco.setTipoLogradouro(this.tipoLogradouro);

		return endereco;
		
	}
	
	/**
	 * Verifica se um objeto Endereco tem seus campos corretos
	 * 
	 *  @param e - O objeto a ser analisado
	 *  @throws InvalidArgumentException - Exceção com a mensagem de erro
	 */
	public void checkEndereco(Endereco e) throws InvalidArgumentException{
		try{
			checkString(tipoLogradouro, "O Tipo de Logradouro");
			checkString(logradouro, "O Logradouro");
			checkString(cidade, "A Cidade");
			checkString(estado, "O Estado");
			checkString(cep, "O Cep");
			checkString(bairro, "O Bairro");
			checkNumber(numero, "O Número da residência");
		}catch(InvalidArgumentException ex){
			throw new InvalidArgumentException("Erro no endereco carregado: " + ex.getMessage());
		}
		
	}
	
	/* O builder pode ser utilizado para montar um endereco com
	   o metodo build, para adicionar os parametros utilizamos os
	   metodos abaixo */
	
	/* A forma que utilizamos para construir um endereco e a 
	   seguinte:
	  
	   Endereco end = new EnderecoControl().setEndereco("End").build(); */
	
	public EnderecoControl setId(int id){
		this.id = id;
		return this;
	}
	
	public EnderecoControl setBairro(String bairro){
		this.bairro = bairro;
		return this;
	}

	public EnderecoControl setCep(String cep){
		this.cep = cep;
		return this;
	}

	public EnderecoControl setCidade(String cidade){
		this.cidade = cidade;
		return this;
	}

	public EnderecoControl setComplemento(String complemento){
		this.complemento = complemento;
		return this;
	}

	public EnderecoControl setEstado(String estado){
		this.estado = estado;
		return this;
	}

	public EnderecoControl setNumero(int numero){
		this.numero = numero;
		return this;
	}

	public EnderecoControl setPais(String pais){
		this.pais = pais;
		return this;
	}

	public EnderecoControl setLogradouro(String logradouro){
		this.logradouro = logradouro;
		return this;
	}

	public EnderecoControl setTipoLogradouro(String tipoLogradouro){
		this.tipoLogradouro = tipoLogradouro;
		return this;
	}

	/* TODO: 1.2 - Se existir um endereco, devolvemos ele senao lancamos uma excecao*/
	public Endereco getWithId(int id) throws DataBaseException{
		try{
			return EnderecoDao.getWithId(id);
		}catch(SQLException e){
			throw new DataBaseException("erro no EnderecoDao");
		}
	}
}
