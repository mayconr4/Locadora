package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConsultaFilmes2 {

	public static void main(String[] args) {
		BD bd = new BD();// Criando instância na classe BD
		
		if(bd.getConnection()) {//Estabelecendo coonexão
			Connection connection = bd.conn;//Acessando o objeto de conexão
			
			String sql ="SELECT codigo, titulo FROM filmes ORDER BY codigo";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
				
				System.out.println("Código Título");
				System.out.println("______ __________________________________");
				
				while(resultSet.next()) {
					String codigo = resultSet.getString("codigo");
					String titulo = resultSet.getString("titulo");
					System.out.println(codigo+"    "+titulo);
					
				}
				
				resultSet.close();
				statement.close();        			
		
			}catch ( SQLException erro) {
				JOptionPane.showMessageDialog(null, "Usuariio ou senha inválido");
			}finally {
				bd.close();//Encerrando conexão
			} 			
			
		}

	}

}
