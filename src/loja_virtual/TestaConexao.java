package loja_virtual;

import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.createConnection();
		connectionFactory.closeConnection();
	}
}
