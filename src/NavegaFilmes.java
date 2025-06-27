package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.BD;

public class NavegaFilmes extends JFrame {
 private JLabel  label1, label2,label3,label4,label5;
 private JButton btProximo,btAnterior,btPrimeiro, btUltimo,btMais10,btMenos10,btSair;
 private JTextField tfCodigo,tfTitulo,tfGenero,tfProdutora,tfDataCom;
 private BD bd;
 private PreparedStatement stm;
 private ResultSet result;
 
 
	public static void main(String[] args) {
		JFrame frame = new NavegaFilmes();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
	}
	
	public NavegaFilmes() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		label1 = new JLabel("Código");
		add(label1);
		tfCodigo = new JTextField(10);
		add(tfCodigo); 		
		label2 = new JLabel("Titulo");
		add(label2);
		tfTitulo = new JTextField(35);
		add(tfTitulo);
		label3 = new JLabel("Genero");
		add(label3);
		tfGenero = new JTextField(10);
		add(tfGenero);
		label4 = new JLabel("Produtora");
		add(label4);
		tfProdutora = new JTextField(15);
		add(tfProdutora);
		label5 = new JLabel("Data De Compra");
		add(label5);
		tfDataCom = new JTextField(8);
		add(tfDataCom);
		
		
		btPrimeiro = new JButton("Primeiro");
		add(btPrimeiro);
		btUltimo = new JButton("Ultimo");
		add(btUltimo);
		btProximo = new JButton(">");
		add(btProximo);
		btAnterior = new JButton("<");
		add(btAnterior);
		btMais10 = new JButton(">10");
		add(btMais10);
		btMenos10 = new JButton("<10");
		add(btMenos10);
		btSair = new JButton("Sair");
		add(btSair);
		
		
		btProximo.setToolTipText("Proximo");
		btAnterior.setToolTipText("Anterior");
		btPrimeiro.setToolTipText("Primeiro");
		btUltimo.setToolTipText("Ultimo");
		btMais10.setToolTipText("Mais10");
		btMenos10.setToolTipText("Menos10");
		
		setTitle("Navegando na tabela de filmes");
		setBounds(200,400,620,150);
		setResizable(false); 
		bd = new BD();
		if (!bd.getConnection()) {
			JOptionPane.showMessageDialog(null, "Falha ao conectar no banco de dados");
		}
		carregarTabela();
		atualizarCampos();
		
	}
	private void definirEventos() {
		
		btProximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		
		btAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		btPrimeiro.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	});

		btUltimo.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		});

		btMais10.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		});

		btMenos10.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		});

		btSair.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		});
		
	}
	
	private void carregarTabela() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM filmes";
		try {
			stm = bd.conn.prepareStatement(sql);
			result = stm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro!"+e.toString());
		}
		
	}

	private void atualizarCampos() {
		try {
			if (result.isAfterLast()) {
				result.last();
			}
			
			if (result.isBeforeFirst()) {
				result.first();
			} 			
			tfCodigo.setText(result.getString("Código"));
			tfTitulo.setText(result.getString("Titulo"));
			tfGenero.setText(result.getString("Genero"));
			tfProdutora.setText(result.getString("Produtora"));
			tfDataCom.setText(result.getString("DataCompra"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}



}
