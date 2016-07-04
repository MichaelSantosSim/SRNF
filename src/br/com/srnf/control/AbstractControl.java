package br.com.srnf.control;

import b.com.srnf.exceptions.InvalidArgumentException;

public abstract class AbstractControl {
	
	protected String emptyStringMessage = " deve ser informado!";
	protected String invalidNumberMessage = " deve ser maior que zero!";
	protected String invalidFieldMessage = " é inválido!";
	
	
	/**
	 * Verifica se uma string é nula ou vazia ou lanca uma {@link InvalidArgumentException}
	 * 
	 * @param s - a string a ser verificada
	 * @param field - o nome do campo que esta sendo veficado
	 * @throws InvalidArgumentException terá a mensagem que o campo que esta vazio deve ser informado
	 */
	protected void checkString(String s, String field) throws InvalidArgumentException{
		if(!validString(s)){
			throw new InvalidArgumentException(field + emptyStringMessage);
		}
	}
	
	/**
	 * Verifica se um numero inteiro é maior que zero
	 * 
	 * @param n - O número a ser verificado
	 * @param field - O nome do campo verificado
	 * @throws InvalidArgumentException terá a mensagem que o campo que esta vazio deve ser maior que zero
	 */
	protected void checkNumber(int n, String field) throws InvalidArgumentException{
		if(!validNumber(n)){
			throw new InvalidArgumentException(field + invalidNumberMessage);
		}
	}
	
	/**
	 * Verifica se um numero flutuante é maior que zero ou lanca uma {@link InvalidArgumentException}
	 * 
	 * @param n - O número a ser verificado
	 * @param field - O nome do campo verificado
	 * @throws InvalidArgumentException terá a mensagem que o campo que esta vazio deve ser maior que zero
	 */
	protected void checkNumber(float n, String field) throws InvalidArgumentException{
		if(!validNumber(n)){
			throw new InvalidArgumentException(field + invalidNumberMessage);
		}
	}
	
	/**
	 * Verifica se ou o cpf ou o cnpj é valido ou lanca uma {@link InvalidArgumentException}
	 * @param cpf - uma string que representa um cpf e outra o cnpj
	 * @throws InvalidArgumentException exceção com a mensagem de erro
	 */
	public void checkCpfCnpj(String cpf, String cnpj)throws InvalidArgumentException{
		if(!validateCpf(cpf) && !validateCnpj(cnpj)){
			throw new InvalidArgumentException("O CPF / Cnpj digitado" + invalidFieldMessage);
		}
	}
	
	
	/**
	 * Verifica se um cpf é válido
	 * <br/><br/>
	 * Verifica se o tamanho do cpf está correto<br/>
	 * Verifica se o 10º numero é o modCpf dos anteriores<br/>
	 * Verifica se o 11º numero é modCpf dos anteriores junto com o 10º<br/>
	 * 
	 * @param cpf - uma string que representa um cpf
	 * @return um boolean que representa a validade do cpf
	 * 
	 */
	private Boolean validateCpf(String cpf){
		return (cpf.length() == 11 && cpfMod(cpf.substring(0, cpf.length() - 1)) && cpfMod(cpf));
	}
	
