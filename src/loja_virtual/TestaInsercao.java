package loja_virtual;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.createConnection();
		
		ResultSet resultado = connectionFactory.executeInsertStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('Geladeira', 'Geladeira Azul')");
		
		while (resultado.next()) {
			System.out.println("Id Inserido: " + resultado.getInt(1));
		}
		
		connectionFactory.closeConnection();
	}

}
