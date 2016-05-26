package br.com.srnf.notafiscal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.srnf.notafiscal.bean.Endereco;
import br.com.srnf.notafiscal.dao.EnderecoDao;
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
	

	
	public static void main(String[] args) {
		TestMenu.showMenu();		
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
