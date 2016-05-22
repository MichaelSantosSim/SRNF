package br.com.srnf.notafiscal.test;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.srnf.notafiscal.bean.Endereco;
import br.com.srnf.notafiscal.bean.Tomador;
import br.com.srnf.notafiscal.dao.EnderecoDao;
import br.com.srnf.notafiscal.dao.TomadorDao;

public class TestMenu {
	
	
	public static void showMenu(){
		Scanner scan = new Scanner(System.in);
		int option = -1;
		
		while(option != 0){  
			System.out.println("1 - exibir um item da tabela\n2 - Adicionar um novo item\n3 - Adicionar novo Tomador\n0 - Sair");
			option = scan.nextInt();
			switch(option){
				case 1 : System.out.print("Digite o id: "); showEndereco(scan.nextInt());break;
				case 2 : cadastrarNovoEndereco();break;
				case 3 : cadastrarNovoTomador();
			}
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
			System.out.println("\nID Endereco: ");
			tomador.setEndereco(EnderecoDao.getWithId(scan.nextInt()));
		} catch (SQLException e) {
			System.out.println("ERRO, ID DO ENDERECO NAO ENCONTRADO!\n" + e.getMessage());
		}
		
		try {
			TomadorDao.addTomador(tomador);
		} catch (SQLException e) {
			System.out.println("ERRO AO CADASTRAR TOMADOR\n" + e.getMessage());
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
		}
		
	}
	
	public static void showEndereco(int id){
		try{
			Endereco endereco = EnderecoDao.getWithId(id);
			
//			Rua Pequeno Principe, 154 - Bloco 6 apto 7
//			Recanto das Flores, Cratera/MT
//			Cep 12345-678 - Marte.
			
			System.out.println();
			
			String res =  endereco.getTipoLogradouro() + " "
						+ endereco.getLogradouro() + ", "
						+ endereco.getNumero() + " - "
						+ endereco.getComplemento() + "\n"
						+ endereco.getBairro() + ", "
						+ endereco.getCidade() + "/"
						+ endereco.getEstado() + "\nCep: "
						+ endereco.getCep() + " - "
						+ endereco.getPais() + ".\n";
			
			System.out.println(res);
			
		}catch(SQLException e){
			System.out.println("NAO FOI POSSIVEL EXIBIR O ENDERECO");
		}
	}
}
