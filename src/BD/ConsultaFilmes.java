package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConsultaFilmes {

	public static void main(String[] args) {
		final String DRIVER  = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/banco";
		
		try {
			Class.forName(DRIVER);
			Connection connection  = DriverManager.getConnection(URL,"root","senai@126");
			
			String sql = "SELECT codigo, titulo FROM filmes ORDER BY codigo";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Codigo titulo                           ");
			System.out.println("_______   _______________________________");
			while(resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String titulo = resultSet.getString("titulo");
				System.out.println(codigo+"    "+titulo);
			}
			resultSet.close();
			statement.close();
			connection.close();
			

		} catch (ClassNotFoundException erro) {
			JOptionPane.showMessageDialog(null, "Driver de conexão não encontrado"+erro.toString());
		}catch ( SQLException erro) {
			JOptionPane.showMessageDialog(null, "Usuariio ou senha inválido");
		}

	}

}
