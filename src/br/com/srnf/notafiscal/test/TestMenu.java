package br.com.srnf.notafiscal.test;

import java.sql.SQLException;
import java.util.Scanner;

import b.com.srnf.exceptions.InvalidArgumentException;
import br.com.srnf.notafiscal.bean.Endereco;
import br.com.srnf.notafiscal.bean.NotaFiscal;
import br.com.srnf.notafiscal.bean.Tomador;
import br.com.srnf.notafiscal.dao.EnderecoDao;
import br.com.srnf.notafiscal.dao.NotaFiscalDao;
import br.com.srnf.notafiscal.dao.TomadorDao;

public class TestMenu {
	
	
	public static void showMenu() throws InvalidArgumentException{
		
		Scanner scan = new Scanner(System.in);
		int option = -1;
		
		while(option != 0){  
			System.out.println("1 - Exibir Endereco\n2 - Adicionar um novo Endereco\n3 - Adicionar novo Tomador\n"
					+ "4 - Exibir Tomador\n5 - exibir nota fiscal\n6 - cadastrar nota fiscal\n0 - Sair");
			option = scan.nextInt();
			switch(option){
				case 1 : System.out.print("Digite o id: "); showEndereco(scan.nextInt()); break;
				case 2 : cadastrarNovoEndereco(); break;
				case 3 : cadastrarNovoTomador(); break;
				case 4 : System.out.print("Digite o id: "); showTomador(scan.nextInt()); break;
				case 5 : System.out.println("Digite o id: "); showNotaFiscal(scan.nextInt());break;
				case 6 : cadastrarNovaNotaFiscal();break;
				case 0 : System.out.println("Saindo..."); break;
				default : System.out.println("Selecione uma opcao valida"); break;
			}
		}
		
		scan.close();
	}
	
	public static void showNotaFiscal(int id){
		try{
			NotaFiscal nota = NotaFiscalDao.getWithId(id);
			System.out.println();
			System.out.println(getString(nota));
		}catch(SQLException e){
			System.out.println("ShowNotaFiscal erro: " + e.getMessage());
		}
	}
	
	public static void cadastrarNovaNotaFiscal(){
		Scanner scan = new Scanner(System.in);
		NotaFiscal nota = new NotaFiscal();
		
		try {
			System.out.println("Cadastrar nova nota fiscal");
			
			System.out.print("ID Tomador: ");
			nota.setTomador(TomadorDao.getWithId(scan.nextInt()));
			
			System.out.print("Atividade: ");
			nota.setAtividade(scan.nextLine());
			
			scan.nextLine();
			System.out.print("Informacoes adicionais: ");
			nota.setInformacoesAdicionais(scan.nextLine());
			
			System.out.print("Valor: R$ ");
			nota.setValor(scan.nextFloat());
			
			System.out.print("Valor IR: R$ ");
			nota.setValorIr(scan.nextFloat());
			
			System.out.print("Valor INSS: R$ ");
			nota.setValorInss(scan.nextFloat());
			
			System.out.print("Valor Cofins: R$ ");
			nota.setValorCofins(scan.nextFloat());
			
			System.out.print("Valor pis/pasep: R$ ");
			nota.setValorPisPasep(scan.nextFloat());
			
			System.out.print("CLSS: R$ ");
			nota.setCsll(scan.nextFloat());
			
			System.out.print("Valor outros impostos: R$ ");
			nota.setValorOutrosImpostos(scan.nextFloat());
			
			System.out.print("Substituicao Tributaria: ");
			nota.setSubstituicaoTributaria(scan.nextBoolean());
			
			System.out.print("Notificar via email: ");
			nota.setNotificarTomadorPorEmail(scan.nextBoolean());
			
			System.out.println("\nPrestacao de Servico:");
			
			scan.nextLine();
			System.out.print("Endereco ");
			nota.setEnderecoPrestacaoServico(scan.nextLine());
			
			System.out.print("Cidade: ");
			nota.setCidadePrestacaoServico(scan.nextLine());
			
			System.out.print("CEP: ");
			nota.setCepPrestacaoServico(scan.nextLine());
			
			System.out.print("Estado: ");
			nota.setEstadoPrestacaoServico(scan.nextLine());
			
			System.out.println();
			NotaFiscalDao.addNotaFiscal(nota);
		} catch (SQLException e) {
			System.out.println("CadastarNovaNota Erro: " + e.getMessage());
		}finally{
			scan.close();
		}
	}
	
