package br.com.srnf.notafiscal;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import b.com.srnf.exceptions.InvalidArgumentException;
import br.com.srnf.control.AbstractControl;
import br.com.srnf.control.EnderecoControl;
import br.com.srnf.control.TomadorControl;
import br.com.srnf.notafiscal.bean.Endereco;
import br.com.srnf.notafiscal.test.TestMenu;

import javax.swing.JButton;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/* TODO: 1 - Voce validou o cpf/cnpj agora tem que terminar as validacoes dos campos de tomador */
	
	
	
	public static void main(String[] args) {
		
//		TomadorControl tc = new TomadorControl();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Digite o cnpj: ");
//		
//		if(tc.validateCnpj(scan.next())){
//			System.out.println("Ok");
//		}else{
//			System.out.println("Not Ok");
//		}
//		
//		scan.close();
		
		try{
			TestMenu.showMenu();
		}catch(InvalidArgumentException e){
			System.out.println(e.getMessage());
		}
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					View frame = new View();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Nota Fiscal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBotao = new JButton("Botao");
		btnBotao.setBounds(155, 114, 97, 25);
		contentPane.add(btnBotao);
	}
}
