package loja_virtual;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.createConnection();
		
		ResultSet resultado = connectionFactory.executeSelectStatement("SELECT * FROM PRODUTO");
		
		while (resultado.next()) {
			System.out.println(resultado.getInt("id"));
			System.out.println(resultado.getString("nome"));
			System.out.println(resultado.getString("descricao"));
		}
		
		connectionFactory.closeConnection();
	}

}