	public static void cadastrarNovoTomador(){
		Scanner scan = new Scanner(System.in);
		Tomador tomador = new Tomador();
		System.out.println("Cadastrar novo Tomador:");
		
		System.out.print("\nNome: ");
		tomador.setNome(scan.nextLine());
		System.out.print("\nCnpj(deixe em branco caso nao tenha): ");
		tomador.setCnpj(scan.next());
		System.out.print("\nCPF (deixe em branco caso nao tenha): ");
		tomador.setCpf(scan.next());
		System.out.print("\nInscricao Municipal: ");
		tomador.setInscricaoMunicipal(scan.next());
		System.out.print("\nDDD: ");
		tomador.setDdd(scan.nextInt());
		System.out.println("\nTelefone: ");
		tomador.setTelefone(scan.next());
		
		
		try {
			System.out.print("\nID Endereco: ");
			tomador.setEndereco(EnderecoDao.getWithId(scan.nextInt()));
			TomadorDao.addTomador(tomador);
		} catch (SQLException e) {
			System.out.println("ERRO AO CADASTRAR TOMADOR\n" + e.getMessage());
		}finally{
			scan.close();
		}
	}
	
	public static void showTomador(int id){
		try{
			
			Tomador tomador = TomadorDao.getWithId(id);
			System.out.println();
			System.out.println(getString(tomador));
			
		}catch(SQLException e){
			System.out.println("ShowTomador Erro " + e.getMessage());
		}
	}
	
	public static void cadastrarNovoEndereco(){
		Scanner scan = new Scanner(System.in);
		Endereco endereco = new Endereco();
		
		System.out.println("Cadastrar novo Endereco: ");
		
		System.out.print("Tipo de Logradouro: ");
		endereco.setTipoLogradouro(scan.nextLine());
		
		System.out.print("Logradouro: ");
		endereco.setLogradouro(scan.nextLine());
		
		System.out.print("Numero: ");
		endereco.setNumero(scan.nextInt());
		
		scan.nextLine();							// o nextline da problema depois de next ou nextint
		System.out.print("Complemento: ");
		endereco.setComplemento(scan.nextLine());
		
		System.out.print("Bairro: ");
		endereco.setBairro(scan.nextLine());
		
		System.out.print("Cidade: ");
		endereco.setCidade(scan.nextLine());
		
		System.out.print("CEP: ");
		endereco.setCep(scan.nextLine().substring(0, 8));
		
		System.out.print("Estado: ");
		endereco.setEstado(scan.next().substring(0, 2));
		
		scan.nextLine();
		System.out.print("Pais: ");
		endereco.setPais(scan.nextLine());
		
		try {
			EnderecoDao.addEndereco(endereco);
		} catch (SQLException e) {
			System.out.println("NAO FOI POSSIVEL SALVAR O ENDERECO");
		}finally{
			scan.close();
		}
		
	}
	
	public static void showEndereco(int id){
		try{
			
			Endereco endereco = EnderecoDao.getWithId(id);
			System.out.println();
			System.out.println(getString(endereco));
			
		}catch(SQLException e){
			System.out.println("NAO FOI POSSIVEL EXIBIR O ENDERECO");
		}
	}
	
	public static String getString(Tomador tomador){
		return "Nome: " + tomador.getNome() + "\n"
				+ "CNPJ: " + tomador.getCnpj() + "\n"
				+ "CPF: " + tomador.getCpf() + "\n"
				+ "Inscr. Municip.: " + tomador.getInscricaoMunicipal() + "\n"
				+ "Telefone: (" + tomador.getDdd() + ")" + tomador.getTelefone() + "\n"
				+ "Endereco: \n"
				+ getString(tomador.getEndereco());
	}
	
	public static String getString(Endereco endereco){
		return endereco.getTipoLogradouro() + " "
				+ endereco.getLogradouro() + ", "
				+ endereco.getNumero() + " - "
				+ endereco.getComplemento() + "\n"
				+ endereco.getBairro() + ", "
				+ endereco.getCidade() + "/"
				+ endereco.getEstado() + "\nCep: "
				+ endereco.getCep() + " - "
				+ endereco.getPais() + ".\n";
	}
	
	public static String getString(NotaFiscal nota){
		return getString(nota.getTomador()) + "\n"
					+ (nota.isTomadorEstrangeiro() ? "Tomador Estrangeiro" : "Tomador nao estrangeiro") + "\n"
					+ nota.getInformacoesAdicionais() + "\n"
					+ nota.getAtividade()
					+ "\nValor: " + nota.getValor()
					+ "\nValor IR: " + nota.getValorIr()
					+ "\nValor Inss: " + nota.getValorInss()
					+ "\nValor Cofins: " + nota.getValorCofins()
					+ "\nValor PIS / PASEP: " + nota.getValorPisPasep()
					+ "\nValor CSLL: " + nota.getCsll()
					+ "\nValor outros impostos: " + nota.getValorOutrosImpostos() + "\n"
					+ (nota.isSubstituicaoTributaria() ? "Nao t" : "T")
					+ "em substituicao tributaria\n"
					+ (nota.isNotificarTomadorPorEmail() ? "Nao n" : "N")
					+ "otificar tomador via email\n"
					+ "Prestacao de Servico: "
					+ "\nEndereco: " + nota.getEnderecoPrestacaoServico()
					+ "\nCidade: " + nota.getCidadePrestacaoServico()
					+ "\nCEP: " + nota.getCepPrestacaoServico()
					+ "\nEstado: " + nota.getEstadoPrestacaoServico() + "\n";
	}
}
