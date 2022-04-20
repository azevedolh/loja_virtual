package loja_virtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	private Connection connection;

	public void createConnection() throws SQLException {
		this.connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "teste");
		System.out.println("<<LOG>> Conexão realizada com sucesso");
	}
	
	public void closeConnection() throws SQLException {
		this.connection.close();
		System.out.println("<<LOG>> Conexão Encerrada");
	}
	
	public ResultSet executeSelectStatement(String sqlQuery) throws SQLException {
		Statement stm = this.connection.createStatement();
		stm.execute(sqlQuery);
		System.out.println("<<LOG>> Query executada: " + sqlQuery);
		return stm.getResultSet();
	}
	
	public ResultSet executeInsertStatement(String sqlQuery) throws SQLException {
		Statement stm = this.connection.createStatement();
		stm.execute(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		System.out.println("<<LOG>> Query executada: " + sqlQuery);
		return stm.getGeneratedKeys();
	}
	
	public int executeDeleteStatement(String sqlQuery) throws SQLException {
		Statement stm = this.connection.createStatement();
		stm.execute(sqlQuery);
		System.out.println("<<LOG>> Query executada: " + sqlQuery);
		return stm.getUpdateCount();
	}
}
