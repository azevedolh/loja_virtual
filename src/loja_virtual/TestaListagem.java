package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem { 

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().createConnection();
		
		String sqlQuery = "SELECT * FROM PRODUTO";
		
//		Statement stm = connection.createStatement();
		
		PreparedStatement stm = connection.prepareStatement(sqlQuery);
		stm.execute();
		System.out.println("<<LOG>> Query executada: " + sqlQuery);
		ResultSet resultado = stm.getResultSet();
		
		while (resultado.next()) {
			System.out.println(resultado.getInt("id"));
			System.out.println(resultado.getString("nome"));
			System.out.println(resultado.getString("descricao"));
		}
		
		connection.close();
		System.out.println("<<LOG>> Conexão Encerrada");

	}
}
