package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().createConnection();
		
		String sqlQuery = "DELETE FROM PRODUTO WHERE ID > ?";
		int id = 2;
		
//		Statement stm = connection.createStatement();
		PreparedStatement stm = connection.prepareStatement(sqlQuery);
		stm.setInt(1, id);
		stm.execute();
		System.out.println("<<LOG>> Query executada: " + sqlQuery);
		
		System.out.println("Quantidade de linhas deletadas do banco: " + stm.getUpdateCount());
		
		connection.close();
		System.out.println("<<LOG>> Conexão Encerrada");
	}

}
