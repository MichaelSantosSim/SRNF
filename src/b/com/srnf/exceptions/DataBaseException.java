package b.com.srnf.exceptions;

public class DataBaseException extends Exception {
	String message = "Erro no banco de dados";
	
	
	public DataBaseException(String message){
		this.setMessage(message);
	}
	
	public void setMessage(String message){
		this.message.concat(": " + message);
	}
	
	public String getMessage(){
		return message;
	}
}