	/**
	 * Validador de mod 11 para cpf
	 * <br/>
	 * Valida se o último dígito é válido como mod dos numeros anteriores
	 * de traz para frente ficam
	 * 
	 * 10 09 08 07 06 05 04 03 02
	 * e
	 * 11 10 09 08 07 06 05 04 03 02
	 * 
	 * @param input - uma string que representa um conjunto de numeros
	 * @return Um boolean que representa a validade da string informada
	 */
	private Boolean cpfMod(String input){
		
		/*
		 	Alinhar o cpf com esses numeros e fazer a soma das multiplicacoes 
		 	O numero 10 e substituido por X
		 	+----+----+----+----+----+----+----+----+----+
		 	| 10 | 09 | 08 | 07 | 06 | 05 | 04 | 03 | 02 |
		 	+----+----+----+----+----+----+----+----+----+
		 	| 1  |  1 |  1 |  4 |  4 |  4 |  7 |  7 |  7 |
		 	+----+----+----+----+----+----+----+----+----+
		*/
		
		int sum = 0;
		for(int i = 0; i < input.length(); i++){
			sum += (input.charAt(i) == 'X' ? 10 : Character.getNumericValue(input.charAt(i))) * (input.length() - i);
		}
		return (sum%11 == 0);
	}
	
	
	public Boolean validateCnpj(String cnpj){
		return (cnpjMod(cnpj.substring(0, cnpj.length() - 1)) && cnpjMod(cnpj.substring(0, cnpj.length())));
	}
	
	/**
	 * Validador de mod 11 para cnpj
	 * <br/>
	 * Valida se o último dígito é válido como mod dos numeros anteriores
	 * As diferencas ficam por conta de que ele nao verifica numeros acima de 9
	 * e que restos abaixo de 2 se tornam 0
	 * de tras para frente ficam
	 *
	 * 5 4 3 2 9 8 7 6 5 4 3 2 
	 * e
 	 * 6 5 4 3 2 9 8 7 6 5 4 3 2
	 * @param input - uma string que representa um conjunto de numeros
	 * @return Um boolean que representa a validade da string informada
	 */
	public Boolean cnpjMod(String str){
		
		/* Alinhar o cnpj com esses numeros e fazer a soma das multiplicacoes 
					 +----+----+----+----+----+----+----+----+----+----+----+----+
			numeros	 | 5  |  4 |  3 |  2 |  9 |  8 |  7 |  6 |  5 |  4 |  3 | 2  |
					 +----+----+----+----+----+----+----+----+----+----+----+----+
			cnpj	 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 | 11 | 12 |
					 +----+----+----+----+----+----+----+----+----+----+----+----+
					 
		   (((i%8)%10)+2) : 
			
		   conta de 9 ate 2 em um loop do tamanho da string recebida
		   e multiplica o valor resultante pelo numero do char no
		   respectivo indice na string */
		
		int sum = 0;
		int lenght = str.length() - 2;
		
		for(int i = lenght; i >= 0; i--){
			
			int numAtStrIndex = Character.getNumericValue(str.charAt(lenght - i));
			int valueToMultiply = (((i%8)%10)+2);
			sum += (valueToMultiply * numAtStrIndex);
		}
		
		/*	Caso o resto da divisão seja menor que 2 o valor do dígito
			verificador passa a ser 0, caso contrário subtraímos o valor
			de 11 para obter o dígito, que é o nosso caso, portanto nosso
			primeiro dígito verificador é (11 - 3) o número 8. */
		
		int fvd = sum%11;
		
		fvd = fvd < 2 ? 0 : (11 - fvd);
		
		/* lenght é o indice que calculamos todos os numeros
		 * exceto o ultimo portanto somamos 1 para ver o ultimo*/
		if(str.charAt(lenght +1) != (char)(fvd + '0')){
			return false;
		}
		return true;
	}
	
	/**
	 * Verifica se a string é valida
	 * <br/>
	 * Caso nao seja nula ou nao seja vazia
	 * 
	 * @param s - A string a ser verificada
	 * @return representacao da validade da string
	 */
	private Boolean validString(String s){
		return (s != null && s.length() > 0);
	}
	
	/**
	 * Verifica se um numero inteiro é maior que zero
	 * 
	 * @param n - O número a ser verificado
	 * @return representacao da validade do numero
	 */
	private Boolean validNumber(int n){
		return n > 0;
	}
	
	/**
	 * Verifica se um numero flutuante é maior que zero
	 * 
	 * @param n - O número a ser verificado
	 * @return representacao da validade do numero
	 */
	private Boolean validNumber(float n){
		return n > 0;
	}

}
