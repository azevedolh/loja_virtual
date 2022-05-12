package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().createConnection();
		connection.close();
		System.out.println("<<LOG>> Conexão Encerrada");
	}
}
