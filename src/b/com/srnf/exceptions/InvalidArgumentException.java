package b.com.srnf.exceptions;


/** 
* Classe que representa uma exceção para os campos inválidos para 
* Tomador, Endereco e NotaFiscal
*/
public class InvalidArgumentException extends Exception {
	
	private static final long serialVersionUID = 1L;
	String message = "Parâmetro incorreto!";
	
	/** 
	 * Construtor da classe
	 * @param msg - mensagem a ser exibida
	 */
	public InvalidArgumentException(String msg){
		this.message = msg;
	}
	
	/** 
	 * Define a mensagem que será exibida na exceção
	 * 
	 * @param msg - mensagem a ser exibida
	 */
	public void setMessage(String msg){
		this.message = msg;
	}
	
	/** 
	 * Retorna a mensagem a ser exibida
	 * 
	 * @return mensagem a ser exibida
	 */
	public String getMessage(){
		return message;
	}
	
	
}
